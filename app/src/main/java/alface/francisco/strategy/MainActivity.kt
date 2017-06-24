package alface.francisco.strategy

import alface.francisco.strategy.domain.UploadPictures
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

  val uploadPictures = UploadPictures()

  val pictures = arrayListOf(File("IMAGE_001.jpg"), File("IMAGE_002.jpg"), File("IMAGE_003.jpg"), File("IMAGE_004.jpg"),
      File("IMAGE_005.jpg"), File("IMAGE_006.jpg"), File("IMAGE_007.jpg"), File("IMAGE_008.jpg"), File("IMAGE_009.jpg"),
      File("IMAGE_010.jpg"), File("IMAGE_011.jpg"), File("IMAGE_012.jpg"), File("IMAGE_013.jpg"), File("IMAGE_014.jpg"),
      File("IMAGE_015.jpg"), File("IMAGE_016.jpg"), File("IMAGE_018.jpg"), File("IMAGE_019.jpg"), File("IMAGE_020.jpg"))

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    button.setOnClickListener {
      text.text = "Uploading pictures ... \n \n"
      uploadPictures(uploadPictures.uploadMetadata)
      uploadPictures(uploadPictures.uploadThumbnail)
      uploadPictures(uploadPictures.uploadOriginal)
    }
  }

  fun uploadPictures(uploadPictureStrategy: (File) -> String) {
    uploadPictures.changeStrategy(uploadPictureStrategy)

    pictures
        .map { uploadPictures.upload(it) }
        .forEach {
          text.text = "${text.text} \n $it"
        }

    text.text = "${text.text} \n\n-----------------------"
  }
}

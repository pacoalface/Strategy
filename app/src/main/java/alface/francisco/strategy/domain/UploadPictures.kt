package alface.francisco.strategy.domain

import java.io.File

/**
 * Created by franciscoalfacemartin on 24/6/17.
 */
class UploadPictures {

  //Strategies
  val uploadMetadata: (File) -> String = {
    "Extracting ${it.name} metadata... DONE \n Uploading ${it.name} metadata... DONE\n"
  }

  val uploadThumbnail: (File) -> String = {
    "Scaling ${it.name} picture to 128px... DONE \n Uploading ${it.name} thumb... DONE\n"
  }

  val uploadOriginal: (File) -> String = {
    "Uploading ${it.name} picture... DONE"
  }

  var currentStrategy = uploadMetadata

  fun changeStrategy(uploadPictureStrategy: (File) -> String) {
    currentStrategy = uploadPictureStrategy
  }

  fun upload(file: File): String {
    return currentStrategy.invoke(file)
  }

}
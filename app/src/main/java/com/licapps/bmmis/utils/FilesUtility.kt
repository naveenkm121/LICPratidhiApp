package com.licapps.bmmis.utils

import android.content.Context
import android.os.Environment
import com.licapps.bmmis.constants.Constants
import okhttp3.ResponseBody
import timber.log.Timber
import java.io.*

class FilesUtility {


    companion object {
        fun createFileInStorage(context: Context, fileName: String): File? {
            val timeStamp: String = System.currentTimeMillis().toString() + Constants.PDF
            val name = if (fileName.isBlank()) timeStamp else fileName
            return File(getAppFilesDir(context), name)
        }

        fun createFileInExternalStorage(context: Context, fileName: String): File? {
            val timeStamp: String = System.currentTimeMillis().toString() + Constants.PDF
            val name = if (fileName.isBlank()) timeStamp else fileName
            return File(getAppExternalFilesDir(context), name)
        }

        private fun getAppFilesDir(context: Context): File? {
            val file = context.filesDir
            if (file != null && !file.exists()) {
                file.mkdirs()
            }
            return file
        }

        private fun getAppExternalFilesDir(context: Context): File? {
            val file = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            if (file != null && !file.exists()) {
                file.mkdirs()
            }
            return file
        }

        fun saveFileInAppExternalDirectory(context: Context, body: ResponseBody) {
            val file = createFileInExternalStorage(
                context,
                "test.pdf"
            )
            Timber.d("file path %s", file!!.absolutePath)
            if (!file.exists()) {
                file.createNewFile()
            }
            var inputStream: InputStream? = null
            var outputStream: OutputStream? = null
            try {
                val fileReader = ByteArray(4096)
                val fileSize = body.contentLength()
                var fileSizeDownloaded: Long = 0
                inputStream = body.byteStream()
                outputStream = FileOutputStream(file)
                while (true) {
                    val read: Int = inputStream.read(fileReader)
                    if (read == -1) {
                        break
                    }
                    outputStream.write(fileReader, 0, read)
                    fileSizeDownloaded += read.toLong()
                    //Timber.d(TAG, "file download: $fileSizeDownloaded of $fileSize")
                }
                outputStream.flush()
                true
            } catch (e: IOException) {
                false
            } finally {
                inputStream?.close()
                outputStream?.close()
            }
        }
    }
}

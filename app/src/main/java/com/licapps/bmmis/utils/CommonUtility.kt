package com.licapps.bmmis.utils

import android.app.Activity
import android.app.DownloadManager
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.icu.text.CompactDecimalFormat
import android.icu.text.NumberFormat.CURRENCYSTYLE
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Base64
import android.util.Patterns
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import com.google.gson.Gson
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.data.model.SpinnerItemModel
import com.licapps.bmmis.data.model.util.AppDataInfo
import com.licapps.bmmis.ui.activities.LaunchActivity
import timber.log.Timber
import java.io.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.HashMap


class CommonUtility {


    companion object {

        val DATE_FORMAT_DDMMYYYY: String = "dd-MM-yyyy"
        val DATE_FORMAT_YYYYMMDD: String = "yyyy-MM-dd"


        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }


        fun getTodayDateForNBDDMMYYYY(): String {
            var date = System.currentTimeMillis()

            val sdf = SimpleDateFormat(DATE_FORMAT_DDMMYYYY)
            var todayDate = sdf.format(date)
            var days = todayDate.substring(0, 2).toInt()
            if (days > 28)
                date -= ((days - 28) * 24 * 60 * 60 * 1000)
            DebugHandler.log(" NBD Date ::" + sdf.format(date))
            return sdf.format(date)
        }

        fun getTodayDateForNBYYYYMMDD(): String {
            return try {
                var date = System.currentTimeMillis()

                val sdf = SimpleDateFormat(DATE_FORMAT_YYYYMMDD)
                var todayDate = sdf.format(date)
                var days = todayDate.substring(8, 10).toInt()
                if (days > 28)
                    date -= ((days - 28) * 24 * 60 * 60 * 1000)
                return sdf.format(date)

            } catch (e: Exception) {
                ""
            }

        }

        fun getTodayDateYYYYMMDD(): String {
            return try {
                val date = System.currentTimeMillis()

                val sdf = SimpleDateFormat(DATE_FORMAT_YYYYMMDD)
                return sdf.format(date)

            } catch (e: Exception) {
                ""
            }


        }

        fun getTodayDateDDMMYYYY(): String {
            val date = System.currentTimeMillis()

            val sdf = SimpleDateFormat(DATE_FORMAT_DDMMYYYY)
            return sdf.format(date)
        }

        fun isValidEmail(target: CharSequence?): Boolean {
            return if (TextUtils.isEmpty(target)) {
                false
            } else {
                Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }
        }

        fun isValidPinCode(pinCode: String?): Boolean {

            val regex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$"
            val p: Pattern = Pattern.compile(regex)
            if (pinCode == null) {
                return false
            }
            val m: Matcher = p.matcher(pinCode)
            return m.matches()
        }

        fun isValidPhoneNumber(phoneNumber: String?): Boolean {

            val regex = "^[6-9]\\d{9}\$"
            val p: Pattern = Pattern.compile(regex)
            if (phoneNumber == null) {
                return false
            }
            val m: Matcher = p.matcher(phoneNumber)
            return m.matches()
        }

        fun isValidPANNumber(panNumber: String?): Boolean {

            val regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
            val p: Pattern = Pattern.compile(regex)
            if (panNumber == null) {
                return false
            }
            val m: Matcher = p.matcher(panNumber)
            return m.matches()
        }


        fun getDateYYYYMMDDFromDDMMYYY(ddmmyyyy: String): String {
            return try {
                val initDate = SimpleDateFormat(DATE_FORMAT_DDMMYYYY).parse(ddmmyyyy)
                val formatter = SimpleDateFormat(DATE_FORMAT_YYYYMMDD)
                val parsedDate = formatter.format(initDate)
                parsedDate

            } catch (e: Exception) {
                ""
            }
        }

        fun getImageUriFromBitmap(context: Context?, bitmap: Bitmap): Uri {
            val bytes = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
            val path =
                MediaStore.Images.Media.insertImage(
                        context!!.contentResolver,
                        bitmap,
                        "IMG_" + Calendar.getInstance().time,
                        null
                )
            return Uri.parse("$path")

        }

        fun encodeURItoB64(uri: Uri?, context: Context): String {
            return Base64.encodeToString(uri?.let { getByteArray(it, context) }, Base64.URL_SAFE)
        }

        private fun getByteArray(uri: Uri, context: Context): ByteArray? {
            var iStream: InputStream? = context.contentResolver.openInputStream(uri)
            return iStream?.let { getBytes(it) }
        }

        @Throws(IOException::class)
        fun getBytes(inputStream: InputStream): ByteArray? {
            val byteBuffer = ByteArrayOutputStream()
            val bufferSize = 1024
            val buffer = ByteArray(bufferSize)
            var len = 0
            while (inputStream.read(buffer).also { len = it } != -1) {
                byteBuffer.write(buffer, 0, len)
            }
            return byteBuffer.toByteArray()
        }


        fun getModeMapFromModeList(mode: List<Int>): HashMap<Int, String> {
            val modeMap = HashMap<Int, String>()
            for (item in mode) {
                when (item) {
                    12 -> modeMap.put(12, "Yearly")
                    6 -> modeMap.put(6, "Half-Yearly")
                    3 -> modeMap.put(3, "Quaterly")
                     1 -> modeMap.put(1, "Monthly")
                     0 -> modeMap.put(1, "Single")
                }

            }

            return modeMap
        }

        fun getAgeFromDOBYYYYMMDD(dobInYYYYMMDD: String): String {
            return try {

                var day = dobInYYYYMMDD.substring(8, 10).toInt()
                var month = dobInYYYYMMDD.substring(5, 7).toInt()
                var year = dobInYYYYMMDD.substring(0, 5).toInt()
                getAgeFromDOB(year, month, day).toString()
            } catch (e: Exception) {
                ""
            }
        }

        fun getAgeFromDOB(year: Int, month: Int, day: Int): Int {
            try {
                val dob = Calendar.getInstance()
                val today = Calendar.getInstance()

                dob.set(year, month, day)

                var age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

                if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                    age--
                }

                val ageInt = age + 1

                return ageInt
            } catch (e: Exception) {
                return 0
            }

        }


        fun convertNumtoIndiaCurrency(number: String?): String {
            return try{
                if(!number.isNullOrBlank()){
                    var absoluteNumb=if(number.contains(".")) number.split(".")[0] else number
                    val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("hi", "IN"))
                  //  val formatter1: android.icu.text.NumberFormat = CompactDecimalFormat.getCurrencyInstance(Locale("hi","IN"))
                    val moneyString: String = formatter.format(number.toInt())
                    val money: List<String> = moneyString.split(".")
                    money[0]
                    when {
                        absoluteNumb.length>7 -> {
                            var ret=formatter.format( getCurrencyInShort(absoluteNumb))+"Cr"
                            Timber.d("$number $ret")
                            ret
                        }
                        absoluteNumb.length>5 -> {
                            var ret=formatter.format( getCurrencyInShort(absoluteNumb))+"L"
                            Timber.d("$number $ret")
                            ret
                        }
                        else -> {
                            Timber.d("$number $moneyString")
                            money[0]
                        }
                    }
                }
                else{
                    ""
                }

            } catch (e:Exception){
                Timber.d(e)
                ""
            }

        }

        fun convertDoubletoIndiaCurrency(number: String?): String {

            return try{
                if(!number.isNullOrBlank()){
                    var absoluteNumb=if(number.contains(".")) number.split(".")[0] else number
                    val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("hi", "IN"))
                    val moneyString: String = formatter.format(number.toDouble())
                    val money: List<String> = moneyString.split(".")
                    when {
                        absoluteNumb.length>7 -> {
                            var ret=formatter.format( getCurrencyInShort(absoluteNumb))+"Cr"
                            Timber.d("$number $ret")
                            ret
                        }
                        absoluteNumb.length>5 -> {
                            var ret=formatter.format( getCurrencyInShort(absoluteNumb))+"L"
                            Timber.d("$number $ret")
                            ret
                        }
                        absoluteNumb.length>3 -> {
                            money[0]
                        }

                        else -> {
                            Timber.d("$number $moneyString")
                            moneyString
                        }
                    }


                }
                else
                    ""

            } catch (e:Exception){
                Timber.d(e)
                ""
            }
           // val money: List<String> = moneyString.split(".")

        }

        private fun getCurrencyInShort(number: String):Double {
            try{
                var numberInt=number.toDouble()
                return when {
                    numberInt>9999999 -> String.format("%.2f", numberInt/10000000).toDouble()
                    numberInt>99999 -> String.format("%.2f", numberInt/100000).toDouble()
                    else -> number.toDouble()
                }
            }
            catch(e:Exception)
            {
                Timber.d(e)
            }

            return 0.00
        }


        fun getDOBfromAge(age: Int): String {
            val dob = Calendar.getInstance()
            val today = Calendar.getInstance()

            dob.set(
                    today.get(Calendar.YEAR) - age,
                    today.get(Calendar.MONTH),
                    today.get(Calendar.DAY_OF_MONTH)
            )
            val sdf = SimpleDateFormat(DATE_FORMAT_YYYYMMDD)
            val dobDate = sdf.format(dob.time)
            DebugHandler.log("DOB " + dobDate)
            return dobDate
        }

        fun getAgeNBD(dob: String?): Int {
            var age = 0
            try {
                val today = Calendar.getInstance()
                val year = today[Calendar.YEAR]
                val month = today[Calendar.MONTH]
                val date = today[Calendar.DATE]
                val df = SimpleDateFormat("dd-MM-yyyy").parse(dob)
                today.timeInMillis = df.time
                val birthYear = today[Calendar.YEAR]
                val birthMonth = today[Calendar.MONTH]
                val birthDate = today[Calendar.DATE]
                age = year - birthYear
                var monthDiff = month - birthMonth
                val dateDiff = date - birthDate
                if (monthDiff < 0 && dateDiff < 0) {
                    monthDiff = monthDiff - 1
                }
                if (monthDiff >= 0 && dateDiff < 0) {
                    monthDiff = monthDiff - 1
                }
                if (monthDiff < 0) {
                    age = age - 1
                }
                if (monthDiff < 0 && monthDiff >= -6) {
                    age = age + 1
                    return age
                }
                if (monthDiff >= 6) {
                    age = age + 1
                }
            } catch (e: java.lang.Exception) {
//            Common.trace(e); // Enter the correct code as per your application here
                // logger.error(e.localizedMessage)
            }
            return age
        }

        fun getAgeLBD(dob: String?): Int {
            var age = 0
            try {
                val today = Calendar.getInstance()
                val year = today[Calendar.YEAR]
                val month = today[Calendar.MONTH]
                val date = today[Calendar.DATE]
                val df = SimpleDateFormat("dd-MM-yyyy").parse(dob)
                today.timeInMillis = df.time
                val birthYear = today[Calendar.YEAR]
                val birthMonth = today[Calendar.MONTH]
                val birthDate = today[Calendar.DATE]
                age = year - birthYear
                var monthDiff = month - birthMonth
                val dateDiff = date - birthDate
                if (monthDiff < 0 && dateDiff < 0) {
                    monthDiff = monthDiff - 1
                }
                if (monthDiff >= 0 && dateDiff < 0) {
                    monthDiff = monthDiff - 1
                }
                if (monthDiff < 0) {
                    age = age - 1
                }
            } catch (e: java.lang.Exception) {
//            Common.trace(e); // Enter the correct code as per your application here
                // logger.error(e.localizedMessage)
            }
            return age
        }


        fun downloadPdf(baseActivity: Context, url: String?, title: String?): Long {
            val extension = url?.substring(url.lastIndexOf("."))
            val downloadReference: Long
            val dm: DownloadManager =
                baseActivity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val uri = Uri.parse(url)
            val request = DownloadManager.Request(uri)
            request.setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,
                    "pdf$title$extension"
            )
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setTitle(title)
            Toast.makeText(
                    baseActivity,
                    "Downloading your file,Please check notifications for details",
                    Toast.LENGTH_LONG
            ).show()

            downloadReference = dm.enqueue(request)

            return downloadReference

        }

        /*
        @RequiresApi(Build.VERSION_CODES.O)
        fun getBenefitIllustrationPdf(baseActivity: Context,response:String,planName:String)
        {

            val pdfAsBytes: ByteArray = getDecoder().decode(response)
            val downloadPath = baseActivity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            DebugHandler.log("BI Downloading path ::"+downloadPath)
            var file = File.createTempFile(planName+"_benefit_illustration",".pdf", downloadPath)
            var os = FileOutputStream(file);
            os.write(pdfAsBytes);
            os.close();
            Toast.makeText(baseActivity, "Downloading your file,Please check notifications for details", Toast.LENGTH_LONG).show()

        }
*/

        fun storeToPDFandOpen(
                context: Context,
                directoryName: String,
                base: String,
                planNumber: String
        ) {
            val root = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            DebugHandler.log("ResponseEnv" + root)
            val myDir = File("$root/" + directoryName)
            if (!myDir.exists()) {
                myDir.mkdirs()
            }
            val fname = planNumber + "_" + directoryName + ".pdf"
            val file = File(myDir, fname)
            if (file.exists()) file.delete()
            try {
                val out = FileOutputStream(file)
                val pdfAsBytes: ByteArray =
                    android.util.Base64.decode(base, android.util.Base64.DEFAULT)
                out.write(pdfAsBytes)
                out.flush()
                out.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            val pdfFile = File(myDir, fname)
            val sendIntent = Intent(Intent.ACTION_VIEW)
            val uri: Uri
            uri = if (Build.VERSION.SDK_INT > 24) {
                FileProvider.getUriForFile(
                        context,
                        context.applicationContext.packageName + ".provider",
                        pdfFile
                )
            } else {
                Uri.parse("content://$pdfFile") // My work-around for new SDKs, causes ActivityNotFoundException in API 10.
            }
            sendIntent.setDataAndType(uri, "application/pdf")
            sendIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            context.startActivity(sendIntent)
        }

        fun setAppLocale(context: Context, language: String) {
            val locale = Locale(language)
            Locale.setDefault(locale)
            val config = context.resources.configuration
            config.setLocale(locale)
            context.createConfigurationContext(config)
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
        }

        fun getAppDataInfo(context: Context): AppDataInfo {
            val appDataString = CommonUtility.getJsonDataFromAsset(context, "app_utility_data.json")
            return Gson().fromJson(appDataString, AppDataInfo::class.java)
        }

        fun getImageFromBase64(base64String: String, imageView: ImageView) {
            val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            imageView.setImageBitmap(decodedImage)
        }

        fun getPaymentModeFullName(mode: String): String {
            val paymentMap: Map<String, String> = mapOf(
                    "Y" to "Yearly",
                    "H" to "Half-yearly",
                    "Q" to "Quaterly",
                    "M" to "Monthly",
                    "S" to "Single"

            )
            for ((key, value) in paymentMap) {
                if (key.equals(mode))
                    return value
            }
            return ""
        }




        fun getIndexOfSpinnerFromKey(key: String, spinnerList: List<SpinnerItemModel>): Int {
            spinnerList.forEachIndexed { index, item ->
                if (item.id == key) return index
            }
            return 0

        }

        fun isSwitchSelected(key: String?): Boolean {
            return key.equals("Y", true)
        }

        fun checkNullAndSetDefaultNo(key: String?): String {
            if (key != null) return key
            return AppConstants.NO_ID
        }

        fun checkNullAndSetDefaultYes(key: String?): String {
            if (key != null) return key
            return AppConstants.YES_ID
        }


        fun getAppVersionName(context: Context): String {
            var appVersionName = ""
            try {
                appVersionName =
                    context.packageManager.getPackageInfo(context.packageName, 0).versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return appVersionName
        }


        fun getAppVersionCode(context: Context): Long {
            var appVersionCode = 0L
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    appVersionCode =
                        context.packageManager.getPackageInfo(
                                context.packageName,
                                0
                        ).longVersionCode
                } else {
                    appVersionCode =
                        context.packageManager.getPackageInfo(
                                context.packageName,
                                0
                        ).versionCode.toLong()
                }
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return appVersionCode
        }

        fun launchBrowser(context: Context, url: String) {

            var intent: Intent? = null
            try {
                intent = Intent(Intent.ACTION_VIEW)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.data = Uri.parse(url)
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                /*context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                    )
                )*/
                Toast.makeText(context, R.string.msg_try_again, Toast.LENGTH_SHORT).show()
                Timber.d(e.stackTraceToString())
            }
        }

        fun launchPlayStore(context: Context, packageName: String) {

            var intent: Intent? = null
            try {
                intent = Intent(Intent.ACTION_VIEW)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.data = Uri.parse("market://details?id=$packageName")
                context.startActivity(intent)
            } catch (anfe: ActivityNotFoundException) {
                context.startActivity(
                        Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                        )
                )
            }
        }

        fun shareApp(context: Context) {
            val appPackageName = context.packageName
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out the App at: https://play.google.com/store/apps/details?id=$appPackageName"
            )
            sendIntent.type = "text/plain"
            context.startActivity(sendIntent)
        }
        fun callNumberFromApp(context: Context,number: String?)
        {
            val intent = Intent(Intent.ACTION_CALL);
            intent.data = Uri.parse("tel:$number")
            context.startActivity(intent)
        }
        fun composeEmail(context: Context, email: String, subject: String?) {
            try {

                val uriText = "mailto:"+email + "?subject=" + Uri.encode(subject)
                        //"&body=" + Uri.encode("some text here")
                val uri = Uri.parse(uriText)
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data=uri
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {

                Toast.makeText(context, R.string.msg_try_again, Toast.LENGTH_SHORT).show()
                Timber.d(e.stackTraceToString())
            }
        }

        fun getDeviceName(): String? {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.startsWith(manufacturer)) {
                capitalize(model)
            } else {
                capitalize(manufacturer).toString() + " " + model
            }
        }

        private fun capitalize(s: String?): String? {
            if (s == null || s.length == 0) {
                return ""
            }
            val first = s[0]
            return if (Character.isUpperCase(first)) {
                s
            } else {
                Character.toUpperCase(first).toString() + s.substring(1)
            }
        }

        fun logoutAppSession(activity: Activity){
            SaveSharedPreference.logout(activity)
            val intent = Intent(activity, LaunchActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            activity.startActivity(intent)
            activity.finish()

        }

        fun getPercentage(part: String,total:String): String {
            var percentage:Double=0.0;
            try {
                percentage= (part.toDouble()/total.toDouble()).toDouble()*100
                percentage= String.format("%.2f", percentage).toDouble()
            }catch (e:Exception){
                e.printStackTrace()
            }

            return percentage.toString()+" %"

        }



    }
}
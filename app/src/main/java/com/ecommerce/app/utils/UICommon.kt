package com.ecommerce.app.utils

import android.app.*
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.widget.EditText
import android.widget.Toast
import com.ecommerce.app.R
import com.ecommerce.app.constants.MESSAGETYPE
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*


class UICommon {

    companion object {
        protected var progressDialog: Dialog? = null

   /*     fun showSnackbar(act: Activity, message: String?, duration: Int) {
            var duration = duration
            duration = if (duration >= 1) Snackbar.LENGTH_INDEFINITE else Snackbar.LENGTH_LONG
            val snackbar: Snackbar =
                Snackbar.make(act.findViewById(R.id.appBarMain), message.toString(), duration)
            val group = snackbar.getView() as ViewGroup
            group.setBackgroundColor(group.context.resources.getColor(R.color.black))
            //group.setBackgroundColor(ContextCompat.getColor(act.getApplicationContext(), R.color.primary));
            snackbar.show()
        }*/
        fun hideSoftKeyboard(view: View, act: Activity){
            (act.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).apply {
                hideSoftInputFromWindow(view.windowToken, 0)
            }
        }

        fun showAlertDialog(
            context: Context,
            message: String?,
        ) {
            var dialog = MaterialAlertDialogBuilder(context)
                .setMessage(
                    message
                ) .create()
            dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
            dialog.show()
        }

        fun showWebViewAlertDialog(
            context: Context,
            message: String?,
            layoutResId: Int
        ) {
            var dialog = MaterialAlertDialogBuilder(context)
                .setView(layoutResId)
                .create()
           // dialog.window!!.attributes.windowAnimations = com.licapps.ananda.R.style.DialogAnimation

            dialog.show()
            if (message != null) {
                dialog.findViewById<WebView>(R.id.infoTextWV)
                    ?.loadDataWithBaseURL(null, message.toString(), "text/html", "utf-8", null)
            }
        }
        /*fun showMessageInViews(context: Activity, message: String?, type: MESSAGETYPE?) {
            when (type) {
                MESSAGETYPE.SNACK_BAR -> showSnackbar(context, message, 0)
                MESSAGETYPE.ALERT -> showAlertDialog(
                    context,
                    message,
                )

                else -> {}
            }
        }*/

        public fun showProgressDialog(act: Activity, msg: String?, isCancelable: Boolean) {
           try {
               if (act != null && !act.isFinishing) {
                   if (progressDialog == null) progressDialog = ProgressDialog(act)
                   (progressDialog as ProgressDialog).setMessage(msg)
                   progressDialog!!.setCancelable(isCancelable)
                   (progressDialog as ProgressDialog).isIndeterminate = true
                   if (act != null && !act.isFinishing) {
                       (progressDialog as ProgressDialog).show()
                   }
               }
           }catch ( ex:Exception) {
                ex.printStackTrace();
               Toast.makeText(act, R.string.loading, Toast.LENGTH_SHORT).show()
            }

        }
        public fun hideProgressDialog(act: Activity) {
                if (progressDialog != null && progressDialog!!.isShowing) {
                    if(act!=null &&  !act.isFinishing) {
                    progressDialog!!.dismiss()
                        progressDialog=null
                }
            }
        }


        public  fun showAlertDialog(
            act: Activity?,
            cancellable: Boolean, title: String?,
            message: String?,
            positiveBtn: String?,
            negativeBtn: String?,
            neutralBtn: String,
            listener: AlertDialogListener?
        ) {
            val builder = AlertDialog.Builder(act)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setCancelable(cancellable)
            builder.setPositiveButton(
                positiveBtn
            ) { dialog, which ->
                listener?.onPositiveButton(dialog)
                dialog.dismiss()
            }
            builder.setNegativeButton(
                negativeBtn
            ) { dialog, which ->
                listener?.onNegativeButton(dialog)
                dialog.dismiss()
            }
            builder.setNeutralButton(
                neutralBtn
            ) { dialog, which ->
                listener?.onNeutralButton(dialog)
                dialog.dismiss()
            }
            builder.show()
        }

        public fun showDatePickerSetDate(context: Context,editText: EditText) {
            val myCalendar = Calendar.getInstance()
            val date =
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth -> // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year)
                    myCalendar.set(Calendar.MONTH, monthOfYear)
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val sdf = SimpleDateFormat(CommonUtility.DATE_FORMAT_DDMMYYYY, Locale.US)
                    var dateInString = sdf.format(myCalendar.getTime())
                    editText.setText(dateInString)
                }

            val dialog = DatePickerDialog(
                context, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            )
            dialog.datePicker.maxDate = Date().time
            dialog.show()
        }

    }


}
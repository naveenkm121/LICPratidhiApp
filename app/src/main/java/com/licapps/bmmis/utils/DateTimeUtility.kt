package com.licapps.bmmis.utils

import android.os.Parcel
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*


class DateTimeUtility {
public interface OnDateSelectListener{
   fun onDateSelected(selectedDate:String)
}

    companion object {
        val DATE_FORMAT_DDMMYYYY: String = "dd-MM-yyyy"
        val DATE_FORMAT_YYYYMMDD: String = "yyyy-MM-dd"

        fun showDateDialog(
            startDate: Long,
            endDate: Long,
            isProposal: Boolean,
            listener:OnDateSelectListener,
            fragmentManager: FragmentManager
        ) {

            val datePickerBuilder = MaterialDatePicker.Builder.datePicker()

            val constraintsBuilder = CalendarConstraints.Builder()  // 1
            val calendar = Calendar.getInstance()
            constraintsBuilder.setEnd(calendar.timeInMillis)
            val validators= DateValidatorPointBackward.before(calendar.timeInMillis); //   2
            datePickerBuilder.setCalendarConstraints(constraintsBuilder
                .setValidator(validators)
                .build())
            val datePicker = datePickerBuilder.build()
            datePicker.addOnPositiveButtonClickListener {
                listener.onDateSelected(getDateStringFromLong(it))
                // selectedDate = getDateStringFromLong(it)
            }

            datePicker.show(fragmentManager, "date picker")

        }

        fun getFYStartDate(): Long {
            val calendar = Calendar.getInstance()
            calendar[Calendar.YEAR] = 2021
            calendar[Calendar.MONTH] = Calendar.MARCH
            calendar[Calendar.DAY_OF_MONTH] = 31
            // val sdf = SimpleDateFormat(DATE_FORMAT_DDMMYYYY)
            return calendar.timeInMillis
        }

        private fun getDateStringFromLong(dateInLong: Long): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = dateInLong
            val sdf = SimpleDateFormat(DATE_FORMAT_DDMMYYYY)
            return sdf.format(dateInLong)
        }

    }
}
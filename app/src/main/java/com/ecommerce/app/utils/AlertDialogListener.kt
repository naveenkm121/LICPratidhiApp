package com.ecommerce.app.utils

import android.content.DialogInterface

interface AlertDialogListener {
    fun onPositiveButton(dialog: DialogInterface?)

    fun onNegativeButton(dialog: DialogInterface?) {}

    fun onNeutralButton(dialog: DialogInterface?) {}
}
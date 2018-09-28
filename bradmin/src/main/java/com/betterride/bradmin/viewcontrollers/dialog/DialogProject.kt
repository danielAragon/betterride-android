package com.betterride.bradmin.viewcontrollers.dialog

import android.support.v4.app.DialogFragment
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.design.widget.TextInputEditText

class DialogProject : DialogFragment() {
    lateinit var nameProjectInput: TextInputEditText
    lateinit var builder: AlertDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       // builder = AlertDialog.Builder(activity())




        return super.onCreateDialog(savedInstanceState)
    }
}
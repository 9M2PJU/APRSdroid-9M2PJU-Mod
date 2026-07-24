package org.aprsdroid.app

import _root_.android.app.Activity
import _root_.android.content.Context
import _root_.android.view.View
import _root_.android.widget.Toast
import _root_.com.google.android.material.snackbar.Snackbar

object ToastHelper {
	val DURATION_MS = 1500

	def show(context : Context, text : CharSequence) : Unit = {
		context match {
			case a : Activity =>
				val view = a.findViewById(android.R.id.content).asInstanceOf[View]
				if (view != null)
					Snackbar.make(view, text, DURATION_MS).show()
				else
					Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
			case _ =>
				Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
		}
	}

	def show(context : Context, resId : Int) : Unit = {
		show(context, context.getString(resId))
	}
}

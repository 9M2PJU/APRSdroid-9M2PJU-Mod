package org.aprsdroid.app

import _root_.android.content.SharedPreferences
import _root_.android.os.Bundle
import _root_.android.preference.PreferenceActivity

class NotificationPrefs extends PreferenceActivity with SharedPreferences.OnSharedPreferenceChangeListener {

	override def onCreate(savedInstanceState: Bundle) {
		super.onCreate(savedInstanceState)
		UIHelper.applySystemBarInsets(this)
		addPreferencesFromResource(R.xml.notifications)
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this)
	}

	override def onDestroy() {
		super.onDestroy()
		getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this)
	}

	override def onSharedPreferenceChanged(sp: SharedPreferences, key: String) {
		// No special handling needed -- preferences are simple checkboxes
		// and ringtone preferences.
	}
}

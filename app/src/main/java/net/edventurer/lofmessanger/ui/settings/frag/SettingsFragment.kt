package net.edventurer.lofmessanger.ui.settings.frag

import android.os.Bundle
import android.preference.PreferenceFragment
import net.edventurer.lofmessanger.EdvContract
import net.edventurer.lofmessanger.R


/**
 * Created by akvus on 2/20/18.
 */
class SettingsFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceManager.sharedPreferencesName = EdvContract.sharedPreferencesName
        addPreferencesFromResource(R.xml.preferences)
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }
}
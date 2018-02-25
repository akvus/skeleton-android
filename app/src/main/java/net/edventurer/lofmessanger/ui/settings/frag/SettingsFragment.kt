package net.edventurer.lofmessanger.ui.settings.frag

import android.os.Bundle
import android.preference.PreferenceFragment
import android.util.Patterns
import net.edventurer.lofmessanger.MyContract
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.ext.snack


/**
 * Created by akvus on 2/20/18.
 */
class SettingsFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceManager.sharedPreferencesName = MyContract.sharedPreferencesName
        addPreferencesFromResource(R.xml.preferences)

        validation()
    }

    private fun validation() {
        findPreference("nickPreference").setOnPreferenceChangeListener { _, potentialNickName ->
            if (potentialNickName.toString().isEmpty()) {
                activity.snack(R.string.settings_error_nickname_empty)
                false
            } else {
                true
            }
        }
        findPreference("urlPreference").setOnPreferenceChangeListener { _, potentialUrl ->
            if (Patterns.WEB_URL.matcher(potentialUrl.toString()).matches()
                    && potentialUrl.toString().endsWith("/")) {
                true
            } else {
                activity.snack(R.string.settings_error_url_invalid)
                false
            }
        }
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }
}
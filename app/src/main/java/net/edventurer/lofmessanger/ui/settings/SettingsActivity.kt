package net.edventurer.lofmessanger.ui.settings

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import dagger.android.AndroidInjection
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.arch.MyDaggerAppCompactActivity
import net.edventurer.lofmessanger.ui.settings.frag.SettingsFragment
import javax.inject.Inject

/**
 * Created by akvus on 2/19/18.
 */
class SettingsActivity : MyDaggerAppCompactActivity<SettingsViewState>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        commitFragment()
    }

    private fun commitFragment() {
        fragmentManager.beginTransaction().run {
            replace(R.id.rootView, SettingsFragment.newInstance())
            commit()
        }
    }

    override fun render(viewState: SettingsViewState) {
    }

}
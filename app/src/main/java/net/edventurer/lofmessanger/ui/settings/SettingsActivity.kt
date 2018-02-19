package net.edventurer.lofmessanger.ui.settings

import android.os.Bundle
import android.os.PersistableBundle
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.arch.MyDaggerAppCompactActivity

/**
 * Created by akvus on 2/19/18.
 */
class SettingsActivity : MyDaggerAppCompactActivity<SettingsViewState>() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_settings)
    }

    override fun render(viewState: SettingsViewState) {

    }

}
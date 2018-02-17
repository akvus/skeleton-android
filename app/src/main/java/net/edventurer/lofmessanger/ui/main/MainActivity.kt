package net.edventurer.lofmessanger.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.edventurer.lofmessanger.R
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProviders.of(this, viewModelProvider)
                .get(MainActivityViewModel::class.java);

        mainActivityViewModel?.test()
        setUpView()
    }

    private fun setUpView() {
        etMessage.setOnKeyListener({ v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                btnSend.performClick()
                true
            }else {
                false
            }
        })

        rvMessages.adapter = MessagesAdapter()
        rvMessages.layoutManager = LinearLayoutManager(this)
    }
}

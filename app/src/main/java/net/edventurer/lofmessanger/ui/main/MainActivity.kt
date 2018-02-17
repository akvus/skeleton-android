package net.edventurer.lofmessanger.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.arch.MyDaggerAppCompactActivity
import javax.inject.Inject

class MainActivity : MyDaggerAppCompactActivity<MainViewState>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        setUpView()
    }

    private fun setUpViewModel() {
        mainActivityViewModel = ViewModelProviders.of(this, viewModelProvider)
                .get(MainActivityViewModel::class.java);
        mainActivityViewModel?.state?.observe(this, Observer<MainViewState> {
            it?.let { render(it) }
        })
    }

    private fun setUpView() {
        rvMessages.adapter = MessagesAdapter()
        rvMessages.layoutManager = LinearLayoutManager(this)

        etMessage.setOnKeyListener({ v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                btnSend.performClick()
                true
            } else {
                false
            }
        })
        btnSend.setOnClickListener {

        }
    }

    override fun render(viewState: MainViewState) {

    }
}

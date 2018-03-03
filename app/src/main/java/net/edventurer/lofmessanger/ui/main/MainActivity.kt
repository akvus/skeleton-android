package net.edventurer.lofmessanger.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSmoothScroller
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.arch.MyDaggerAppCompactActivity
import net.edventurer.lofmessanger.db.data.LofMessage
import net.edventurer.lofmessanger.ext.snack
import net.edventurer.lofmessanger.ui.settings.SettingsActivity
import javax.inject.Inject


class MainActivity : MyDaggerAppCompactActivity<MainViewState>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private var viewModel: MainActivityViewModel? = null

    private var adapter: MessagesAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var smoothScroller: LinearSmoothScroller? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        setUpView()
        viewModel?.process(InitIntention)
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelProvider)
                .get(MainActivityViewModel::class.java);
        viewModel?.state?.observe(this, Observer<MainViewState> {
            it?.let { render(it) }
        })
        viewModel?.snack?.observe(this, Observer {
            it?.let { snack(it) }
        })
    }

    private fun setUpView() {
        adapter = MessagesAdapter()
        adapter?.onDelete?.observe(this, Observer<LofMessage> {
            it?.let { viewModel?.process(DeleteMessageIntention(it)) }
        })
        rvMessages.adapter = adapter

        layoutManager = LinearLayoutManager(this)
        rvMessages.layoutManager = layoutManager

        smoothScroller = object: LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int {
                return LinearSmoothScroller.SNAP_TO_START
            }
        }

        etMessage.setOnKeyListener({ _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                btnSend.performClick()
                true
            } else {
                false
            }
        })
        btnSend.setOnClickListener {
            viewModel?.process(PostMessageIntention(etMessage.text.toString()))
            etMessage.setText("")
        }
    }

    override fun render(viewState: MainViewState) {
        if (viewState.messagesToAdd != null) {
            adapter?.addMessages(viewState.messagesToAdd)
        }

        if (viewState.scrollToNewest != null && viewState.scrollToNewest == true) {
            scrollToNewest()
        }
    }

    private fun scrollToNewest() {
        adapter?.itemCount?.let {
            smoothScroller?.targetPosition = it -1
            layoutManager?.startSmoothScroll(smoothScroller)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            onSettingsAction()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun onSettingsAction() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }
}

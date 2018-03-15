package net.edventurer.lofmessanger.ui.main

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by maciejz on 15/03/18.
 */
@RunWith(JUnit4::class)
class MainViewStateTest {
    @Test
    fun init() {
        val state = MainViewState.init()
        assertThat(state.messagesToAdd!!.size, equalTo(0))
        assertThat(state.scrollToNewest, `is`(nullValue()))
    }
}
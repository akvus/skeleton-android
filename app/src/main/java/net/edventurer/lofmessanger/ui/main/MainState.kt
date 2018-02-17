package net.edventurer.lofmessanger.ui.main

import net.edventurer.lofmessanger.arch.State
import net.edventurer.lofmessanger.db.Message

/**
 * Created by akvus on 2/17/18.
 */
data class MainState(val messages: List<Message>): State
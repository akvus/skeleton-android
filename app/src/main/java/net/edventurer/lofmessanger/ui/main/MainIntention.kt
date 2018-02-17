package net.edventurer.lofmessanger.ui.main

import net.edventurer.lofmessanger.arch.Intention

/**
 * Created by akvus on 2/17/18.
 */
sealed class MainIntention : Intention

data class SendMessageIntention(val message: String) : MainIntention()

data class DeleteMessageIntention(val id: String) : MainIntention()
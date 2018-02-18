package net.edventurer.lofmessanger.ui.main

import net.edventurer.lofmessanger.arch.Intention
import net.edventurer.lofmessanger.db.data.LofMessage

/**
 * Created by akvus on 2/17/18.
 */
sealed class MainIntention : Intention

object InitIntention: MainIntention()

data class PostMessageIntention(val message: String) : MainIntention()

data class DeleteMessageIntention(val message: LofMessage) : MainIntention()

object RetrieveMessages: MainIntention()
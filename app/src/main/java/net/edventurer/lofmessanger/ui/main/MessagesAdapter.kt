package net.edventurer.lofmessanger.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.db.data.Message

/**
 * Created by akvus on 2/17/18.
 */
class MessagesAdapter: RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {
    private val messages: MutableList<Message> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.message, parent, false))
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMessage.text = messages[position].message
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMessage = view.findViewById<TextView>(R.id.tvMessage)
    }

    fun addMessages(newMessages: List<Message>) {
        messages.addAll(newMessages)
        notifyDataSetChanged()
    }

    fun replaceMessages(newMessages: List<Message>) {
        messages.clear()
        addMessages(newMessages)
    }
}
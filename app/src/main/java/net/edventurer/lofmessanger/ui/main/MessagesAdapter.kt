package net.edventurer.lofmessanger.ui.main

import android.arch.lifecycle.MutableLiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import net.edventurer.lofmessanger.MyContract
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.db.data.LofMessage
import net.edventurer.lofmessanger.ext.formatted
import java.util.*

/**
 * Created by akvus on 2/17/18.
 */
class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {

    val onDelete: MutableLiveData<LofMessage> by lazy {
        MutableLiveData<LofMessage>()
    }

    private val lofMessages: MutableList<LofMessage> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.message, parent, false))
    }

    override fun getItemCount(): Int {
        return lofMessages.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNickname.text = lofMessages[position].nickname
        holder.tvMessage.text = lofMessages[position].message
        holder.tvDate.text = Date(lofMessages[position].timestamp).formatted(MyContract.dateTimeFormat)
        holder.llRoot.setOnLongClickListener {
            onDelete.value = lofMessages[holder.adapterPosition]
            deleteMessage(holder.adapterPosition)
            true
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNickname: TextView = view.findViewById(R.id.tvNickname)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val llRoot: LinearLayout = view.findViewById(R.id.llRoot)
    }

    fun addMessages(newLofMessages: List<LofMessage>) {
        lofMessages.addAll(newLofMessages)
        notifyDataSetChanged()
    }

    fun replaceMessages(newLofMessages: List<LofMessage>) {
        lofMessages.clear()
        addMessages(newLofMessages)
    }

    fun deleteMessage(message: LofMessage) {
        deleteMessage(lofMessages.indexOf(message))
    }

    fun deleteMessage(position: Int) {
        lofMessages.removeAt(position)
        notifyItemRemoved(position)
    }
}
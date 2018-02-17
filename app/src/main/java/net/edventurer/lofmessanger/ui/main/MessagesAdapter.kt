package net.edventurer.lofmessanger.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.edventurer.lofmessanger.R

/**
 * Created by akvus on 2/17/18.
 */
class MessagesAdapter: RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.message, parent, false))
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
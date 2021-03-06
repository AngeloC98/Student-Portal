package com.example.studentportal

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(portal: Portal) {
            itemView.tvTitleItem.text = portal.title
            itemView.tvUrlItem.text = portal.url
            itemView.setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                builder.setShowTitle(true)
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(itemView.context, Uri.parse(portal.url))
            }
        }
    }
}
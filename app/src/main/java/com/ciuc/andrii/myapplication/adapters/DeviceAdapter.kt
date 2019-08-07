package com.improveit.tegritee.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ciuc.andrii.myapplication.R
import com.ciuc.andrii.myapplication.data.DeviceInfo
import kotlinx.android.synthetic.main.recycler_view_header.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*


class DeviceAdapter(
    items: List<DeviceInfo>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: List<DeviceInfo> = items
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        context = parent.context
        when (p1) {
            0 -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.recycler_view_item, parent, false)
                return UserViewHolder(view)
            }
            1 -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.recycler_view_header, parent, false)
                return UserViewHolderHeader(view)
            }
            else -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.recycler_view_item, parent, false)
                return UserViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(parent: RecyclerView.ViewHolder, position: Int) {
        when (parent) {
            is UserViewHolder -> {
                parent.textDeviceName.text = list[position].deviceName
                parent.textDeviceAddress.text = list[position].deviceAddress
            }
            is UserViewHolderHeader -> {
                parent.textHeaderName.text = list[position].header
            }
        }
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textDeviceName: TextView = view.textDeviceName
        var textDeviceAddress: TextView = view.textDeviceAddress

    }

    inner class UserViewHolderHeader(view: View) : RecyclerView.ViewHolder(view) {
        var textHeaderName: TextView = view.textHeaderName
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].isHeader) 1 else 0
    }

}

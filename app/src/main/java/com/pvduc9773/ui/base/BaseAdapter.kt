package com.pvduc9773.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by pvduc9773 on 5/14/20.
 */
abstract class BaseAdapter<T, H : ViewDataBinding>() :
    RecyclerView.Adapter<BaseViewHolder<H>>() {

    private var dataSource: MutableList<T> = mutableListOf()

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<H> {
        val inflater = LayoutInflater.from(parent.context)
        return createViewHolder(inflater, parent, viewType)
    }

    protected abstract fun createViewHolder(
        inflater: LayoutInflater?,
        parent: ViewGroup?,
        viewType: Int
    ): BaseViewHolder<H>

    override fun onBindViewHolder(holder: BaseViewHolder<H>, position: Int) {
        this.bindVH(holder, position)
    }

    protected abstract fun bindVH(holder: BaseViewHolder<H>, position: Int)

    fun getItemAtIndex(position: Int): T {
        return dataSource[position]
    }

    fun insertData(insertList: List<T>) {
        val currentSize = dataSource.size
        dataSource.addAll(insertList)
        notifyItemRangeInserted(currentSize - 1, insertList.size)
    }

    fun updateData(newList: List<T>?) {
        dataSource.clear()
        dataSource.addAll(newList!!)
        notifyDataSetChanged()
    }

    fun insertItem(model: T) {
        val sizeInit = dataSource.size
        dataSource.add(model)
        notifyItemInserted(sizeInit)
    }

    fun insertItemAt(index: Int, model: T) {
        if (dataSource.size > index) {
            dataSource.add(index, model)
            notifyItemInserted(index)
        }
    }

    fun removeItem(model: T) {
        val index = dataSource.indexOf(model)
        if (index >= 0) {
            dataSource.remove(model)
            notifyItemRemoved(index)
        }
    }

    fun removeItemAt(index: Int, model: T) {
        if (dataSource.size > index) {
            dataSource.remove(model)
            notifyItemRemoved(index)
        }
    }

    fun clearData() {
        dataSource.clear()
        notifyDataSetChanged()
    }
}

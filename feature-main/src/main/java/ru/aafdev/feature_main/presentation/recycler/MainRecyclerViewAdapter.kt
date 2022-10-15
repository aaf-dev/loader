package ru.aafdev.feature_main.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.aafdev.core_ui.models.HeaderUiModel
import ru.aafdev.core_ui.models.NetologyDataUiModel
import ru.aafdev.core_ui.models.base.BaseUiModel
import ru.aafdev.feature_main.databinding.ItemHeaderBinding
import ru.aafdev.feature_main.databinding.ItemNetologyCourseBinding

class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<BaseUiModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HEADER_VIEW_TYPE -> {
                val binding = ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                HeaderViewHolder(binding)
            }
            CONTENT_VIEW_TYPE -> {
                val binding = ItemNetologyCourseBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                CourseViewHolder(binding)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        when (holder) {
            is HeaderViewHolder -> holder.bind()
            is CourseViewHolder -> holder.bind(item as NetologyDataUiModel)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HeaderUiModel -> HEADER_VIEW_TYPE
            is NetologyDataUiModel -> CONTENT_VIEW_TYPE
            else -> throw IllegalArgumentException()
        }
    }

    fun updateItems(newItems: List<BaseUiModel>) {
        val callback = DiffUtilCallback(items, newItems)
        items.clear()
        items.addAll(newItems)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
    }

    private class DiffUtilCallback(
        private val oldItems: List<BaseUiModel>,
        private val newItems: List<BaseUiModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldItems.size
        }

        override fun getNewListSize(): Int {
            return newItems.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            if (oldItem is HeaderUiModel && newItem is HeaderUiModel) return true

            return if (oldItem is NetologyDataUiModel && newItem is NetologyDataUiModel) {
                oldItem.groups.size == newItem.groups.size &&
                        oldItem.direction?.id == newItem.direction?.id
            } else {
                false
            }
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            if (oldItem is HeaderUiModel && newItem is HeaderUiModel) return true

            return if (oldItem is NetologyDataUiModel && newItem is NetologyDataUiModel) {
                oldItem.groups == newItem.groups && oldItem.direction == newItem.direction
            } else {
                false
            }
        }
    }

    private companion object {
        const val HEADER_VIEW_TYPE: Int = 0
        const val CONTENT_VIEW_TYPE: Int = 1
    }
}
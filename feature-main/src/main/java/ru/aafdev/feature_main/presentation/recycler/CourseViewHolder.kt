package ru.aafdev.feature_main.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import ru.aafdev.core_ui.models.NetologyDataUiModel
import ru.aafdev.feature_main.R
import ru.aafdev.feature_main.databinding.ItemNetologyCourseBinding

class CourseViewHolder(
    private val binding: ItemNetologyCourseBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: NetologyDataUiModel) {
        val resources = itemView.context.resources
        val coursesCount = item.groups.sumOf { it.items.size }

        binding.apply {
            title.text = item.direction?.title
            courseCounter.text = resources.getQuantityString(R.plurals.courses_counter, coursesCount, coursesCount)
        }
    }
}
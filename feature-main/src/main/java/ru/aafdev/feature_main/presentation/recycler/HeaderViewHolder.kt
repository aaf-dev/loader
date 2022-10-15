package ru.aafdev.feature_main.presentation.recycler

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.recyclerview.widget.RecyclerView
import ru.aafdev.feature_main.R
import ru.aafdev.feature_main.databinding.ItemHeaderBinding

class HeaderViewHolder(
    private val binding: ItemHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        val string = itemView.context.getString(R.string.header)
        val formattedString = SpannableString(string).apply {
            val firstIndex = string.indexOfFirst { it == ' ' }
            val lastIndex = string.lastIndex + 1

            setSpan(ForegroundColorSpan(Color.BLUE), firstIndex, lastIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        binding.root.text = formattedString
    }
}
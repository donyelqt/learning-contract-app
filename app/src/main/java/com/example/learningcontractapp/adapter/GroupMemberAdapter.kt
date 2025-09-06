package com.example.learningcontractapp.adapter

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learningcontractapp.R
import com.example.learningcontractapp.databinding.ItemGroupMemberBinding
import com.example.learningcontractapp.model.GroupMember

/**
 * Modern RecyclerView adapter for displaying group members with their learning contracts
 * Uses ListAdapter with DiffUtil for optimal performance
 */
class GroupMemberAdapter : ListAdapter<GroupMember, GroupMemberAdapter.GroupMemberViewHolder>(GroupMemberDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupMemberViewHolder {
        val binding = ItemGroupMemberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GroupMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupMemberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class GroupMemberViewHolder(
        private val binding: ItemGroupMemberBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(member: GroupMember) {
            with(binding) {
                // Set member name
                textViewName.text = member.name
                
                // Generate initials from name
                textViewInitials.text = generateInitials(member.name)
                
                // Set learning contract details with blue numbering
                textViewExpectations.text = applyBlueNumbering(member.learningContract.expectations)
                textViewMotivations.text = applyBlueNumbering(member.learningContract.motivations)
                textViewContributions.text = applyBlueNumbering(member.learningContract.contributions)
                textViewHindrances.text = applyBlueNumbering(member.learningContract.hindrances)
            }
        }

        private fun generateInitials(name: String): String {
            return name.split(" ")
                .take(2)
                .map { it.firstOrNull()?.uppercaseChar() ?: "" }
                .joinToString("")
                .ifEmpty { "?" }
        }

        private fun applyBlueNumbering(text: String): SpannableString {
            val spannableString = SpannableString(text)
            val blueColor = ContextCompat.getColor(binding.root.context, R.color.premium_blue_600)
            
            // Find all numbered list items (1. 2. 3. etc.)
            val regex = Regex("\\d+\\.")
            val matches = regex.findAll(text)
            
            for (match in matches) {
                val start = match.range.first
                val end = match.range.last + 1
                spannableString.setSpan(
                    ForegroundColorSpan(blueColor),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            
            return spannableString
        }
    }

    private class GroupMemberDiffCallback : DiffUtil.ItemCallback<GroupMember>() {
        override fun areItemsTheSame(oldItem: GroupMember, newItem: GroupMember): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GroupMember, newItem: GroupMember): Boolean {
            return oldItem == newItem
        }
    }
}

package com.example.learningcontractapp.model

/**
 * Data class representing a group member with their learning contract
 */
data class GroupMember(
    val id: Int,
    val name: String,
    val role: String = "Group Member", // Default role
    val profileImage: String? = null, // For future avatar implementation
    val learningContract: LearningContract
)

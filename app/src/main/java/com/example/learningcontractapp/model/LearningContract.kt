package com.example.learningcontractapp.model

/**
 * Data class representing a learning contract with all required components
 */
data class LearningContract(
    val expectations: String,
    val motivations: String,
    val contributions: String,
    val hindrances: String
)

package com.ysydneys.meapplication.model

data class Employee (
    val id: Int,
    val first_name: String,
    val last_name: String,
    val gender: String,
    val birth_date: String,
    val thumbImage: String?,
    val image: String?
)
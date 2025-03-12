package com.proyecto4.grantly.model

import java.util.*


sealed class UserRole {
    data class Government(
        val agencyName: String,
        val department: String,
        val country: String
    ) : UserRole()

    data class Student(
        val level: String,
        val birthDate: String,
        val parentName: String
    ) : UserRole()

    data class EducationalInstitution(
        val institutionType: String,
        val address: String
    ) : UserRole()
}

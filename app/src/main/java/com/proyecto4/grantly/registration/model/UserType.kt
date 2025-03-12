package com.proyecto4.grantly.registration.model

sealed class UserType(val title: String) {
    object Government : UserType("Government")
    object Student : UserType("Student")
    object EducationalInstitution : UserType("Educational Institution")
}
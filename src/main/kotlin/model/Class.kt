package model

data class Class(val _id: String? = null, val name: String, val teacherId: String, val studentsIds: List<String>)
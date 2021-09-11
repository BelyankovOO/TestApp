package com.example.testapp.domain

interface Mapper <X, Y> {
    fun mapToMainModel(model: X): Y
    fun mapFromMainModel(mainModel: Y): X
    fun toMainModelList(list: List<X>): List<Y>
    fun fromMainModelList(list: List<Y>): List<X>
}
package com.example.homework73.ui.model

data class CharacterModel(
    val image: Int,
    val status: String,
    val name: String
) : java.io.Serializable
/*
имплементируем интерфейс Serializable чтобы передавать ее в safeargs
 */
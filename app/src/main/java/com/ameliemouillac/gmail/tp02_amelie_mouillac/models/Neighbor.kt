package com.ameliemouillac.gmail.tp02_amelie_mouillac.models

data class Neighbor(
        val id: Long,
        val name: String,
        val avatarUrl: String,
        val address: String,
        val phoneNumber: String,
        val aboutMe: String,
        val favorite: Boolean,
        val webSite: String
)
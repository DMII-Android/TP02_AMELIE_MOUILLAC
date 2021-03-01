package com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.utils

import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.entities.NeighborEntity
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor

fun NeighborEntity.toNeighbor() = Neighbor(
    id = id,
    name = name,
    avatarUrl = avatarUrl,
    address = address,
    phoneNumber = phoneNumber,
    aboutMe = aboutMe,
    favorite = favorite,
    webSite = webSite ?: ""
)

fun Neighbor.toEntity() = NeighborEntity(
    id = id,
    name = name,
    avatarUrl = avatarUrl,
    address = address,
    phoneNumber = phoneNumber,
    aboutMe = aboutMe,
    favorite = favorite,
    webSite = webSite ?: ""
)

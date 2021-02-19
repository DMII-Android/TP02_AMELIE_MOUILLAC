package com.ameliemouillac.gmail.tp02_amelie_mouillac.adapters

import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeighbor(neighbor: Neighbor)
}
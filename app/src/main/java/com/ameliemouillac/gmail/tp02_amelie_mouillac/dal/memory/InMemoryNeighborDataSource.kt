package com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.memory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.InMemory_NeighborS
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.NeighborDatasource
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor

class InMemoryNeighborDataSource : NeighborDatasource {

    private val _neighbors = MutableLiveData<List<Neighbor>>()

    init {
        _neighbors.value = InMemory_NeighborS
    }

    override val neighbours: LiveData<List<Neighbor>>
        get() = this._neighbors

    override fun deleteNeighbor(neighbor: Neighbor) {
        InMemory_NeighborS.remove(neighbor)
    }

    override fun createNeighbor(neighbor: Neighbor) {
        InMemory_NeighborS.add(neighbor)
    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    override fun updateNeighbor(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }
}

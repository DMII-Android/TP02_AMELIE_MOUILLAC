package com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.NeighborDatasource
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.daos.NeighborDao
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.utils.toNeighbor
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor

class RoomNeighborDataSource(application: Application) : NeighborDatasource {
    private val database: NeighborDataBase = NeighborDataBase.getDataBase(application)
    private val dao: NeighborDao = database.neighborDao()

    private val _neighors = MediatorLiveData<List<Neighbor>>()

    init {
        _neighors.addSource(dao.getNeighbors()) { entities ->
            _neighors.value = entities.map { entity ->
                entity.toNeighbor()
            }
        }
    }

    override val neighbours: LiveData<List<Neighbor>>
        get() = _neighors

    override fun deleteNeighbor(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    override fun createNeighbor(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    override fun updateNeighbor(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }
}
package com.ameliemouillac.gmail.tp02_amelie_mouillac.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.NeighborDatasource
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.memory.InMemoryNeighborDataSource
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.RoomNeighborDataSource
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor

class NeighborRepository private constructor(application: Application) {
    private var dataSource: NeighborDatasource = InMemoryNeighborDataSource()

    init {
        dataSource = RoomNeighborDataSource(application)
    }

    // Méthode qui retourne la liste des voisins
    fun getNeighbours(): LiveData<List<Neighbor>> = dataSource.neighbours

    fun deleteNeighbor(neighbor: Neighbor) = dataSource.deleteNeighbor(neighbor)

    fun createNeighbor(neighbor: Neighbor) = dataSource.createNeighbor(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        // On crée un méthode qui retourne l'instance courante du repository si elle existe ou en crée une nouvelle sinon
        fun getInstance(application: Application): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository(application)
            }
            return instance!!
        }
    }
}

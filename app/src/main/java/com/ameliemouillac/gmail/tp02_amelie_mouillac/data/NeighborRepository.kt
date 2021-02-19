package com.ameliemouillac.gmail.tp02_amelie_mouillac.data

import com.ameliemouillac.gmail.tp02_amelie_mouillac.data.datasource.InMemoryNeighborDataSource
import com.ameliemouillac.gmail.tp02_amelie_mouillac.data.datasource.NeighborDatasource
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor

class NeighborRepository {
    private val dataSource: NeighborDatasource = InMemoryNeighborDataSource()

    // Méthode qui retourne la liste des voisins
    fun getNeighbours(): List<Neighbor> = dataSource.neighbours

    fun deleteNeighbor(neighbor: Neighbor) = dataSource.deleteNeighbor(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        // On crée un méthode qui retourne l'instance courante du repository si elle existe ou en crée une nouvelle sinon
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
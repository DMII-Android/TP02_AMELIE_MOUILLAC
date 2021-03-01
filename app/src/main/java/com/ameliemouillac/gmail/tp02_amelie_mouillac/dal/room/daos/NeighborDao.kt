package com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.entities.NeighborEntity

@Dao
interface NeighborDao {
    @Query("SELECT * from neighbors")
    fun getNeighbors(): LiveData<List<NeighborEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(neighbor: NeighborEntity)

    @Delete
    fun delete(neighbor: NeighborEntity)
}

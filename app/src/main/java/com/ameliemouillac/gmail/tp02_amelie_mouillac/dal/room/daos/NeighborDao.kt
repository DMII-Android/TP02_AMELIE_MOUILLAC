package com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.entities.NeighborEntity

@Dao
interface NeighborDao {
    @Query("SELECT * from neighbors")
    fun getNeighbors(): LiveData<List<NeighborEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(neighbor: NeighborEntity)
}

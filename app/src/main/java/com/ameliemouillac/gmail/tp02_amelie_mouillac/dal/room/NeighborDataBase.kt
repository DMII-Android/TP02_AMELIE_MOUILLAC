package com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.InMemory_NeighborS
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.daos.NeighborDao
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.room.entities.NeighborEntity
import com.ameliemouillac.gmail.tp02_amelie_mouillac.dal.utils.toEntity
import java.util.concurrent.Executors

@Database(
    entities = [NeighborEntity::class],
    version = 1
)
abstract class NeighborDataBase : RoomDatabase() {
    abstract fun neighborDao(): NeighborDao

    companion object {
        private var instance: NeighborDataBase? = null
        fun getDataBase(application: Application): NeighborDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    application.applicationContext,
                    NeighborDataBase::class.java,
                    "neighbor_database.db"
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        insertFakeData()
                    }
                })
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }

        private fun insertFakeData() {
            Executors.newSingleThreadExecutor().execute {
                InMemory_NeighborS.forEach {
                    instance?.neighborDao()?.add(it.toEntity())
                }
            }
        }
    }
}

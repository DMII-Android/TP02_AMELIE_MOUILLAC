package com.ameliemouillac.gmail.tp02_amelie_mouillac.di

import android.app.Application
import com.ameliemouillac.gmail.tp02_amelie_mouillac.repositories.NeighborRepository

object DI {
    lateinit var repository: NeighborRepository
    fun inject(application: Application) {
        repository = NeighborRepository.getInstance(application)
    }
}

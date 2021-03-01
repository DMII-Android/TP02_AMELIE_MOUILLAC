package com.ameliemouillac.gmail.tp02_amelie_mouillac.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ameliemouillac.gmail.tp02_amelie_mouillac.di.DI
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor
import com.ameliemouillac.gmail.tp02_amelie_mouillac.repositories.NeighborRepository

class NeighborViewModel : ViewModel() {
    private val repository: NeighborRepository = DI.repository

    // On fait passe plat sur le résultat retourné par le repository
    val neighbors: LiveData<List<Neighbor>>
        get() = repository.getNeighbours()
}

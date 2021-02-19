package com.ameliemouillac.gmail.tp02_amelie_mouillac.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ameliemouillac.gmail.tp02_amelie_mouillac.NavigationListener
import com.ameliemouillac.gmail.tp02_amelie_mouillac.adapters.ListNeighborHandler
import com.ameliemouillac.gmail.tp02_amelie_mouillac.adapters.ListNeighborsAdapter
import com.ameliemouillac.gmail.tp02_amelie_mouillac.data.NeighborRepository
import com.ameliemouillac.gmail.tp02_amelie_mouillac.databinding.ListNeighborsFragmentBinding
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor


class ListNeighborsFragment : Fragment(), ListNeighborHandler {

    lateinit var binding: ListNeighborsFragmentBinding

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = ListNeighborsFragmentBinding.inflate(inflater, container, false)
        binding.neighborsList.layoutManager = LinearLayoutManager(context)
        binding.neighborsList.addItemDecoration(
                DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                )
        )
        addNeighborEvent()
        return binding.root
    }

    fun addNeighborEvent() {
        binding.addNeighbor.setOnClickListener(View.OnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        binding.neighborsList.adapter = adapter
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {
        val builder = AlertDialog.Builder(context!!)
        builder.setTitle("Confirmation")
        builder.setMessage("Voulez-vous supprimer ce voisin ?")
            .setPositiveButton("Oui",
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context, "yes", Toast.LENGTH_LONG).show()
                    NeighborRepository.getInstance().deleteNeighbor(neighbor)
                    binding.neighborsList.adapter?.notifyDataSetChanged()
                })
            .setNegativeButton("Non",
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context, "nope", Toast.LENGTH_LONG).show()
                })
        // Create the AlertDialog object and return it
        builder.create().show()
    }

}
package com.ameliemouillac.gmail.tp02_amelie_mouillac.ui.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ameliemouillac.gmail.tp02_amelie_mouillac.NavigationListener
import com.ameliemouillac.gmail.tp02_amelie_mouillac.R
import com.ameliemouillac.gmail.tp02_amelie_mouillac.adapters.ListNeighborHandler
import com.ameliemouillac.gmail.tp02_amelie_mouillac.adapters.ListNeighborsAdapter
import com.ameliemouillac.gmail.tp02_amelie_mouillac.databinding.ListNeighborsFragmentBinding
import com.ameliemouillac.gmail.tp02_amelie_mouillac.di.DI
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor
import com.ameliemouillac.gmail.tp02_amelie_mouillac.viewmodels.NeighborViewModel

class ListNeighborsFragment : Fragment(), ListNeighborHandler {

    lateinit var binding: ListNeighborsFragmentBinding
    private lateinit var viewModel: NeighborViewModel

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
        viewModel = ViewModelProvider(this).get(NeighborViewModel::class.java)
        return binding.root
    }

    private fun addNeighborEvent() {
        binding.addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setData()
    }

    private fun setData() {
        /*
        val neighbors = DI.repository.getNeighbours()
        neighbors.observe(
            viewLifecycleOwner,
            Observer<List<Neighbor>> { t ->
                val adapter = ListNeighborsAdapter(t, this@ListNeighborsFragment)
                binding.neighborsList.adapter = adapter
            }
        )*/

        viewModel.neighbors.observe(
            viewLifecycleOwner,
            Observer<List<Neighbor>> { t ->
                val adapter = ListNeighborsAdapter(t, this@ListNeighborsFragment)
                binding.neighborsList.adapter = adapter
            }
        )
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {
        val builder = AlertDialog.Builder(context!!)
        builder.setTitle(R.string.list_fragment_msg_delete_validation_title)
        builder.setMessage(R.string.list_fragment_msg_delete_validation)
            .setPositiveButton(
                R.string.say_yes,
                DialogInterface.OnClickListener { dialog, id ->
                    DI.repository.deleteNeighbor(neighbor)
                    binding.neighborsList.adapter?.notifyDataSetChanged()
                    Toast.makeText(context, neighbor.name + R.string.was_deleted, Toast.LENGTH_LONG).show()
                }
            )
            .setNegativeButton(
                R.string.say_no,
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context, neighbor.name + R.string.wasnt_deleted, Toast.LENGTH_LONG).show()
                }
            )
        // Create the AlertDialog object and return it
        builder.create().show()
    }
}

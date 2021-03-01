package com.ameliemouillac.gmail.tp02_amelie_mouillac.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.afollestad.vvalidator.form
import com.ameliemouillac.gmail.tp02_amelie_mouillac.R
import com.ameliemouillac.gmail.tp02_amelie_mouillac.repositories.NeighborRepository
import com.ameliemouillac.gmail.tp02_amelie_mouillac.databinding.AddNeighborBinding
import com.ameliemouillac.gmail.tp02_amelie_mouillac.models.Neighbor
import java.util.*

class AddNeighbourFragment : Fragment() {
    private lateinit var binding: AddNeighborBinding

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddNeighborBinding.inflate(inflater, container, false)

        onValidateClick()
        TODO("Améliorer la validation du formulaire")

        return binding.root
    }

    private fun onValidateClick() {
        form {
            input(binding.name) {
                isNotEmpty()
            }
            input(binding.image) {
                isNotEmpty()
            }
            input(binding.adress) {
                isNotEmpty()
            }
            input(binding.phone) {
                isNotEmpty()
            }
            input(binding.about) {
                isNotEmpty()
                length().atMost(30)
            }
            input(binding.website) {
                isNotEmpty()
            }

            submitWith(binding.validateNeighbor) { result ->
                var neighbor = Neighbor(
                    UUID.randomUUID().mostSignificantBits,
                    binding.name.text.toString(),
                    binding.image.text.toString(),
                    binding.adress.text.toString(),
                    binding.phone.text.toString(),
                    binding.about.text.toString(),
                    false,
                    binding.website.text.toString()
                )
                NeighborRepository.getInstance().createNeighbor(neighbor)
                Toast.makeText(context, binding.name.text.toString() + R.string.was_created, Toast.LENGTH_LONG).show()
            }
        }.validate()

    }
}
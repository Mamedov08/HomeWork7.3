package com.example.homework73.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework73.R
import com.example.homework73.databinding.FragmentCharactersBinding
import com.example.homework73.ui.adapter.CharactersAdapter
import com.example.homework73.ui.model.CharacterModel

class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Инициализируем binding
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Создаем адаптер с листом из моделек и связываем его с RecyclerView
        val adapter =
            CharactersAdapter(
                listOf(
                    CharacterModel(R.drawable.ic_rick, "Alive", "Rick Sanchez"),
                    CharacterModel(R.drawable.image_, "Alive", "Morty Smith"),
                    CharacterModel(R.drawable.ic_albert, "Dead", "Albert Enstein"),
                    CharacterModel(R.drawable.ic_jerry, "Alive", "Jerry Smith")
                ), this::onItemClick
            )
        binding.recyclerview.adapter = adapter
    }

    private fun onItemClick(character: CharacterModel) {
        /*
        При нажатии на айтемку, навигируем на следующий фрагмент с этой моделькой
        Для того чтобы снавигировать вызываем следующее. Класс Directions создается когда
        указываешь стрелочку в nav_graph
         */
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(
                character
            )
        )
    }
}
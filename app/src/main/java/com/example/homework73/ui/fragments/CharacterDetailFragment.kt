package com.example.homework73.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.homework73.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {
    private lateinit var binding: FragmentCharacterDetailBinding
    // Создаем args переменную - улучшенный bundle для получения данных
    private val args by navArgs<CharacterDetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Достаем данные из safe args и связываем их с вьюшками
        binding.imCharacter.setImageResource(args.character.image)
        binding.tvCharacterStatus.text = args.character.status
        binding.tvCharacterName.text = args.character.name
    }
}
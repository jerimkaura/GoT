package com.jerimkaura.got.presentation.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jerimkaura.got.R
import com.jerimkaura.got.databinding.FragmentSingleCharacterBinding
import com.jerimkaura.got.presentation.viewmodel.CharactersViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleCharacterFragment : Fragment(R.layout.fragment_single_character) {
    private val charactersViewModel: CharactersViewModel by viewModels()
    private lateinit var binding: FragmentSingleCharacterBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingleCharacterBinding.bind(view)
        arguments?.let { bundle ->
            val passedArguments = SingleCharacterFragmentArgs.fromBundle(bundle)
            charactersViewModel.getCharacterById(passedArguments.characterId)
                .observe(viewLifecycleOwner) { character ->
                    if (character !=null){
                        binding.characterFamily.text = character.family
                        binding.characterTitle.text = character.fullName
                        Picasso.get().load(character.imageUrl).into(binding.characterImage)
                        binding.tvCharacterName.text = character.title
                    }
                }
        }
    }
}
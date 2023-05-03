package com.example.applicationtp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.applicationtp.databinding.FragmentAboutUsBinding
import com.example.applicationtp.databinding.FragmentResultsBinding


class ResultsFragment() : Fragment() {

    private lateinit var binding: FragmentResultsBinding
    val args: ResultsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultsBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val nbFlag = args.flag
        val nameCountry = args.country
        val wellDone = args.answer

        binding.AnswerTV.text=nameCountry + " was the right answer"
        binding.imageView3.setImageResource(nbFlag)
        binding.WellDoneTV.text=wellDone

        val navController = findNavController()

        binding.buttonPlayAgain.setOnClickListener {
            navController.navigate(R.id.action_resultsFragment_to_gameFragment)
        }
        binding.backButtonResults.setOnClickListener {
            navController.navigate(R.id.action_resultsFragment_to_gameFragment)
        }
    }
}
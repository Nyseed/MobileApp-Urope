package com.example.applicationtp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.applicationtp.databinding.FragmentAboutUsBinding
import com.example.applicationtp.databinding.FragmentGameBinding
import com.example.applicationtp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

       binding.buttonPlay.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_gameFragment)
        }
        binding.buttonRules.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_rulesFragment)
        }
        binding.buttonAbout.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_aboutUsFragment)
        }
    }
}
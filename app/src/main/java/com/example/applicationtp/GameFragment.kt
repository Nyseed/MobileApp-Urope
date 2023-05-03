package com.example.applicationtp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.applicationtp.data.Pays
import com.example.applicationtp.data.listPays
import com.example.applicationtp.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {

    private lateinit var binding : FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentGameBinding.inflate(LayoutInflater.from(context))
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val randomValue= Random.nextInt(0, listPays.size)

        val countries: List<Pays> = listPays
        val theCountry : Pays = countries[randomValue]
        val theFlag:Int = theCountry.countryImage
        val CountryName : String = theCountry.name

        binding.imageView.setImageResource(theFlag)

        val navController = findNavController()

        binding.buttonValidate.setOnClickListener {


            val answer :String = binding.editTextPersonName.getText().toString()

            val result : String

            if (answer.uppercase()==CountryName.uppercase()) {
                result = "Well Done !"
            }else{
                result = "Wrong Answer ..."
            }

            val action = GameFragmentDirections.actionGameFragmentToResultsFragment(CountryName,theFlag,result)
            navController.navigate(action)
        }
        binding.backButtonGame.setOnClickListener {
            navController.navigate(R.id.action_gameFragment_to_homeFragment)
        }
    }
}

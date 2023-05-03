package com.example.applicationtp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applicationtp.data.Data
import com.example.applicationtp.databinding.FragmentAboutUsBinding


class AboutUsFragment : Fragment() {
    private lateinit var binding: FragmentAboutUsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutUsBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listeInfos: List<String> = Data.infosPaulRomaric
        val adapter = MyAdapter(listeInfos)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val navController = findNavController()

        binding.buttonCV.setOnClickListener {
            val url =
                "https://drive.google.com/file/d/1XearUCG8INAK2f2R8zNNGjP7D0066u5o/view?usp=sharing"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }
        binding.backButtonAU.setOnClickListener {
            navController.navigate(R.id.action_aboutUsFragment_to_homeFragment)
        }
    }
}
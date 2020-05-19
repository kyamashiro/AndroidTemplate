package com.example.mvvmtemplate.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import com.example.mvvmtemplate.R


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // to Second Fragment
        view.findViewById<Button>(R.id.to_second_fragment_button).setOnClickListener {
            findNavController(view).navigate(R.id.action_mainFragment_to_secondFragment)
        }
        // to Third Fragment
        view.findViewById<Button>(R.id.to_third_fragment_button).setOnClickListener {
            findNavController(view).navigate(R.id.action_mainFragment_to_thirdFragment)
        }
    }
}

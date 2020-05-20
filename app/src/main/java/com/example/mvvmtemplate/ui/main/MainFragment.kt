package com.example.mvvmtemplate.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mvvmtemplate.R
import com.example.mvvmtemplate.entity.User


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var navController: NavController

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
        navController = Navigation.findNavController(view)
        // to Second Fragment
        view.findViewById<Button>(R.id.to_second_fragment_button).setOnClickListener {
            val user = User(1, "Test")
            // SecondFragmentにデータを渡す
            val action = MainFragmentDirections.actionMainFragmentToSecondFragment(user)
            navController.navigate(action)
        }
        // to Third Fragment
        view.findViewById<Button>(R.id.to_third_fragment_button).setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_thirdFragment)
        }
    }
}

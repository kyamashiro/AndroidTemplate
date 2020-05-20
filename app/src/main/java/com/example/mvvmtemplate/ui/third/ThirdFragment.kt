package com.example.mvvmtemplate.ui.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmtemplate.R
import com.example.mvvmtemplate.databinding.ThirdFragmentBinding
import kotlinx.android.synthetic.main.third_fragment.*

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private var binding: ThirdFragmentBinding? = null

    // Use the 'by viewModels()' Kotlin property delegate
    // by viewModels()で自動で紐づけされる
    // calcModel = ViewModelProviders.of(this).get(CalcModel::class.java)と書く必要がない
    private val calcModel: CalcModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // viewModelをbinding
        binding = DataBindingUtil.bind(view)
        binding!!.calcModel = calcModel
    }

    override fun onResume() {
        super.onResume()

        val observer = Observer<String> {
            if (augened.text.isNotBlank() && addend.text.isNotBlank())
                sum.text = (calcModel.augened.value!!.toInt() + calcModel.addend.value!!.toInt()).toString()
        }

        calcModel.augened.observe(this, observer)
        calcModel.addend.observe(this, observer)
    }
}

package com.example.straterproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.straterproject.R
import com.example.straterproject.databinding.FragmentQuranPageBinding
import com.example.straterproject.ui.base.BaseFragment

class QuranPageFragment : BaseFragment<FragmentQuranPageBinding>() {
    override val layoutFragmentId: Int=R.layout.fragment_quran_page
    override val viewModel: ViewModel
        get() = TODO("Not yet implemented")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}
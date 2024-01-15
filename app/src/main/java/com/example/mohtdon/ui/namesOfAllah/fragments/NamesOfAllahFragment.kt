package com.example.mohtdon.ui.namesOfAllah.fragments


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mohtdon.R
import com.example.mohtdon.databinding.FragmentNamesOfAllahBinding
import com.example.mohtdon.ui.base.BaseFragment
import com.example.mohtdon.ui.namesOfAllah.adapters.NamesGridViewAdapter
import com.example.mohtdon.ui.namesOfAllah.viewModels.NamesOfAllahViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NamesOfAllahFragment : BaseFragment<FragmentNamesOfAllahBinding>(),
    NamesGridViewAdapter.OnNameGridViewListener, AdapterView.OnItemClickListener {
    override val layoutFragmentId: Int = R.layout.fragment_names_of_allah
    override val viewModel: NamesOfAllahViewModel by viewModels()

    lateinit var namesListAdapter: NamesGridViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setNamesList()
        binding.pageHeader.headerTitle.text = "اسماء الله الحسني"
        binding.pageHeader.search.visibility = View.GONE
    }

    private fun setNamesList() {
        val nameItems =
            viewModel.namesOfAllahListItems.value.namesOfAllahList
            namesListAdapter = NamesGridViewAdapter(this,activity, nameItems)
            binding.allahNamesGV.adapter = namesListAdapter
        binding.allahNamesGV.onItemClickListener=this

    }

    override fun onItemclick(position: Int) {
        val selectedName = viewModel.namesOfAllahListItems.value.namesOfAllahList[position]
        val action =
            NamesOfAllahFragmentDirections.actionNamesOfAllahFragmentToNameOfAllahMeaningFragment(selectedName)
        findNavController().navigate(action)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        onItemclick(p2)
    }
}
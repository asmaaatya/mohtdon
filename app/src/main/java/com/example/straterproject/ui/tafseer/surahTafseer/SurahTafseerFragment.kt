package com.example.straterproject.ui.tafseer.ayaTafseer

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.straterproject.R
import com.example.straterproject.databinding.FragmentSurahTafseerBinding
import com.example.straterproject.ui.base.BaseFragment
import com.example.straterproject.ui.tafseer.surahTafseer.SurahTafseerRvAdapter
import com.example.straterproject.ui.tafseer.surahTafseer.SurahTafseerRvModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SurahTafseerFragment : BaseFragment<FragmentSurahTafseerBinding>() {
    override val layoutFragmentId: Int = R.layout.fragment_surah_tafseer
    override val viewModel: SurahTafseerViewModel by viewModels()
    private val args: SurahTafseerFragmentArgs by navArgs()
    private lateinit var adapter: SurahTafseerRvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        setAdapter()
    }

    private fun setAdapter() {
        val position = args.position
        val surrahTafseerArray = ArrayList<SurahTafseerRvModel>()
        viewModel.getSurahNameAndTafseer(position)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.surahTafseerUiState.collect {
                for (i in 0 until it.surahAyatText.size) {
                    surrahTafseerArray.add(
                        SurahTafseerRvModel(
                            it.surahName,
                            it.surahAyatText[i],
                            it.surahTafseer[i].ayahNumber,
                            it.surahTafseer[i].ayahTafseer
                        )
                    )
                }
            }
        }
        Log.i("ahmed", surrahTafseerArray.toString())
        adapter = SurahTafseerRvAdapter(surrahTafseerArray)
        binding.surahTafseerRv.adapter = adapter
    }

}
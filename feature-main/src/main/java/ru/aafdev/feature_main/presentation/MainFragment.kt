package ru.aafdev.feature_main.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.aafdev.core_ui.UiState
import ru.aafdev.core_ui.models.HeaderUiModel
import ru.aafdev.core_ui.models.NetologyDataUiModel
import ru.aafdev.core_ui.models.base.BaseUiModel
import ru.aafdev.feature_main.databinding.FragmentMainBinding
import ru.aafdev.feature_main.presentation.recycler.MainRecyclerViewAdapter

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter: MainRecyclerViewAdapter = MainRecyclerViewAdapter()

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerView?.adapter = adapter

        lifecycleScope.launch {
            viewModel.state.collect(::onStateChanged)
        }
    }

    private fun onStateChanged(state: UiState<List<NetologyDataUiModel>>) {
        when (state) {
            is UiState.Loading -> onLoading()
            is UiState.Success -> onSuccess(state.data)
            is UiState.Error -> onError(state)
        }
    }

    private fun onLoading() {
        binding?.apply {
            recyclerView.isVisible = false
            fab.isVisible = false
            progressBar.isVisible = true
        }
    }

    private fun onSuccess(data: List<NetologyDataUiModel>) {
        val header = HeaderUiModel
        val items = mutableListOf<BaseUiModel>(header).apply {
            addAll(1, data)
        }
        adapter.updateItems(items)

        binding?.apply {
            recyclerView.isVisible = true
            fab.isVisible = true
            progressBar.isVisible = false
        }
    }

    private fun onError(error: UiState.Error) {
        Log.d("MainFragment", error.message, error.throwable)
    }
}
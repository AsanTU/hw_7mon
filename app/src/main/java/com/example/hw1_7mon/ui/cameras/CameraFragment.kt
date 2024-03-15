package com.example.hw1_7mon.ui.cameras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.hw1_7mon.data.local.BaseDao
import com.example.hw1_7mon.data.local.models.DoorsEntity
import com.example.hw1_7mon.databinding.FragmentCamerasBinding
import com.example.hw1_7mon.domain.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class CameraFragment : Fragment() {
    private lateinit var binding: FragmentCamerasBinding
    private val viewModel: CameraViewModel by viewModels()
    private val adapter = CameraAdapter()

    @Inject
    lateinit var dao: BaseDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCamerasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRequest()
        binding.recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.camerasFlow.collect {
                when (it) {
                    is UiState.Empty -> {
                        adapter.submitList(emptyList())
                        adapter.notifyDataSetChanged()
                    }

                    is UiState.Error -> {
                        Toast.makeText(requireContext(), "Произошла ошибка", Toast.LENGTH_LONG)
                            .show()
                    }

                    is UiState.Loading -> {}
                    is UiState.Success -> {
                        if (dao.getDoorsCount() == 0) {
                            viewModel.viewModelScope.launch {
                                viewModel.getCameras()
                                adapter.submitList(it.data?.data?.cameras)
                                val data = DoorsEntity(
                                    count = adapter.currentList.size
                                )
                                dao.insertDoorsModel(data)
                            }
                        } else {
                            binding.cameraRefreshLayout.setOnRefreshListener {
                                viewModel.viewModelScope.launch {
                                    viewModel.getCameras()
                                    adapter.submitList(it.data?.data?.cameras)
                                }
                                binding.cameraRefreshLayout.isRefreshing = false
                            }
                        }
                    }
                }
            }
        }

    }

    private fun initRequest() {
        viewModel.viewModelScope.launch { viewModel.getCameras() }
    }
}
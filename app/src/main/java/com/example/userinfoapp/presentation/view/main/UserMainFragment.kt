package com.example.userinfoapp.presentation.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.userinfoapp.databinding.FragmentUserMainBinding
import com.example.userinfoapp.presentation.view.detail.UserDetailViewModel
import com.example.userinfoapp.presentation.view.main.adapter.UserMainAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserMainFragment : Fragment() {
    private var _viewBinding: FragmentUserMainBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: UserMainViewModel by activityViewModels()
    private val detailViewModel: UserDetailViewModel by activityViewModels()

    private val userAdapter by lazy {
        UserMainAdapter { user ->
            detailViewModel.setUserHeartState(user.userHeart)
            findNavController().navigate(
                UserMainFragmentDirections.actionUserMainFragmentToUserDetailFragment(user)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserMainBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservable()
    }

    private fun initView() {
        with(viewBinding.rvUserList) {
            adapter = userAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
        }
    }

    private fun initObservable() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.userInfoList.collectLatest { dataList ->
                    dataList?.let {
                        userAdapter.submitList(it)
                    }
                }
            }
        }
    }
}
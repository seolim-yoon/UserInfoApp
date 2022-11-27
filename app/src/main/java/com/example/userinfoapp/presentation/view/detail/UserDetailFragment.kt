package com.example.userinfoapp.presentation.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.userinfoapp.databinding.FragmentUserDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment: Fragment() {
    private var _viewBinding: FragmentUserDetailBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: UserDetailViewModel by activityViewModels()

    private val args by navArgs<UserDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(viewBinding) {
            user = args.user
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
            ivUserDetailHeart.setOnClickListener {
                viewModel.postUserHeartState(args.user.id)
            }
        }
    }
}
package com.example.myapp0613.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapp0613.R
import com.example.myapp0613.adapter.HomeViewpagerAdapter
import com.example.myapp0613.databinding.FragmentHomeBinding
import com.example.myapp0613.fragments.categories.CommercialFragment
import com.example.myapp0613.fragments.categories.MainCategoryFragment
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            CommercialFragment()
        )

        val viewPager2Adapter =
            HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Main"
                1 -> tab.text = "Commercial"
            }
        }.attach()
    }
}

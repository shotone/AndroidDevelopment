package com.example.lection5davaleba

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager,private val items:MutableList<UserModel>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        val fragment = FirstFragment()
        fragment.model = items[position]
        return fragment
    }

    override fun getCount() = items.size
}
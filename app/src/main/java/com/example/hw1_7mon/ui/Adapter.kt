package com.example.hw1_7mon.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hw1_7mon.ui.cameras.CameraFragment
import com.example.hw1_7mon.ui.doors.DoorsFragment

class Adapter(fragment: FragmentActivity):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            CameraFragment()
        else
            DoorsFragment()
    }
}
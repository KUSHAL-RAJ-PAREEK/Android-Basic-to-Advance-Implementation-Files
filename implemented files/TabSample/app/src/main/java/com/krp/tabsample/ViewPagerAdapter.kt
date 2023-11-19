package com.krp.tabsample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
       return when (position) {
           0 -> {
               AFragment()
           }
           1 -> {
               BFragment()
           }
           else -> {
               CFragment()
           }
       }
    }

    override fun getPageTitle(position: Int): CharSequence? {
       return when (position) {
           0 -> {
               "Tab 1"
           }
           1 -> {
               "Tab 2"
           }
           else -> {
               "Tab 3"
           }
       }
    }

}
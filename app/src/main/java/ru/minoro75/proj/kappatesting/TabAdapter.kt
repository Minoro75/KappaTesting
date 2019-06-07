package ru.minoro75.proj.kappatesting

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.minoro75.proj.kappatesting.fragments.EmailedFragment
import ru.minoro75.proj.kappatesting.fragments.SharedFragment
import ru.minoro75.proj.kappatesting.fragments.ViewedFragment

class TabAdapter(private val myContext: Context, fm:FragmentManager, internal var totalTabs:Int) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment? {
    when(position){
        0-> return EmailedFragment.newInstance()
        1-> return SharedFragment.newInstance()
        2-> return ViewedFragment.newInstance()
        else-> return null
    }
    }

    override fun getCount(): Int {
    return totalTabs
    }

}
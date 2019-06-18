package ru.minoro75.proj.kappatesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/*attach required Fragments to ViewPager and Viewpager to TabLayout*/
class MainActivity : AppCompatActivity() {

    lateinit var viewPager:ViewPager
    lateinit var tabLayout:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.tabs)

        tabLayout.addTab(tabLayout.newTab().setText("Most Emailed"))
        tabLayout.addTab(tabLayout.newTab().setText("Most Shared"))
        tabLayout.addTab(tabLayout.newTab().setText("Most Viewed"))
        tabLayout.addTab(tabLayout.newTab().setText("Bookmarks"))

        tabLayout.tabGravity=TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(this,supportFragmentManager,tabLayout.tabCount)
        viewPager.adapter =adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                viewPager!!.currentItem = p0!!.position
            }
        })
    }
}

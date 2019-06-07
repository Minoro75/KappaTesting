package ru.minoro75.proj.kappatesting.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_viewed.*
import ru.minoro75.proj.kappatesting.NewsAdapter
import ru.minoro75.proj.kappatesting.R
import ru.minoro75.proj.kappatesting.data.News

class ViewedFragment : Fragment() {
    private val mNewsList = listOf(
        News("some","dumb","shit"),
        News("sogdy once  me","the gd","3g1"),
        News("somggody once told me","gggg","31232fsf1"),
        News("somebodfffatold me","thff","3fasf21"),
        News(" fsaold me","the wold","312321"),
        News("somebody once told me","the wold","311")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance =true
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_viewed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewed_list.apply {
            layoutManager =LinearLayoutManager(activity)
            adapter = NewsAdapter(mNewsList)

        }
    }
companion object{
    fun newInstance():ViewedFragment = ViewedFragment()
}
}

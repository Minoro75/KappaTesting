package ru.minoro75.proj.kappatesting.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_shared.*
import ru.minoro75.proj.kappatesting.NewsAdapter
import ru.minoro75.proj.kappatesting.R
import ru.minoro75.proj.kappatesting.data.News

class SharedFragment : Fragment() {
    private val mNewsList = listOf(
        News("s","the wdd","1"),
        News("somebody once  me","the wold","32d"),
        News("somebos told me","the wold","d321"),
        News(" once ame","the wold","312321"),
        News("soay once told me","the wold","311")
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
        return inflater.inflate(R.layout.fragment_shared, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared_list.apply {
            layoutManager=LinearLayoutManager(activity)
            adapter=NewsAdapter(mNewsList)
        }
    }

companion object{
    fun newInstance():SharedFragment =SharedFragment()
}
}

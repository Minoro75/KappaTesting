package ru.minoro75.proj.kappatesting.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_bookmarks.*
import ru.minoro75.proj.kappatesting.NewsAdapter

import ru.minoro75.proj.kappatesting.R
import ru.minoro75.proj.kappatesting.data.NYTNewsResponse
import ru.minoro75.proj.kappatesting.data.NYTNewsItem


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BookmarksFragment : Fragment() {
    private val mNewsList = listOf(
        NYTNewsResponse(
            listOf(
                NYTNewsItem("fsfsdf", ("fsdfsd")),
                NYTNewsItem("fsfsdf", ("fsdfsd")),
                NYTNewsItem("fsfsdf", ("fsdfsd")),
                NYTNewsItem("fsfsdf", ("fsdfsd"))
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmarks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookmarks_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = NewsAdapter(mNewsList)
        }
    }

    companion object {
        fun newInstance(): BookmarksFragment = BookmarksFragment()
    }
}

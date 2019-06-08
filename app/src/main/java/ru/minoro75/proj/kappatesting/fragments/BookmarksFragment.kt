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
import ru.minoro75.proj.kappatesting.data.News

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
        News("somebody once told me", "the wold", "1"),
        News("somebody once  me", "the wold", "321"),
        News("somebody once told me", "wold", "312321"),
        News("somebody once told me", "the wold", "312321"),
        News(" once told me", "the wold", "312321"),
        News("somebody once told me", "the wold", "311")
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

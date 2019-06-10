package ru.minoro75.proj.kappatesting.fragments



import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_emailed.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.minoro75.proj.kappatesting.NewsAdapter
import ru.minoro75.proj.kappatesting.R
import ru.minoro75.proj.kappatesting.data.NYTNewsItem
import ru.minoro75.proj.kappatesting.data.NYTNewsResponse
import ru.minoro75.proj.kappatesting.networking.ApiFactory

class EmailedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance=true


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_emailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        emailed_list.apply {
            adapter = NewsAdapter()
            layoutManager = LinearLayoutManager(context)
        }
    }


    companion object{
        fun newInstance():EmailedFragment =EmailedFragment()
    }
}

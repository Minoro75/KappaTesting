package ru.minoro75.proj.kappatesting.fragments



import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_emailed.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.minoro75.proj.kappatesting.NewsAdapter
import ru.minoro75.proj.kappatesting.R
import ru.minoro75.proj.kappatesting.data.NYTNewsItem
import ru.minoro75.proj.kappatesting.data.NYTNewsResponse
import ru.minoro75.proj.kappatesting.data.NewsApi
import ru.minoro75.proj.kappatesting.networking.ApiFactory
import ru.minoro75.proj.kappatesting.networking.ApiModule

/*fragment with list of most emailed news from NYTapi resnonse*/
class EmailedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*rotations handle*/
        retainInstance=true


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_emailed, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*async load list of news*/
        doAsync {
            val api = NewsApi.getApi().getEmailedNews().body?.results
            uiThread {
                val mNews: List<NYTNewsItem> = api!!
                /*store news to val and pass it to adapter*/
                emailed_list.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = NewsAdapter(mNews)

                }
            }
        }





    }


    companion object{
        fun newInstance():EmailedFragment =EmailedFragment()


    }
}

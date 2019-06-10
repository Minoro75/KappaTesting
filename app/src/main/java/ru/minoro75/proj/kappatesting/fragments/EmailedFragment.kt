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
import ru.minoro75.proj.kappatesting.data.NYTNewsResponse
import ru.minoro75.proj.kappatesting.networking.ApiFactory

class EmailedFragment : Fragment() {
    private val mNewsList = listOf(
        NYTNewsResponse()
        var recyclerView : RecyclerView
            lateinit var adapter:NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance=true
        emailed_list.apply {
            adapter = NewsAdapter(mNewsList)
            layoutManager = LinearLayoutManager(context)
        }

        //getNews()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_emailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getNews() {
        val call: Call<NYTNewsResponse> = ApiFactory.getClient.getEmailedNews()
        call.enqueue(object : Callback<List<NYTNewsResponse>> {
            override fun onFailure(call: Call<List<NYTNewsResponse>>, t: Throwable) {
                Log.d("KAPPA", "FAILED")
        }

            override fun onResponse(call: Call<List<NYTNewsResponse>>?, response: Response<List<NYTNewsResponse>>?) {
                // newsList.addAll(response!!.body()!!)
                emailed_list.adapter?.notifyDataSetChanged()


            }

        })
    }
    companion object{
        fun newInstance():EmailedFragment =EmailedFragment()
    }
}

package ru.minoro75.proj.kappatesting

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.find
import ru.minoro75.proj.kappatesting.data.NYTNewsItem
import ru.minoro75.proj.kappatesting.data.NYTNewsResponse
import ru.minoro75.proj.kappatesting.networking.ApiFactory


class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {
    private var newsItems = ApiFactory.getClient.getEmailedNews().execute().body()?.results
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
    val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
        return newsItems!!.size
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.bind(newsItems?.get(position))
    }


}
class NewsViewHolder(inflater: LayoutInflater, parent:ViewGroup):RecyclerView.ViewHolder(
    inflater.inflate(R.layout.news_item,parent,false)){
    private var mTitle:TextView? =null
    private var mDate:TextView? = null

    init {
    mTitle = itemView.find(R.id.news_title)
    mDate = itemView.find(R.id.news_date)
    }

    fun bind(news: NYTNewsItem?) {
        mTitle?.text = news?.title
        mDate?.text = news?.published_date
    }
}

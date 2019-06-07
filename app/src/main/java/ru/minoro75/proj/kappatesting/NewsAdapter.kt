package ru.minoro75.proj.kappatesting

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.find
import ru.minoro75.proj.kappatesting.data.News
import java.util.zip.Inflater

class NewsAdapter(private val list: List<News>):RecyclerView.Adapter<NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
    val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int {
    return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
    val news:News = list[position]
        holder.bind(news)
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

    fun bind(news: News){
        mTitle?.text = news.title
        mDate?.text = news.date
    }
}

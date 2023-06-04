package com.masdiq.newsappwithapi.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masdiq.newsappwithapi.WebViewActivity
import com.masdiq.newsappwithapi.databinding.NewsLayoutBinding
import com.masdiq.newsappwithapi.model.Result

class TechnologyAdapter : RecyclerView.Adapter<TechnologyAdapter.ViewHolder>() {

    private var technologyList = ArrayList<Result>()

    fun setTechnologyList(technologyList: List<Result>) {
        this.technologyList = technologyList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val technologyBinding: NewsLayoutBinding) :
        RecyclerView.ViewHolder(technologyBinding.root) {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TechnologyAdapter.ViewHolder {
        return ViewHolder(NewsLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TechnologyAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(technologyList[position].title)
            .into(holder.technologyBinding.newsImage)
        with(holder.technologyBinding) {
            newsTitle.text = technologyList[position].title
            newsAuthor.text = technologyList[position].title
            newsPublished.text = technologyList[position].title
        }
        holder.itemView.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val move = Intent(activity, WebViewActivity::class.java)
            move.putExtra("link", technologyList[position].url)
            activity.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return technologyList.size
    }
}
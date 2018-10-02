package android.ihorkostenko.animepedia.presentation.ui.adapters

import android.ihorkostenko.animepedia.domain.entities.Article
import android.ihorkostenko.animepedia.domain.entities.VideoEpisode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.databinding.ItemArticleBinding
import animepedia.android.ihorkostenko.animepedia.databinding.ItemVideoBinding


class NewsRecyclerViewAdapter(
        private var articles: List<Article>)
    : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onClick(item: Article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun newValue(articles: List<Article>) {
        this.articles = articles
        notifyItemInserted(0)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(articles[position])

    inner class ViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article) {
            binding.data = item
            binding.root.setOnClickListener { _ ->
                listener.onClick(item)
            }
            binding.executePendingBindings()
        }
    }
}

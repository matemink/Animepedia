package android.ihorkostenko.animepedia.presentation.ui.adapters

import android.ihorkostenko.animepedia.domain.entities.VideoEpisode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.databinding.ItemVideoBinding


class VideosRecyclerViewAdapter(
        private var videos: List<VideoEpisode>)
    : RecyclerView.Adapter<VideosRecyclerViewAdapter.ViewHolder>() {

    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onClick(item: VideoEpisode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVideoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun newValue(videos: List<VideoEpisode>) {
        this.videos = videos
        notifyItemInserted(0)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(videos[position])

    inner class ViewHolder(private val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VideoEpisode) {
            binding.data = item
            binding.root.setOnClickListener { _ ->
                listener.onClick(item)
            }
            binding.executePendingBindings()
        }
    }
}

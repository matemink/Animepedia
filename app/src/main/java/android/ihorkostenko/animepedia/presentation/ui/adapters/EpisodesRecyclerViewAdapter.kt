package android.ihorkostenko.animepedia.presentation.ui.adapters

import android.ihorkostenko.animepedia.domain.entities.Episode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.databinding.ItemEpisodeBinding


class EpisodesRecyclerViewAdapter(
        private var episodes: List<Episode>)
    : RecyclerView.Adapter<EpisodesRecyclerViewAdapter.ViewHolder>() {

    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onClick(item: Episode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun newValue(episodes: List<Episode>) {
        this.episodes = episodes
        notifyItemInserted(0)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(episodes[position])

    inner class ViewHolder(private val binding: ItemEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Episode) {
            binding.data = item
            binding.root.setOnClickListener { _ ->
                listener.onClick(item)
            }
            binding.executePendingBindings()
        }
    }
}

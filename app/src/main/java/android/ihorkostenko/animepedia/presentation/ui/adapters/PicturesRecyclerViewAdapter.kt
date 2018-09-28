package android.ihorkostenko.animepedia.presentation.ui.adapters

import android.ihorkostenko.animepedia.domain.entities.Picture
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.databinding.ItemPictureBinding

class PicturesRecyclerViewAdapter(
        private var pictures: List<Picture>)
    : RecyclerView.Adapter<PicturesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPictureBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun newValue(pictures: List<Picture>) {
        this.pictures = pictures
        notifyItemInserted(0)
    }

    override fun getItemCount(): Int = pictures.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(pictures[position])

    inner class ViewHolder(private val binding: ItemPictureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Picture) {
            binding.data = item
            binding.executePendingBindings()
        }
    }
}

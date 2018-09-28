package android.ihorkostenko.animepedia.presentation.ui.adapters

import android.ihorkostenko.animepedia.domain.entities.AnimeCharacter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.databinding.ItemCharacterBinding

class CharactersRecyclerViewAdapter(
        private var characters: List<AnimeCharacter>)
    : RecyclerView.Adapter<CharactersRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun newValue(characters: List<AnimeCharacter>) {
        this.characters = characters
        notifyItemInserted(0)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(characters[position])

    inner class ViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AnimeCharacter) {
            binding.data = item
            binding.executePendingBindings()
        }
    }
}

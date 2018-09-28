package android.ihorkostenko.animepedia.presentation.ui.viewmodels

import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.domain.entities.Characters
import android.ihorkostenko.animepedia.presentation.ui.adapters.CharactersRecyclerViewAdapter
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CharactersViewModel(private val repository: Repository) : ViewModel() {
    lateinit var characters: LiveData<Characters>

    fun init() {
        characters = repository.getCharacters()
    }
}

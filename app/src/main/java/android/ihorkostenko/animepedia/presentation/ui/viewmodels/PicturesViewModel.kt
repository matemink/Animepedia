package android.ihorkostenko.animepedia.presentation.ui.viewmodels

import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.domain.entities.Pictures
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class PicturesViewModel(private val repository: Repository) : ViewModel() {
    lateinit var pictures: LiveData<Pictures>

    fun init() {
        pictures = repository.getPictures()
    }
}

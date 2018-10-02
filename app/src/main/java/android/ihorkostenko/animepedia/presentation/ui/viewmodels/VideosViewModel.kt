package android.ihorkostenko.animepedia.presentation.ui.viewmodels

import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.domain.entities.Pictures
import android.ihorkostenko.animepedia.domain.entities.Videos
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class VideosViewModel(private val repository: Repository) : ViewModel() {
    lateinit var videos: LiveData<Videos>

    fun init() {
        videos = repository.getVideos()
    }
}

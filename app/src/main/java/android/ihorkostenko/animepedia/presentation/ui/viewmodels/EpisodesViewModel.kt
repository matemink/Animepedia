package android.ihorkostenko.animepedia.presentation.ui.viewmodels

import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.domain.entities.Episodes
import android.ihorkostenko.animepedia.domain.entities.News
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class EpisodesViewModel(private val repository: Repository) : ViewModel() {
    lateinit var episodes: LiveData<Episodes>

    fun init() {
        episodes = repository.getEpisodes()
    }
}

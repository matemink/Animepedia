package android.ihorkostenko.animepedia.presentation.ui.viewmodels

import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.domain.entities.News
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class NewsViewModel(private val repository: Repository) : ViewModel() {
    lateinit var news: LiveData<News>

    fun init() {
        news = repository.getNews()
    }
}

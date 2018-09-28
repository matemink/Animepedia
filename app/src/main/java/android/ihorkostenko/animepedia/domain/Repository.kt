package android.ihorkostenko.animepedia.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.ihorkostenko.animepedia.data.datasource.AnimeApiDataSource
import android.ihorkostenko.animepedia.domain.entities.*
import retrofit2.Call
import retrofit2.Response

class Repository(private val apiDataSource: AnimeApiDataSource) {
    fun getCharacters(): LiveData<Characters> {
        val characters = MutableLiveData<Characters>()
        apiDataSource.getCharacters().enqueue(object : retrofit2.Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                characters.value = response.body()
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {

            }
        })
        return characters
    }

    fun getEpisodes(): LiveData<Episodes> {
        val episodes = MutableLiveData<Episodes>()
        apiDataSource.getEpisodes().enqueue(object : retrofit2.Callback<Episodes> {
            override fun onResponse(call: Call<Episodes>, response: Response<Episodes>) {
                episodes.value = response.body()
            }

            override fun onFailure(call: Call<Episodes>, t: Throwable) {

            }
        })
        return episodes
    }

    fun getNews(): LiveData<News> {
        val news = MutableLiveData<News>()
        apiDataSource.getNews().enqueue(object : retrofit2.Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                news.value = response.body()
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

            }
        })
        return news
    }

    fun getPictures(): LiveData<Pictures> {
        val pictures = MutableLiveData<Pictures>()
        apiDataSource.getPictures().enqueue(object : retrofit2.Callback<Pictures> {
            override fun onResponse(call: Call<Pictures>, response: Response<Pictures>) {
                pictures.value = response.body()
            }

            override fun onFailure(call: Call<Pictures>, t: Throwable) {

            }
        })
        return pictures
    }

    fun getVideos(): LiveData<Videos> {
        val videos = MutableLiveData<Videos>()
        apiDataSource.getVideos().enqueue(object : retrofit2.Callback<Videos> {
            override fun onResponse(call: Call<Videos>, response: Response<Videos>) {
                videos.value = response.body()
            }

            override fun onFailure(call: Call<Videos>, t: Throwable) {

            }
        })
        return videos
    }
}
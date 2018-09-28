package android.ihorkostenko.animepedia.data.datasource

import android.ihorkostenko.animepedia.domain.entities.*
import retrofit2.Call
import retrofit2.http.GET

interface AnimeApiDataSource {
    @GET("anime/1/characters_staff")
    fun getCharacters(): Call<Characters>

    @GET("anime/1/episodes")
    fun getEpisodes(): Call<Episodes>

    @GET("anime/1/news")
    fun getNews(): Call<News>

    @GET("anime/1/pictures")
    fun getPictures(): Call<Pictures>

    @GET("anime/1/videos")
    fun getVideos(): Call<Videos>
}







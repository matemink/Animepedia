package animepedia.android.ihorkostenko.animepedia.data.datasource

import animepedia.android.ihorkostenko.animepedia.domain.entities.CharactersAndStaff
import retrofit2.Call
import retrofit2.http.GET

interface AnimeApiDataSource {
    @GET("anime/1/characters_staff")
    fun getCharactersAndStaff(): Call<CharactersAndStaff>
}







package animepedia.android.ihorkostenko.animepedia.domain

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import animepedia.android.ihorkostenko.animepedia.data.datasource.AnimeApiDataSource
import animepedia.android.ihorkostenko.animepedia.domain.entities.CharactersAndStaff
import retrofit2.Call
import retrofit2.Response

class Repository(private val apiDataSource: AnimeApiDataSource) {
    fun getCharactersAndStaff(): LiveData<CharactersAndStaff> {
        val data = MutableLiveData<CharactersAndStaff>()
        apiDataSource.getCharactersAndStaff().enqueue(object : retrofit2.Callback<CharactersAndStaff> {
            override fun onResponse(call: Call<CharactersAndStaff>, response: Response<CharactersAndStaff>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<CharactersAndStaff>, t: Throwable) {

            }
        })
        return data
    }
}
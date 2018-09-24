package animepedia.android.ihorkostenko.animepedia.presentation.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import animepedia.android.ihorkostenko.animepedia.domain.Repository
import animepedia.android.ihorkostenko.animepedia.domain.entities.CharactersAndStaff


class MainViewModel(private val repository: Repository) : ViewModel() {
    lateinit var charactersAndStaff: LiveData<CharactersAndStaff>

    fun init() {
        charactersAndStaff = repository.getCharactersAndStaff()
    }
}

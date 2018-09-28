package android.ihorkostenko.animepedia.di

import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.CharactersViewModel
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.PicturesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel

import org.koin.dsl.module.module

val mainModule = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { PicturesViewModel(get()) }
    single { Repository(get()) }
}


package android.ihorkostenko.animepedia.di

import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.*
import org.koin.android.viewmodel.ext.koin.viewModel

import org.koin.dsl.module.module

val mainModule = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
    viewModel { NewsViewModel(get()) }
    viewModel { PicturesViewModel(get()) }
    viewModel { VideosViewModel(get()) }
    single { Repository(get()) }
}


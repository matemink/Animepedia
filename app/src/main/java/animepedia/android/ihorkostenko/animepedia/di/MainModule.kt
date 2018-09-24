package animepedia.android.ihorkostenko.animepedia.di

import animepedia.android.ihorkostenko.animepedia.domain.Repository
import animepedia.android.ihorkostenko.animepedia.presentation.ui.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel

import org.koin.dsl.module.module

val mainModule = module {
    viewModel { MainViewModel(get()) }
    single { Repository(get()) }
}


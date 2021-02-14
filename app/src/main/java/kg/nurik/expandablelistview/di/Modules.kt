package kg.nurik.expandablelistview.di

import kg.nurik.expandablelistview.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { MainViewModel() }
}

val appModules = listOf(viewModelModule)
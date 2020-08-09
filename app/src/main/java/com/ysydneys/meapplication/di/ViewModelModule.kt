package com.ysydneys.meapplication.di

import com.ysydneys.meapplication.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val VIEW_MODEL_MODULE = module {
    viewModel { ListViewModel(get()) }
}
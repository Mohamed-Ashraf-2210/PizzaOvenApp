package com.example.pizzaovenapp

import com.example.pizzaovenapp.presentation.PizzaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    viewModel { PizzaViewModel() }
}
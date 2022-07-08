package com.rosales.adoptame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rosales.adoptame.repository.*

import com.rosales.adoptame.ui.login.LoginViewModel
import com.rosales.adoptame.ui.petPost.PetPostViewModel
import com.rosales.adoptame.ui.petcard.PetCardViewModel
import com.rosales.adoptame.ui.register.RegisterViewModel
import com.rosales.adoptame.ui.servicecard.ServiceCardViewModel
import com.rosales.adoptame.ui.sheltercard.ShelterCardViewModel

class ViewModelFactory<R>(private val repository: R):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repository as RegisterRepository) as T
        }
        if (modelClass.isAssignableFrom(PetCardViewModel::class.java)) {
            return PetCardViewModel(repository as PetCardRepository) as T
        }
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository as LoginRepository) as T
        }
        if (modelClass.isAssignableFrom(ServiceCardViewModel::class.java)) {
            return ServiceCardViewModel(repository as ServiceCardRepository) as T
        }
        if (modelClass.isAssignableFrom(ShelterCardViewModel::class.java)) {
            return ShelterCardViewModel(repository as ShelterCardRepository) as T
        }
        if (modelClass.isAssignableFrom(PetPostViewModel::class.java)) {
            return PetPostViewModel(repository as PetPostRepository) as T
        }

        throw IllegalArgumentException("Unknown AddViewModel Class")

    }
}
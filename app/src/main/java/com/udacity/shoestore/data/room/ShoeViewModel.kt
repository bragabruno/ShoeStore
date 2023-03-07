package com.udacity.shoestore.data.room

import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe
import kotlinx.coroutines.launch

class ShoeViewModel(private val repository: ShoeRepository) : ViewModel() {

    val allShoes: LiveData<List<Shoe>> = repository.allShoes.asLiveData()

    fun insert(shoe: Shoe) = viewModelScope.launch {
        repository.insert(shoe)
    }
}

class ShoeViewModelFactory(private val repository: ShoeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShoeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
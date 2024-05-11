package org.d3if0142.mybook.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0142.mybook.database.BukuDao
import org.d3if0142.mybook.ui.screen.DetailViewModel
import org.d3if0142.mybook.ui.screen.MainViewModel

class ViewModelFactory (
    private val dao: BukuDao
) : ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun<T: ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
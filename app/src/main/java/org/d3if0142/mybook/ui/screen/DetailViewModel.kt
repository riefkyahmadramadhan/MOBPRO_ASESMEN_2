package org.d3if0142.mybook.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0142.mybook.database.BukuDao
import org.d3if0142.mybook.model.Buku
import java.text.SimpleDateFormat
import java.util.Locale

class DetailViewModel(private val dao: BukuDao) : ViewModel() {

    fun insert(judul: String, quotes: String, genre: String) {
        val buku = Buku(
            judul = judul,
            quotes = quotes,
            genre = genre
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(buku)
        }
    }

    suspend fun getBuku(id: Long): Buku? {
        return dao.getBukuById(id)
    }

    fun update(id: Long, judul: String, quotes: String, genre: String) {
        val buku = Buku(
            id = id,
            judul = judul,
            quotes =  quotes,
            genre = genre
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(buku)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}
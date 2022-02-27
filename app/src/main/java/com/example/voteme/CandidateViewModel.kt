package com.example.voteme

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voteme.api.StudentApi
import com.example.voteme.models.Student
import kotlinx.coroutines.launch


class CandidateViewModel : ViewModel() {

    private val _students = MutableLiveData<List<Student>>()

    val students : LiveData<List<Student>> get()  = _students

    /**
     * Call getStudents() on init so we can display status immediately.
     */
    init {
        Log.d("Candidate", "CandidateViewModel created!")
        getStudents()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [Students] [List] [LiveData].
     */
    private fun getStudents() {

        viewModelScope.launch {
            try {
                _students.value = StudentApi.retrofitService.getStudents()
            } catch (e: Exception) {
                _students.value = listOf()
                e.message
            }
        }
    }
}
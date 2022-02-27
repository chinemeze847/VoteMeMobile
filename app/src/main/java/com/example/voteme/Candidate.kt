package com.example.voteme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.voteme.adapter.CandidateAdapter
import com.example.voteme.databinding.ActivityCandidateBinding
import com.example.voteme.models.Student

class Candidate : AppCompatActivity() {

    private lateinit var binding : ActivityCandidateBinding
    private val viewModel: CandidateViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCandidateBinding.inflate(layoutInflater)
        val view = binding.root

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.candidateRecycler.adapter = CandidateAdapter(getAllStudents())

        setContentView(view)
    }

    private fun getAllStudents() : List<Student>? {
        return viewModel.students.value
    }
}
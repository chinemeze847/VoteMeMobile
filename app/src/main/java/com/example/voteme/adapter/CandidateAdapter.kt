package com.example.voteme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.voteme.R
import com.example.voteme.models.Student

class CandidateAdapter( private val students : List<Student>? )
    :RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder>()
{
    class CandidateViewHolder(private val view : View) : RecyclerView.ViewHolder(view)
    {

        fun bind(student: Student)
        {
            val textView : TextView = view.findViewById(R.id.candidate_title)
            textView.text = student.firstname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidateViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_candidate, parent, false)
        return CandidateViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CandidateViewHolder, position: Int)
    {
        val student = students?.get(position)
        if (student != null) {
            holder.bind(student)
        }
    }

    override fun getItemCount(): Int {
        if (students != null) {
            return students.size
        }
        return 0;
    }
}
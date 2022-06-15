package com.ricardomontemayor.paymeback

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.ricardomontemayor.paymeback.databinding.ItemLoanBinding
import java.text.SimpleDateFormat

class Adapter(var loans: List<Loan>, val onClickDelete: (Int) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLoanBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(view: View){
            val button = view.findViewById<Button>(R.id.btnDelete)
            button.setOnClickListener{onClickDelete(position)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLoanBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val loan = loans[position]
        // For each card, set corresponding loan data
        holder.binding.apply {
            textViewName.text = loan.name
            textViewConcept.text = loan.concept
            textViewAmount.text = String.format("$" + loan.amount)
            textViewDate.text = SimpleDateFormat("dd/MM/yyyy").format(loan.date)
        }

    }

    override fun getItemCount(): Int {
        return loans.size
    }

}
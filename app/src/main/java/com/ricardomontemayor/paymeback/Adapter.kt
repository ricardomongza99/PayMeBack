package com.ricardomontemayor.paymeback

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ricardomontemayor.paymeback.databinding.ItemLoanBinding

class Adapter(var loans: List<Loan>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLoanBinding) : RecyclerView.ViewHolder(binding.root) {

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
            textViewDate.text = loan.date.toString()
        }
    }

    override fun getItemCount(): Int {
        return loans.size
    }
}
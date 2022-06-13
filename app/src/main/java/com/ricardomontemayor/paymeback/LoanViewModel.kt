package com.ricardomontemayor.paymeback

import androidx.lifecycle.ViewModel
import java.util.*

class LoanViewModel: ViewModel() {

    private val _loans = mutableListOf<Loan>()

    val loans get() = _loans

    fun addLoan(name: String, amount: Double, date: Date, concept: String) {
        val newLoan = Loan(name, amount, date, concept)
        _loans.add(newLoan)
    }
}
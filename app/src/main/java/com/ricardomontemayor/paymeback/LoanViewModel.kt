package com.ricardomontemayor.paymeback

import androidx.lifecycle.ViewModel
import java.util.*

class LoanViewModel: ViewModel() {

    private val _loans = mutableListOf<Loan>()
    val loans get() = _loans

    // Total loan amount (sum of all the loans)
    val totalAmount: Double
    get() {
        var sum = 0.0
        for (loan in loans) {
            sum += loan.amount
        }
        return sum
    }

    // Total loan count
    val totalCount: Int
    get() {
        return loans.count();
    }

    fun addLoan(name: String, amount: Double, date: Date, concept: String) {
        val newLoan = Loan(name, amount, date, concept)
        _loans.add(newLoan)
    }
}
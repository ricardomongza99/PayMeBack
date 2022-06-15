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

    init {
        // Add test data
        addLoan("Ricardo", 200.0, Date(), "He owes me")
        addLoan("Luis", 800.0, Date(), "I payed for his concert ticket")
        addLoan("Andres", 2000.0, Date(), "Went for dinner")
    }

    fun addLoan(name: String, amount: Double, date: Date, concept: String) {
        val newLoan = Loan(name, amount, date, concept)
        _loans.add(newLoan)
    }

    fun deleteLoan(loan : Loan) {
        _loans.remove(loan)
    }
}
package com.ricardomontemayor.paymeback

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.ricardomontemayor.paymeback.databinding.FragmentAddLoanBinding
import com.ricardomontemayor.paymeback.databinding.FragmentDeleteLoanBinding
import com.ricardomontemayor.paymeback.databinding.FragmentLoansListBinding

class DeleteLoanFragment(position : Int, Loansbinding : FragmentLoansListBinding) : DialogFragment() {
    private val viewModel : LoanViewModel by activityViewModels()
    private var _binding = Loansbinding
    private val binding get () = _binding!!
    val position = position

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.fragment_delete_loan, null))
                // Add action buttons
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        //Toast.makeText(activity, "clicked yes", Toast.LENGTH_SHORT).show()
                        viewModel.deleteLoan(viewModel.loans[position])
                        binding.rvLoans.adapter?.notifyItemRemoved(position)
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
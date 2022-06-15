package com.ricardomontemayor.paymeback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ricardomontemayor.paymeback.databinding.FragmentAddLoanBinding
import java.text.SimpleDateFormat
import java.util.*


class AddLoanFragment : Fragment() {

    private val viewModel : LoanViewModel by activityViewModels()
    private var _binding: FragmentAddLoanBinding? = null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddLoanBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAdd.setOnClickListener {
            addLoanButtonPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Actions

    private fun addLoanButtonPressed() {
        // Get fields values
        val name = binding.textFieldName.text.toString()
        val amountStr = binding.textFieldAmount.text.toString()
        val concept = binding.textFieldConcept.text.toString()
        val date = getDate()

        // Check fields are not empty
        if (name.isEmpty() || amountStr.isEmpty()) {
            Toast.makeText(activity, "Please fill the missing fields", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountStr.toDouble()

        viewModel.addLoan(name, amount, date, concept)

        Toast.makeText(activity, "Loan added", Toast.LENGTH_SHORT).show()

        // Clear fields
        binding.textFieldName.setText("")
        binding.textFieldAmount.setText("")
        binding.textFieldConcept.setText("")
    }

    // Utility functions

    private fun getDate(): Date {
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)

        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formattedDate: String = sdf.format(calendar.time)
        val date = sdf.parse(formattedDate)

        return date!!
    }
}
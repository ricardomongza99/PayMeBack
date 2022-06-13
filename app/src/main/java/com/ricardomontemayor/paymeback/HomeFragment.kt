package com.ricardomontemayor.paymeback

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ricardomontemayor.paymeback.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private val viewModel : LoanViewModel by activityViewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add test data
        viewModel.addLoan("Ricardo", 200.0, Date(), "He owes me")
        viewModel.addLoan("Luis", 800.0, Date(), "I payed for his concert ticket")
        viewModel.addLoan("Andres", 2000.0, Date(), "Went for dinner")

        // Set total loan amount and count text
        binding.textViewTotalAmount.text = String.format("$" + viewModel.totalAmount)
        binding.textViewTotalCount.text = viewModel.totalCount.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
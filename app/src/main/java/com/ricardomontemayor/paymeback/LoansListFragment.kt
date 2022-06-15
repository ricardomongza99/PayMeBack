package com.ricardomontemayor.paymeback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ricardomontemayor.paymeback.databinding.FragmentLoansListBinding


class LoansListFragment : Fragment(), Adapter.OnItemClickListener {

    private val viewModel : LoanViewModel by activityViewModels()
    private var _binding: FragmentLoansListBinding? = null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoansListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = Adapter(viewModel.loans, this)
        binding.rvLoans.adapter = adapter
        binding.rvLoans.layoutManager = LinearLayoutManager(activity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        //Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val dialog = DeleteLoanFragment(position, binding)
        dialog.show(childFragmentManager, "deleteLoan")
    }

}
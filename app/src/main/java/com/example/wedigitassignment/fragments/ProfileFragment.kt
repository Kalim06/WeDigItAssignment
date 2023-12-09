package com.example.wedigitassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wedigitassignment.utils.Constants
import com.example.wedigitassignment.adapters.ImageAdapter
import com.example.wedigitassignment.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var imageAdapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set BottomNavigationBar IconTint
        binding.profileBottomNavigation.itemIconTintList = null

        //Set User Data
        val user = Constants.getUserProfileDetails()
        binding.profile = user

        //Set Jam RecyclerView Layout and Adapter
        binding.profileRecyclerView.layoutManager = GridLayoutManager(context, 3)
        imageAdapter = ImageAdapter()
        binding.profileRecyclerView.adapter = imageAdapter

        //Set Recyclerview Data
        val list = Constants.getUserJamsList()
        imageAdapter.setData(list)
    }
}
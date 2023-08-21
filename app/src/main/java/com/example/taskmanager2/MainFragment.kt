package com.example.taskmanager2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.taskmanager2.authentication.MainAuthenticationActivity
import com.example.taskmanager2.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        binding.icLogOut
            .setOnClickListener{
                FirebaseAuth.getInstance().signOut()
                requireActivity().finish()
                startActivity(Intent(requireContext(), MainAuthenticationActivity::class.java))

            }
        binding.chatRoom.setOnClickListener {

            changeFragment(ChatRoomFragment())
        }
        binding.directory.setOnClickListener {

            changeFragment(DirectoryFragment())
        }
        binding.progress.setOnClickListener {

            changeFragment(ProgressFragment())
        }
        binding.jobScheduling.setOnClickListener {

            changeFragment(JobSchedulingFragment())
        }
        binding.quickTask.setOnClickListener {

            changeFragment(QuickTaskFragment())
        }
        binding.timeClock.setOnClickListener {

            changeFragment(TimeClockFragment())
        }


        return binding.root


    }

    private fun changeFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().addToBackStack(
            fragment::
            class.java.name
        ).replace(R.id.frame_layout, fragment).commit()
    }


}
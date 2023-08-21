package com.example.taskmanager2.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.taskmanager2.R
import com.example.taskmanager2.databinding.FragmentAuthenticationBinding

class AuthenticationFragment : Fragment() {
    private lateinit var binding:FragmentAuthenticationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_authentication,container,false)

        binding.buttonCreateAccount.setOnClickListener{
            findNavController().navigate(AuthenticationFragmentDirections.actionAuthenticationFragmentToSignUpFragment())
        }
         binding.buttonLogin.setOnClickListener{
            findNavController().navigate(AuthenticationFragmentDirections.actionAuthenticationFragmentToSignInFragment())
        }

        return  binding.root
    }

}
package com.example.taskmanager2.authentication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.taskmanager2.R
import com.example.taskmanager2.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.fragment.findNavController
import com.example.taskmanager2.MainActivity

class SignInFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in,container,false)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }

        binding.buttonSignIn.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val pass = binding.edtPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        hideKeyboard()
                        requireActivity().finish()
                        startActivity(Intent(requireContext(), MainActivity::class.java))

                    } else {
                        Toast.makeText(this.context, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this.context, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
        return binding.root
    }


    private fun hideKeyboard(){
        val hideKeyBoard =requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyBoard.hideSoftInputFromWindow(requireView().windowToken, 0)

    }


    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){

//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
        }
    }
}
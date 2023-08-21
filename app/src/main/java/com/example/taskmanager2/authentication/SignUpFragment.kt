package com.example.taskmanager2.authentication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.taskmanager2.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.fragment.findNavController
import com.example.taskmanager2.MainActivity

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


    binding = FragmentSignUpBinding.inflate(layoutInflater)

    firebaseAuth = FirebaseAuth.getInstance()


    binding.tvSignIn.setOnClickListener {

        findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
    }


    binding.buttonCreateAccount.setOnClickListener {

        val email = binding.edEmail.text.toString()
        val pass = binding.edtPassword.text.toString()
        val confirmPass = binding.edRetypePassword.text.toString()

        if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
            if (pass == confirmPass) {

                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        hideKeyboard()
                        requireActivity().finish()
                        startActivity(Intent(requireContext(), MainActivity::class.java))
                    } else {
                        Toast.makeText(this.context, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this.context, "Password is not matching", Toast.LENGTH_SHORT).show()
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
}

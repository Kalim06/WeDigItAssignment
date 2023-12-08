package com.example.wedigitassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.wedigitassignment.R
import com.example.wedigitassignment.appendText
import com.example.wedigitassignment.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set SignUp Text
        binding.signUp.appendText("New to WeJammin? ", R.color.textColor)
        binding.signUp.appendText("Sign up here", R.color.textBlueColor)

        //Set Terms and Privacy Text
        binding.termsAndPrivacyText.appendText(
            "By entering, you agree to Wejammin’s ", R.color.textColor
        )
        binding.termsAndPrivacyText.appendText("Privacy Policy ", R.color.textBlueColor)
        binding.termsAndPrivacyText.appendText("and\n ", R.color.textColor)
        binding.termsAndPrivacyText.appendText("Terms of Service", R.color.textBlueColor)

        //Remove error when input is focused
        emailFocusListener()
        passwordFocusListener()


        //Login Btn ClickListener
        binding.loginBtn.setOnClickListener {
            if (isEmailValid() && isPasswordValid()) {
                it.findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
            }
        }
    }

    private fun emailFocusListener() {
        binding.emailInput.setOnFocusChangeListener { _, _ ->
            binding.emailLayout.error = null
        }
    }

    private fun passwordFocusListener() {
        binding.passwordInput.setOnFocusChangeListener { _, _ ->
            binding.passwordLayout.error = null
        }
    }

    private fun isEmailValid(): Boolean {
        if (binding.emailInput.text.isNullOrEmpty()) {
            binding.emailLayout.error = "Required*"
            return false
        }
        return true
    }

    private fun isPasswordValid(): Boolean {
        if (binding.passwordInput.text.isNullOrEmpty()) {
            binding.passwordLayout.error = "Required*"
            return false
        }
        return true
    }

}
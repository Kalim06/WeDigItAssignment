package com.example.wedigitassignment.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.wedigitassignment.R
import com.example.wedigitassignment.databinding.FragmentLoginBinding
import com.example.wedigitassignment.utils.appendText

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
            } else {
                isEmailValid()
                isPasswordValid()
            }
        }
    }

    private fun emailFocusListener() {

        binding.emailInput.doOnTextChanged { _, _, _, _ ->
            isEmailValid()
        }

        binding.emailInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.emailLayout.error = null
            }
        }
    }

    private fun passwordFocusListener() {

        binding.passwordInput.doOnTextChanged { _, _, _, _ ->
            isPasswordValid()
        }

        binding.passwordInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val passwordError =
                    "Minimum 8 Character Password\nMust Contain 1 Upper-case Character\nMust Contain 1 Numeric Character"
                binding.passwordLayout.helperText = passwordError
                binding.passwordLayout.error = null
            } else {
                binding.passwordLayout.helperText = null
            }
        }
    }

    private fun isEmailValid(): Boolean {

        val emailText = binding.emailInput.text.toString()

        val validEmail: Boolean = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()

        return if (!validEmail) {
            binding.emailLayout.error = "Invalid Email Address"
            false
        } else {
            binding.emailLayout.error = null
            true
        }
    }

    private fun isPasswordValid(): Boolean {

        val passwordText = binding.passwordInput.text.toString()

        val passwordLengthError = "Minimum 8 Character Password"
        val passwordUpperCaseError = "Must Contain 1 Upper-case Character"
        val passwordNumericError = "Must Contain 1 Numeric Character"


        when {

            !passwordText.matches(".*[A-Z].*".toRegex()) -> {
                binding.passwordLayout.error = passwordUpperCaseError
                return false
            }

            !passwordText.matches(".*[0-9].*".toRegex()) -> {
                binding.passwordLayout.error = passwordNumericError
                return false
            }

            passwordText.length < 8 -> {
                binding.passwordLayout.error = passwordLengthError
                return false
            }

            else -> {
                binding.passwordLayout.error = null
                binding.passwordLayout.helperText = null
                return true
            }
        }
    }

}
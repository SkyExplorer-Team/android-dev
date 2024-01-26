package com.capstone.skyexplorer.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

object Validator {
    fun TextInputEditText.emailValidator(textInputLayout: TextInputLayout) {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val email = s.toString().trim()
                if (isValidEmail(email)) {
                    textInputLayout.error = null
                } else {
                    textInputLayout.error = "Please enter a valid email address."
                }
            }
        })
    }
    fun TextInputEditText.passwordValidator(textInputLayout: TextInputLayout) {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val password = s.toString().trim()
                if (isValidMinLength(password, 6)) {
                    textInputLayout.error = null
                } else {
                    textInputLayout.error = "Minimal password 6"
                }
            }
        })
    }
    data class ValidationPair(val editText: EditText, val validationFunction: (String) -> Boolean)

    fun enableButtonOnValidation(button: Button, validationPairs: List<ValidationPair>) {
        validationPairs.forEach { (editText, _) ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    button.isEnabled = isValidAllEditTexts(validationPairs)
                }
            })
        }
    }
    fun isValidAllEditTexts(validationPairs: List<ValidationPair>): Boolean {
        return validationPairs.all { (editText, validationFunction) ->
            validationFunction(editText.text.toString())
        }
    }
    fun isValidMinLength(text: String, minLength: Int): Boolean {
        return text.length >= minLength
    }
    fun isValidEmail(email: String): Boolean {
        val emailPattern = android.util.Patterns.EMAIL_ADDRESS
        return emailPattern.matcher(email).matches()
    }
}

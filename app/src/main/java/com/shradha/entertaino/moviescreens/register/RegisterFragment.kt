package com.shradha.entertaino.moviescreens.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController

import com.shradha.entertaino.R
import com.shradha.entertaino.databinding.RegisterFragmentBinding
import com.shradha.entertaino.ui.home.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class RegisterFragment : Fragment() {

  //  private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: RegisterFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.register_fragment, container, false
        )
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        (activity as MainActivity)!!.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        // binding.loginViewModel = loginviewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // Navigates to Login screen when REGISTER button is pressed
        binding.registerButton.setOnClickListener {
            val Username = binding.etUsername.text.toString()
            val Password = binding.etPassword.text.toString()
            if(Username.isEmpty() && Password.isEmpty()) {
                binding.etUsername.error = "Please enter Username it can't be empty"
                binding.etPassword.error = "Please enter a Password it can't be empty"
            } else {
                findNavController().navigate(RegisterFragmentDirections.actionRegisterToLogin())
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}

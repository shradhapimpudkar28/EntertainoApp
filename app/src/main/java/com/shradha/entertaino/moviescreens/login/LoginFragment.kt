package com.shradha.entertaino.moviescreens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shradha.entertaino.R
import com.shradha.entertaino.databinding.LoginFragmentBinding
import com.shradha.entertaino.ui.home.MainActivity
import kotlinx.android.synthetic.main.activity_main.*


class LoginFragment : Fragment() {

    // private lateinit var loginviewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )
       // setHasOptionsMenu(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        (activity as MainActivity)!!.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        binding.lifecycleOwner = viewLifecycleOwner

        // Navigates to Movies screen when Login button is pressed
        binding.loginButton.setOnClickListener { view: View ->
           /* val Username = binding.etUsername.text.toString()
            val Password = binding.etPassword.text.toString()
            if (Username.isEmpty() && Password.isEmpty()) {
                binding.etUsername.error = "Please enter Username it can't be empty"
                binding.etPassword.error = "Please enter a Password it can't be empty"
            } else {
                val action = LoginFragmentDirections.actionLoginToMovielist()
                findNavController().navigate(action)
            }*/
            val action = LoginFragmentDirections.actionLoginToMovielist()
            findNavController().navigate(action)
        }
        // Navigates to Register screen when REGISTER button is pressed
        binding.registerButton.setOnClickListener { view: View ->
            findNavController().navigate(R.id.action_login_to_register)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }
}

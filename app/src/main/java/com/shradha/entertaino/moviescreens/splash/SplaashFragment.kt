package com.shradha.entertaino.moviescreens.splash

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
import com.shradha.entertaino.databinding.SplaashFragmentBinding
import com.shradha.entertaino.ui.home.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class SplaashFragment : Fragment() {


    private lateinit var viewModel: SplaashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<SplaashFragmentBinding>(
            inflater,
            R.layout.splaash_fragment, container, false
        )
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        (activity as MainActivity)!!.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        binding.splashGo.setOnClickListener { view: View ->
            findNavController().navigate(SplaashFragmentDirections.actionSplashToLogin())
        }
        return binding.root
    }

}

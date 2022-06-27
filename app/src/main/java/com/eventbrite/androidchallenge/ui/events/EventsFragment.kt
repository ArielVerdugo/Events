package com.eventbrite.androidchallenge.ui.events

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.eventbrite.androidchallenge.R
import com.eventbrite.androidchallenge.data.events.model.EventsDto
import com.eventbrite.androidchallenge.databinding.EventsFragmentBinding
import com.eventbrite.androidchallenge.ui.events.eventsAdapter.EventsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : Fragment(){

    private var _binding: EventsFragmentBinding? = null
    private val binding get() = _binding
    private val viewModel: EventsViewModel by viewModels()

    companion object {
        fun newInstance() = EventsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EventsFragmentBinding.inflate(layoutInflater,container,false)

        binding?.eventsSwipeRefresh?.post(Runnable { initConfig() })
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        binding?.eventsSwipeRefresh?.setOnRefreshListener {
            binding?.eventsSwipeRefresh?.isRefreshing = false
            viewModel.getEvents(false)
        }
    }

    private fun initObservers(){
        viewModel.events.observe(viewLifecycleOwner, Observer {
            binding?.eventsRecyclerView?.adapter = EventsAdapter(it)
        })

        viewModel.showProgressIndicator.observe(viewLifecycleOwner, Observer {
            if (it!!) {
                binding?.progressBar?.visibility = View.VISIBLE
                val aniFadeIn: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
                binding?.progressBar?.startAnimation(aniFadeIn)
            } else {
                val aniFadeOut: Animation = AnimationUtils.loadAnimation(context, R.anim.fade_out)
                binding?.progressBar?.startAnimation(aniFadeOut)
                binding?.progressBar?.visibility = View.INVISIBLE
            }
        })

        viewModel.isServiceError.observe(viewLifecycleOwner, Observer {
            binding?.eventsRecyclerView?.adapter = EventsAdapter(EventsDto())
            makeAlertDialogError(R.string.title_service_error)

        })

        viewModel.isInternetError.observe(viewLifecycleOwner, Observer {
            binding?.eventsRecyclerView?.adapter = EventsAdapter(EventsDto())
            makeAlertDialogError(R.string.title_network_error)
        })

    }

    private fun initConfig(){
        binding?.eventsRecyclerView?.layoutManager = LinearLayoutManager(context)
        viewModel.getEvents(true)
    }

    private fun makeAlertDialogError(title:Int){
        val dialog = AlertDialog.Builder(context)
            .setTitle(title)
            .setPositiveButton(R.string.buton_retry_error) { view, _ ->
                viewModel.getEvents(true)
                view.dismiss()
            }
            .setNegativeButton(R.string.buton_dismiss_error){ view, _ ->
                view.dismiss()
            }
            .create()

        dialog.show()
    }


}
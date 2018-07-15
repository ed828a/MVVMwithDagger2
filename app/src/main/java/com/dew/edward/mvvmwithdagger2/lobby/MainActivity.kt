package com.dew.edward.mvvmwithdagger2.lobby

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.dew.edward.mvvmwithdagger2.R
import com.dew.edward.mvvmwithdagger2.common.viewmodel.Response
import com.dew.edward.mvvmwithdagger2.common.viewmodel.Status
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: LobbyViewModelFactory

    lateinit var viewModel: LobbyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LobbyViewModel::class.java)
        viewModel.response().observe(this, Observer { response ->
            if (response != null) {
                processResponse(response)
            } else {
                // show response = null error
            }
        })
        
        buttonCommonGreeting.setOnClickListener { viewModel.loadCommmonGreeting() }
        buttonLobbyGreeting.setOnClickListener { viewModel.loadLobbyGreeting() }
    }

    private fun processResponse(respones: Response){
        when (respones.status){
            Status.LOADING -> renderLoadingState()
            Status.SUCCESS -> renderDataState(respones.data)
            Status.ERROR -> renderErrorState(respones.error)
        }
    }

    private fun renderErrorState(error: Throwable?) {
        textViewGreeting.visibility = View.VISIBLE
        loadingIndicator.visibility = View.GONE
        textViewGreeting.text = error?.message
    }

    private fun renderDataState(greeting: String?) {
        textViewGreeting.visibility = View.VISIBLE
        loadingIndicator.visibility = View.GONE
        textViewGreeting.text = greeting
    }

    private fun renderLoadingState() {
        textViewGreeting.visibility = View.GONE
        loadingIndicator.visibility = View.VISIBLE
    }

    

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

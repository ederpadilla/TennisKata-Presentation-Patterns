package io.github.gianpamx.tenniskatapresentationpatterns.mvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import io.github.gianpamx.tenniskatapresentationpatterns.R
import kotlinx.android.synthetic.main.fragment_score.*

/**
 * This is the View (observer)
 */
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_score)

        mainViewModel = ViewModelProviders.of(this, mainViewModelfactory).get(MainViewModel::class.java)

        mainViewModel.scoreLiveData.observe(this, scoreLiveDataobserver)
    }

    private val mainViewModelfactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(Model()) as T
        }
    }

    private val scoreLiveDataobserver = Observer<Pair<String, String>> {
        player1TextView.text = it.first
        player2TextView.text = it.second
    }

    fun player1ButtonOnClickListener(view: View) {
        mainViewModel.player1()
    }

    fun player2ButtonOnClickListener(view: View) {
        mainViewModel.player2()
    }
}

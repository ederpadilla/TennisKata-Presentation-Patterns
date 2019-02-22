package io.github.gianpamx.tenniskatapresentationpatterns.mvc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.gianpamx.tenniskatapresentationpatterns.R
import kotlinx.android.synthetic.main.fragment_score.*

/**
 * This is the view
 */

class ScoreFragment : Fragment() {
    interface Container {
        fun onScoreFragmentReady(scoreFragment: ScoreFragment)
    }

    lateinit var model: Model

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? Container)?.onScoreFragmentReady(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(context, R.layout.fragment_score, container)
    }

    fun updateView() {
        player1TextView.text = model.player1score.name
        player2TextView.text = model.player2score.name
    }
}

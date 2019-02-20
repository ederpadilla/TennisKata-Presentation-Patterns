package io.github.gianpamx.tenniskatapresentationpatterns

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This is the controller
 */
class MainActivity : AppCompatActivity(), ScoreFragment.Container {
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = if (savedInstanceState == null) {
            Model(scoreFragment as? ScoreFragment)
        } else {
            Model(
                    scoreFragment as? ScoreFragment,
                    savedInstanceState.get("player1") as Model.Score,
                    savedInstanceState.get("player2") as Model.Score
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable("player1", model.player1score)
        outState?.putSerializable("player2", model.player2score)
    }

    override fun onScoreFragmentReady(scoreFragment: ScoreFragment) {
        scoreFragment.model = model
        scoreFragment.updateView()
    }

    fun player1ButtonOnClickListener(view: View) {
        model.player1()
    }

    fun player2ButtonOnClickListener(view: View) {
        model.player2()
    }
}

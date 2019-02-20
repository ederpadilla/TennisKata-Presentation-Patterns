package io.github.gianpamx.tenniskatapresentationpatterns.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.github.gianpamx.tenniskatapresentationpatterns.R
import kotlinx.android.synthetic.main.fragment_score.*

/**
 * This is the ActualView
 */
class MainActivity : AppCompatActivity(), Presenter.View {
    lateinit var model: Model
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_score)

        model = if (savedInstanceState == null) {
            Model()
        } else {
            Model(
                    savedInstanceState.get("player1") as Model.Score,
                    savedInstanceState.get("player2") as Model.Score
            )
        }
        presenter = Presenter(this, model)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putSerializable("player1", model.player1score)
        outState?.putSerializable("player2", model.player2score)
    }

    fun player1ButtonOnClickListener(view: View) {
        presenter.player1()
    }

    fun player2ButtonOnClickListener(view: View) {
        presenter.player2()
    }

    override fun onScoreChange(player1Score: String, player2Score: String) {
        player1TextView.text = player1Score
        player2TextView.text = player2Score
    }
}

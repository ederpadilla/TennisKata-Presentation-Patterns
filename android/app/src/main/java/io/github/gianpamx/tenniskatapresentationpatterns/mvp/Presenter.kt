package io.github.gianpamx.tenniskatapresentationpatterns.mvp

class Presenter(val view: View, val model: Model) {
    interface View {
        fun onScoreChange(player1Score: String, player2Score: String)
    }

    init {
        // Mapping (Map)
        val player1Score: String = model.player1score.name
        val player2Score: String = model.player2score.name

        view.onScoreChange(player1Score, player2Score)
    }

    fun player1() {
        val scorePair = model.player1()

        // Mapping (Map)
        val player1Score: String = scorePair.first.name
        val player2Score: String = scorePair.second.name

        view.onScoreChange(player1Score, player2Score)
    }

    fun player2() {
        val scorePair = model.player2()

        // Mapping (Map)
        val player1Score: String = scorePair.first.name
        val player2Score: String = scorePair.second.name

        view.onScoreChange(player1Score, player2Score)
    }
}

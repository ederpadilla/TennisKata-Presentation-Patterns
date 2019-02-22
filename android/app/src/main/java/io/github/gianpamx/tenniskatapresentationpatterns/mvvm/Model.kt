package io.github.gianpamx.tenniskatapresentationpatterns.mvvm

class Model(
        var player1score: Score = Score.Love,
        var player2score: Score = Score.Love
) {
    enum class Score {
        Love,
        Fifteen,
        Thirty,
        Forty,

        Deuce,
        Advantage,

        Winner
    }

    fun player1(): Pair<Score, Score> {
        if (player1score == Score.Winner || player2score == Score.Winner) {
            return Pair(player1score, player2score)
        }

        when (player1score) {
            Score.Love -> player1score = Score.Fifteen
            Score.Fifteen -> player1score = Score.Thirty
            Score.Thirty -> {
                if (player2score == Score.Forty) {
                    player1score = Score.Deuce
                    player2score = Score.Deuce
                } else {
                    player1score = Score.Forty
                }
            }
            Score.Forty -> {
                if (player2score == Score.Advantage) {
                    player1score = Score.Deuce
                    player2score = Score.Deuce
                } else {
                    player1score = Score.Winner
                }
            }
            Score.Deuce -> {
                player1score = Score.Advantage
                player1score = Score.Forty
            }
            Score.Advantage -> {
                player1score = Score.Winner
            }
            Score.Winner -> {
            }
        }
        return Pair(player1score, player2score)
    }

    fun player2(): Pair<Score, Score> {
        if (player1score == Score.Winner || player2score == Score.Winner) {
            return Pair(player1score, player2score)
        }

        when (player2score) {
            Score.Love -> player2score = Score.Fifteen
            Score.Fifteen -> player2score = Score.Thirty
            Score.Thirty -> {
                if (player1score == Score.Forty) {
                    player1score = Score.Deuce
                    player2score = Score.Deuce
                } else {
                    player2score = Score.Forty
                }
            }
            Score.Forty -> {
                if (player1score == Score.Advantage) {
                    player1score = Score.Deuce
                    player2score = Score.Deuce
                } else {
                    player2score = Score.Winner
                }
            }
            Score.Deuce -> {
                player1score = Score.Forty
                player2score = Score.Advantage
            }
            Score.Advantage -> {
                player2score = Score.Winner
            }
            Score.Winner -> {
            }
        }
        return Pair(player1score, player2score)
    }
}

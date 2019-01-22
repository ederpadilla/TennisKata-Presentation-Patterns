enum Score: String {
    case love
    case fifteen
    case thirty
    case forty
    
    case deuce
    case advantage
    
    case winner
}

typealias ScoreResult = (Score, Score)

class Model {
    public private(set) var player1score = Score.love
    public private(set) var player2score = Score.love
    
    init(player1score: Score = .love, player2score: Score = .love) {
        self.player1score = player1score
        self.player2score = player2score
    }
    
    func player1() -> ScoreResult {
        if player1score == .winner || player2score == .winner {
            return (player1score, player2score)
        }
        
        switch player1score {
        case .love:
            player1score = .fifteen
        case .fifteen:
            player1score = .thirty
        case .thirty:
            if player2score == .forty {
                player1score = .deuce
                player2score = .deuce
            } else {
                player1score = .forty
            }
        case .forty:
            if player2score == .advantage {
                player1score = .deuce
                player2score = .deuce
            } else {
                player1score = .winner
            }
        case .deuce:
            player1score = .advantage
            player2score = .forty
        case .advantage:
            player1score = .winner
        case .winner:
            break
        }
        
        return (player1score, player2score)
    }
    
    func player2() -> ScoreResult {
        if player1score == .winner || player2score == .winner {
            return (player1score, player2score)
        }
        
        switch player2score {
        case .love:
            player2score = .fifteen
        case .fifteen:
            player2score = .thirty
        case .thirty:
            if player1score == .forty {
                player1score = .deuce
                player2score = .deuce
            } else {
                player2score = .forty
            }
        case .forty:
            if player1score == .advantage {
                player1score = .deuce
                player2score = .deuce
            } else {
                player2score = .winner
            }
        case .deuce:
            player1score = .forty
            player2score = .advantage
        case .advantage:
            player2score = .winner
        case .winner:
            break
        }
        
        if player1score == .winner || player2score == .winner {
            return (player1score, player2score)
        }
        
        return (player1score, player2score)
    }
}

struct ViewState {
    var player1score = "love"
    var player2score = "love"
}

class ViewModel {
    private(set) var viewState = ViewState() {
        didSet {
            self.observer?(viewState)
        }
    }
    var observer: ((ViewState) -> ())? {
        didSet {
            observer?(viewState)
        }
    }

    private let model: Model

    init(model: Model) {
        self.model = model
    }

    func player1() {
        let score = model.player1()
        let player1score = score.0.rawValue
        let player2score = score.1.rawValue

        viewState = ViewState(player1score: player1score, player2score: player2score)
    }

    func player2() {
        let score = model.player2()
        let player1score = score.0.rawValue
        let player2score = score.1.rawValue

        viewState = ViewState(player1score: player1score, player2score: player2score)
    }
}

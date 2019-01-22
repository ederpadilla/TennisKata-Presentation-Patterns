class Presenter {
    private let model: Model
    var view: View? {
        didSet {
            view?.scoreDidChange(model.player1score.rawValue, model.player2score.rawValue)
        }
    }

    init(model: Model) {
        self.model = model
    }

    func player1() {
        let score = model.player1()
        let player1score = score.0
        let player2score = score.1

        view?.scoreDidChange(player1score.rawValue, player2score.rawValue)
    }

    func player2() {
        let score = model.player2()
        let player1score = score.0
        let player2score = score.1

        view?.scoreDidChange(player1score.rawValue, player2score.rawValue)
    }
}

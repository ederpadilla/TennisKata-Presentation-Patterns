import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var player1Label: UILabel!
    @IBOutlet weak var player2Label: UILabel!

    let viewModel = ViewModel(model: Model())

    override func viewDidLoad() {
        super.viewDidLoad()

        viewModel.observer = { [weak self] viewState in
            self?.player1Label.text = viewState.player1score
            self?.player2Label.text = viewState.player2score
        }
    }

    @IBAction func player1(_ sender: Any) {
        viewModel.player1()
    }

    @IBAction func player2(_ sender: Any) {
        viewModel.player2()
    }
}

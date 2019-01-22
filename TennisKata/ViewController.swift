import UIKit

class ViewController: UIViewController, View {
    @IBOutlet weak var player1Label: UILabel!
    @IBOutlet weak var player2Label: UILabel!

    let presenter = Presenter(model: Model())

    override func viewDidLoad() {
        super.viewDidLoad()

        presenter.view = self
    }

    @IBAction func player1(_ sender: Any) {
        presenter.player1()
    }

    @IBAction func player2(_ sender: Any) {
        presenter.player2()
    }

    func scoreDidChange(_ player1score: String, _ player2score: String) {
        player1Label.text = player1score
        player2Label.text = player2score
    }
}

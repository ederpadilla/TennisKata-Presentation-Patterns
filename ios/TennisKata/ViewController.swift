import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var player1Label: UILabel!
    @IBOutlet weak var player2Label: UILabel!


    override func viewDidLoad() {
        super.viewDidLoad()
    }

    @IBAction func player1(_ sender: Any) {
        print("Player 1")
    }

    @IBAction func player2(_ sender: Any) {
        print("Player 2")
    }
}

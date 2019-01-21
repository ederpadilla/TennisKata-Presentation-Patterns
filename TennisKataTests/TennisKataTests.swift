import XCTest
@testable import TennisKata

class TennisKataTests: XCTestCase {

    func testZeros() {
        let model: Model = Model(controller: { })

        XCTAssertEqual(model.player1score, .love)
        XCTAssertEqual(model.player2score, .love)
    }

    func testFifteen() {
        let model: Model = Model(controller: { })

        model.player1()

        XCTAssertEqual(model.player1score, .fifteen)
    }

    func testThirty() {
        let model: Model = Model(player1score: .fifteen, controller: { })

        model.player1()

        XCTAssertEqual(model.player1score, .thirty)
    }

    func testForthy() {
        let model: Model = Model(player1score: .thirty, controller: { })

        model.player1()

        XCTAssertEqual(model.player1score, .forty)
    }

    func testSimpleWinner() {
        let model: Model = Model(player1score: .forty, player2score: .thirty, controller: { })

        model.player1()

        XCTAssertEqual(model.player1score, .winner)
    }

    func testDeuce() {
        let model: Model = Model(player1score: .forty, player2score: .thirty, controller: { })

        model.player2()

        XCTAssertEqual(model.player1score, .deuce)
        XCTAssertEqual(model.player2score, .deuce)
    }


    func testAdvantage() {
        let model: Model = Model(player1score: .deuce, player2score: .deuce, controller: { })

        model.player2()

        XCTAssertEqual(model.player1score, .forty)
        XCTAssertEqual(model.player2score, .advantage)
    }

    func testGoBackToDeuce() {
        let model: Model = Model(player1score: .advantage, player2score: .forty, controller: { })

        model.player2()

        XCTAssertEqual(model.player1score, .deuce)
        XCTAssertEqual(model.player2score, .deuce)
    }

    func testWinnerFromAdvantage() {
        let model: Model = Model(player1score: .advantage, player2score: .forty, controller: { })

        model.player1()

        XCTAssertEqual(model.player1score, .winner)
    }


    func testLockScore() {
        let model: Model = Model(player1score: .winner, player2score: .forty, controller: { })

        model.player1()
        model.player2()

        XCTAssertEqual(model.player1score, .winner)
        XCTAssertEqual(model.player2score, .forty)
    }
}

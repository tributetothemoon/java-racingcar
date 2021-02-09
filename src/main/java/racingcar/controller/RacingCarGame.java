package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.view.OutputView;

/**
 * RacingCarGame.java
 * 경주가 진행되는 도중의 로직을 관장하는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class RacingCarGame {
    private final OutputView outputView = OutputView.getInstance();
    private final Cars cars;
    private final Round round;

    private RacingCarGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingCarGame createNewGame(Cars cars, Round round) {
        return new RacingCarGame(cars, round);
    }

    public void play() {
        outputView.printResultMessage();

        while (!round.isEnd()) {
            cars.moveCars();
            outputView.printCarsPosition(cars.toDto());
            round.nextRound();
        }

        Winners winners = Winners.of(cars);
        outputView.printWinners(winners.toListOfNames());
    }
}

package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Winners.java
 * 우승자를 구하는 기능을 담당하는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class Winners {
    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners of(Cars cars) {
        int topPosition = cars.getTopPosition();
        List<Car> winners = cars.toList().stream()
                .filter(car -> car.getPosition() == topPosition)
                .collect(Collectors.toList());
        return new Winners(winners);
    }

    public List<String> toListOfNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
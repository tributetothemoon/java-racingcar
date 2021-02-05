package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Cars.java
 * 자동차 객체들을 담는 일급 컬렉션
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class Cars {
    private static final int MIN_SIZE = 2;
    private static final String ERROR_MIN_SIZE = "최소 " + MIN_SIZE + "대 이상의 이름을 입력하세요.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of (List<String> carNames) {
        isValidNumberOfCarsOrThrowException(carNames);

        List<Car> cars = new ArrayList<>();
        carNames.stream()
                .map(Car::from)
                .filter(car -> isNotAlreadyExistOrThrowException(cars, car))
                .forEach(cars::add);
        return new Cars(cars);
    }

    private static void isValidNumberOfCarsOrThrowException(List<String> carNames) {
        if (carNames.size() < MIN_SIZE) {
            throw new IllegalArgumentException(ERROR_MIN_SIZE);
        }
    }

    private static boolean isNotAlreadyExistOrThrowException(List<Car> destination, Car car) {
        if (destination.contains(car)) {
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
        return true;
    }
}

package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.Randoms;

public class Cars {

    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final int RANDOM_NUMBER_LIMIT = 4;

    private final List<Car> cars;

    public static Cars of(List<String> names) {
        return new Cars(names);
    }

    private Cars(List<String> names) {
        validate(names);
        cars = convertToCars(names);
    }

    public List<String> receiveCurrentRank() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public void applyMovingForward() {
        for (int index = 0; index < cars.size(); index++) {
            conditionalMove(index);
        }
    }

    public String selectWinnerNames() {
        int maxMove = receiveMaxMove();
        List<String> winnerNames = selectWinnerNames(maxMove);
        return joinWinnerNames(winnerNames);
    }

    private String joinWinnerNames(List<String> winnerNames) {
        return String.join(WINNER_NAME_SEPARATOR, winnerNames);
    }

    private List<String> selectWinnerNames(int maxMove) {
        return cars.stream()
                .filter(car -> car.compare(maxMove))
                .map(Car::getName)
                .toList();
    }

    private int receiveMaxMove() {
        return cars.stream()
                .map(Car::getMove)
                .max(Integer::compare)
                .orElseThrow();
    }

    private void conditionalMove(int index) {
        if (isRandomNumberNotInRange()) {
            return;
        }

        Car targetCar = getCarByIndex(index).increaseMove();
        moveForward(index, targetCar);
    }

    private void moveForward(int index, Car targetCar) {
        cars.set(index, targetCar);
    }

    private boolean isRandomNumberNotInRange() {
        return Randoms.pickNumberInRange() < RANDOM_NUMBER_LIMIT;
    }

    private Car getCarByIndex(int index) {
        return cars.get(index);
    }

    private List<Car> convertToCars(List<String> names) {
        return names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        checkInput(names);
        checkDuplicate(names);
    }

    private void checkInput(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private void checkDuplicate(List<String> names) {
        if (hasDuplicate(names)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean hasDuplicate(List<String> names) {
        return names.size() != countDuplicateNames(names);
    }

    private long countDuplicateNames(List<String> names) {
        return names.stream()
                .distinct()
                .count();
    }
}

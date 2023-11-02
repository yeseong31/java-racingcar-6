package racingcar.service;

import static racingcar.constants.Message.WINNER_NAME_SEPARATOR;

import java.util.List;
import racingcar.domain.Cars;

public class CarGameService {

    public static void applyMovingForward(final Cars cars) {
        cars.applyMovingForward();
    }

    public static String receiveWinnerNames(final Cars cars) {
        List<String> winnerNames = cars.receiveWinnerNames();
        return joinWinnerNames(winnerNames);
    }

    private static String joinWinnerNames(final List<String> winnerNames) {
        return String.join(WINNER_NAME_SEPARATOR.getMessage(), winnerNames);
    }
}

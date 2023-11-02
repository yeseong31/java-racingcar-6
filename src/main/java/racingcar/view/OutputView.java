package racingcar.view;

import static java.lang.String.format;
import static racingcar.constants.Message.ASK_ATTEMPT;
import static racingcar.constants.Message.BLANK_STRING;
import static racingcar.constants.Message.FINAL_WINNER;
import static racingcar.constants.Message.GAME_RESULT;
import static racingcar.constants.Message.PRINT_FINAL_WINNER_FORMAT;
import static racingcar.constants.Message.PRINT_GAME_RESULT_FORMAT;
import static racingcar.constants.Message.START_GAME;

import racingcar.domain.Cars;

public class OutputView {

    public static void printStartGame() {
        println(START_GAME.getMessage());
    }

    public static void printAskAttempt() {
        println(ASK_ATTEMPT.getMessage());
    }

    public static void printGameResult() {
        println(format(PRINT_GAME_RESULT_FORMAT.getMessage(), GAME_RESULT.getMessage()));
    }

    public static void printFinalWinner(final String winner) {
        print(format(PRINT_FINAL_WINNER_FORMAT.getMessage(), FINAL_WINNER.getMessage(), winner));
    }

    public static void printRank(final Cars cars) {
        for (String carInfo : cars.receiveCurrentRank()) {
            println(carInfo);
        }
        println();
    }

    private static void print(final String message) {
        System.out.print(message);
    }

    private static void println(final String message) {
        System.out.println(message);
    }

    private static void println() {
        println(BLANK_STRING.getMessage());
    }
}

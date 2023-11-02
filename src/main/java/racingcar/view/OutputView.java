package racingcar.view;

import static java.lang.String.format;
import static racingcar.constants.MessageConstant.ASK_ATTEMPT;
import static racingcar.constants.MessageConstant.BLANK_STRING;
import static racingcar.constants.MessageConstant.FINAL_WINNER;
import static racingcar.constants.MessageConstant.GAME_RESULT;
import static racingcar.constants.MessageConstant.PRINT_FINAL_WINNER_FORMAT;
import static racingcar.constants.MessageConstant.PRINT_GAME_RESULT_FORMAT;
import static racingcar.constants.MessageConstant.START_GAME;

import racingcar.domain.Cars;

public class OutputView {

    public static void printStartGame() {
        println(START_GAME);
    }

    public static void printAskAttempt() {
        println(ASK_ATTEMPT);
    }

    public static void printGameResult() {
        println(format(PRINT_GAME_RESULT_FORMAT, GAME_RESULT));
    }

    public static void printFinalWinner(final String winner) {
        print(format(PRINT_FINAL_WINNER_FORMAT, FINAL_WINNER, winner));
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
        println(BLANK_STRING);
    }
}

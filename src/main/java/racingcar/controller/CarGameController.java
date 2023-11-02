package racingcar.controller;

import static racingcar.service.CarGameService.applyMovingForward;
import static racingcar.service.CarGameService.receiveWinnerNames;
import static racingcar.utils.Console.close;
import static racingcar.utils.Converter.convertToCars;
import static racingcar.view.InputView.readAttempt;
import static racingcar.view.InputView.readCarNames;
import static racingcar.view.OutputView.printAskAttempt;
import static racingcar.view.OutputView.printFinalWinner;
import static racingcar.view.OutputView.printGameResult;
import static racingcar.view.OutputView.printRank;
import static racingcar.view.OutputView.printStartGame;

import racingcar.domain.Cars;

public class CarGameController {

    public static void start() {
        Cars cars = receiveCars();
        int attempt = receiveAttempt();

        executeGame(cars, attempt);
        showWinner(cars);
        terminateGame();
    }

    private static void terminateGame() {
        close();
    }

    private static void showWinner(final Cars cars) {
        String result = receiveWinnerNames(cars);
        printFinalWinner(result);
    }

    private static void executeGame(final Cars cars, final int attempt) {
        printGameResult();

        for (int iteration = 0; iteration < attempt; iteration++) {
            applyMovingForward(cars);
            printRank(cars);
        }
    }

    private static int receiveAttempt() {
        printAskAttempt();
        return readAttempt();
    }

    private static Cars receiveCars() {
        printStartGame();
        String input = readCarNames();
        return convertToCars(input);
    }
}

package racingcar.view;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static racingcar.constants.Message.INVALID_INPUT_MESSAGE;
import static racingcar.utils.Console.readLine;

public class InputView {

    public static String readCarNames() {
        return readLine();
    }

    public static int readAttempt() {
        try {
            String attempt = readLine();
            validate(attempt);
            return parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void validate(final String attempt) {
        validateInput(attempt);
    }

    private static void validateInput(final String attempt) {
        for (int index = 0; index < attempt.length(); index++) {
            char target = attempt.charAt(index);
            checkInteger(target);
        }
    }

    private static void checkInteger(final char target) {
        if (!isDigit(target)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE.getMessage());
        }
    }
}

package racingcar.domain;

import static java.lang.String.format;
import static racingcar.constants.Message.INVALID_CAR_NAME_MESSAGE;
import static racingcar.constants.Message.MOVE_TRAIL_INDICATOR;
import static racingcar.constants.NumberConstant.INITIAL_MOVE_COUNT;
import static racingcar.constants.NumberConstant.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.constants.NumberConstant.MINIMUM_CAR_NAME_LENGTH;
import static racingcar.constants.NumberConstant.MOVEMENT_COUNT;

import racingcar.constants.Message;

public class Car {

    private final String name;
    private final int move;

    public static Car of(final String name) {
        return new Car(name, INITIAL_MOVE_COUNT);
    }

    private Car(final String name, final int move) {
        validate(name);
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }

    public Car increaseMove() {
        return new Car(name, move + MOVEMENT_COUNT);
    }

    public String receiveMoveTrail() {
        return MOVE_TRAIL_INDICATOR.getMessage().repeat(move);
    }

    public boolean compare(final int forwardCount) {
        return this.move == forwardCount;
    }

    private void validate(final String name) {
        checkInput(name);
        checkLength(name);
    }

    private void checkLength(final String name) {
        if (isNameLengthOutOfRange(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE.getMessage());
        }
    }

    private boolean isNameLengthOutOfRange(final String name) {
        int length = name.length();
        return length < MINIMUM_CAR_NAME_LENGTH || length > MAXIMUM_CAR_NAME_LENGTH;
    }

    private void checkInput(final String name) {
        if (hasBlank(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE.getMessage());
        }
    }

    private boolean hasBlank(final String name) {
        return name.chars().anyMatch(Character::isWhitespace);
    }

    @Override
    public String toString() {
        return format(Message.PRINT_CAR_INFO_FORMAT.getMessage(), name, receiveMoveTrail());
    }
}

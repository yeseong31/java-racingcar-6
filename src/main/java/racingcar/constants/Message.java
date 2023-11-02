package racingcar.constants;

public enum Message {
    INVALID_CAR_NAME_MESSAGE("자동차 이름 형식에 맞지 않는 입력입니다."),
    MOVE_TRAIL_INDICATOR("-"),
    PRINT_CAR_INFO_FORMAT("%s : %s"),
    INVALID_INPUT_MESSAGE("잘못된 입력입니다."),
    WINNER_NAME_SEPARATOR(", "),
    INPUT_SEPARATOR(","),
    ASK_ATTEMPT("시도할 회수는 몇회인가요?"),
    BLANK_STRING(""),
    FINAL_WINNER("최종 우승자"),
    GAME_RESULT("실행 결과"),
    PRINT_FINAL_WINNER_FORMAT("%s : %s"),
    PRINT_GAME_RESULT_FORMAT("\n%s"),
    START_GAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ERROR_MAXIMUM_VALUE_CALCULATION("최댓값 계산 중 오류가 발생했씁니다.");

    final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

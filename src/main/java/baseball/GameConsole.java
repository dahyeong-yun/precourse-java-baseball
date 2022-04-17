package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameConsole {

    public static final String END_SIGN = "2";

    public static final String MESSAGE_REQUEST_INPUT = "숫자를 입력해 주세요 : ";
    public static final String MESSAGE_CHOICE_GAME_MENU = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요\n";
    public static final String MESSAGE_GAME_END = "3개 숫자를 모두 맞추셨습니다! 게임 종료\n";
    public static final String EXCEPTION_LENGTH = "숫자는 3글자 이하여야 합니다.";
    private static final String EXCEPTION_FORMAT = "숫자를 입력해야 합니다.";

    private static Game game;

    public static void start() {
        String input;
        do {
            game = Game.startNewGame();
            execute();
            printInstruction(MESSAGE_CHOICE_GAME_MENU);
            input = readInput();
        } while(!isEndSign(input));
    }

    private static String readInput() {
        return Console.readLine();
    }

    private static String requestInput() {
        printInstruction(MESSAGE_REQUEST_INPUT);
        String sign = readInput();
        validate(sign);
        return sign;
    }

    private static void execute() {
        PlayResult playResult = PlayResult.init();
        while(playResult.isNotGameEnd()) {
            String sign = requestInput();
            List<Ball> inputBalls = interpret(sign);
            playResult = game.play(inputBalls);
            playResult.report();
        }
        printInstruction(MESSAGE_GAME_END);
    }

    private static List<Ball> interpret(String sign) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < sign.length(); i++) {
            int intSign = Integer.parseInt(String.valueOf(sign.charAt(i)));
            Ball ball = Ball.createBall(i, intSign);
            result.add(ball);
        }
        return result;
    }

    private static void validate(String sign) {
        if (sign.length() > 3 || sign.length() < 1) {
            throw new IllegalArgumentException(EXCEPTION_LENGTH);
        }
        
        try {
            Double.parseDouble(sign);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_FORMAT);
        }
    }

    private static void printInstruction(String message) {
        System.out.print(message);
    }

    private static boolean isEndSign(String temp) {
        return END_SIGN.equals(temp);
    }
}

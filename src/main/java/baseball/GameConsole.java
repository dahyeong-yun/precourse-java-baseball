package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameConsole {

    public static final String FIRST_INPUT = "1";
    public static final String END_SIGN = "2";
    private static Game game;


    public static void start() {
        String input = FIRST_INPUT;
        while(!isEndSign(input)) {
            game = new Game();
            execute();
            printGameMenu();
            input = readInput();
        }
    }

    private static String readInput() {
        return Console.readLine();
    }

    private static void printGameMenu() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    private static void execute() {
        PlayResult playResult = PlayResult.init();
        while(playResult.isNotGameEnd()) {
            printInstruction();
            String sign = readInput();

            validate(sign);

            List<Ball> inputBalls = interpret(sign);
            playResult = game.play(inputBalls); // 하나의 인풋에 하나의 플레이만 존재. TODO 게임을 콘솔 내에서 새로 생성 해야함 -> 생성 시점에 랜덤 넘버를 가져가기 위해서
            playResult.report();
        }
        printGameEnd();
    }

    private static void printGameEnd() {
        System.out.println("3개 숫자를 모두 맞추셨습니다! 게임 종료");
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
            throw new IllegalArgumentException("숫자는 3글자 이하여야 합니다.");
        }
    }

    private static void printInstruction() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private static boolean isEndSign(String temp) {
        return END_SIGN.equals(temp);
    }
}

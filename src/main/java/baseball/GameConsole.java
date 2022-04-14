package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

// 명령어를 게임 플레이에 알맞게 변경 하여 넘겨주고, 명령어 유효성을 검증하고, 지시어를 출력하는 역할
public class GameConsole {

    public static void start() {
        String input = "";
        inGame(input); // TODO 메뉴 종료를 입력하지 않는 이상 반복되어야 함
    }

    private static void inGame(String input) {
        while(!isEndSign(input)) { // TODO 이 부분이 3 스트라이크여야 함
            printInstruction();
            execute(input);
            input = readInput();
        }
    }

    private static String readInput() {
        return Console.readLine();
    }

    private static void execute(String sign) {
        if (validate(sign)) {
            List<Ball> inputBalls = interpret(sign);
            Game.play(inputBalls); // 하나의 인풋에 하나의 플레이만 존재.
        }
    }

    private static List<Ball> interpret(String sign) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < sign.length(); i++) {
            Integer intSign = Integer.parseInt(String.valueOf(sign.charAt(i)));
            Ball ball = Ball.createBall(intSign);
            result.add(ball);
        }
        return result;
    }

    private static boolean validate(String sign) {
        if (sign.length() > 3) {
            throw new IllegalArgumentException("숫자는 3글자 이하여야 합니다.");
        }
        return true;
    }

    private static void printInstruction() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private static boolean isEndSign(String temp) {
        return "2".equals(temp); // 이렇게 종료할 수 있는 것은 게임이 끝나야 한다.
    }
}

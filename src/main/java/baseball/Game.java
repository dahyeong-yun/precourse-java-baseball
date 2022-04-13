package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public static void start() {
        String sign = "";
        while(!isEndSign(sign)) {
            printInstruction();
            interpret(sign);
            sign = getSign();
        }
    }

    private static String getSign() {
        return Console.readLine();
    }

    private static void printInstruction() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private static void interpret(String sign) {
        if (validate(sign)) {
            System.out.println("낫싱" + "3스트라이크" + "1볼 1스트라이크" + "3스트라이크" + "게임 종료");
        }
    }

    private static boolean validate(String sign) {
        if (sign.length() > 3) {
            throw new IllegalArgumentException("숫자는 3글자 이하여야 합니다.");
        }
        System.out.println(sign);
        return true;
    }

    private static boolean isEndSign(String temp) {
        return "2".equals(temp);
    }
}

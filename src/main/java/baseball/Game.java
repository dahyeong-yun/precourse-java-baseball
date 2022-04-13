package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    static SignInterpreter signInterPreter = new SignInterpreter();

    public static void start() {
        String input = "";
        while(!isEndSign(input)) {
            printInstruction();
            signInterPreter.interpret(input);
            input = getInput();
        }
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static void printInstruction() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    private static boolean isEndSign(String temp) {
        return "2".equals(temp);
    }
}

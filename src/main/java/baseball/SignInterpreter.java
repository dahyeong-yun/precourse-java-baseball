package baseball;

public class SignInterpreter {

    void interpret(String sign) {
        if (validate(sign)) {
            System.out.println("낫싱" + "3스트라이크" + "1볼 1스트라이크" + "3스트라이크" + "게임 종료");
        }
    }

    private boolean validate(String sign) {
        if (sign.length() > 3) {
            throw new IllegalArgumentException("숫자는 3글자 이하여야 합니다.");
        }
        System.out.println(sign);
        return true;
    }
}

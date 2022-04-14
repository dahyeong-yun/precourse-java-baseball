package baseball;

public class Ball {
    private final int value;

    private Ball(Integer value) {
        this.value = value;
    }

    public static Ball createBall(Integer input) {
        if(!validate(input)) {
            throw new IllegalArgumentException();
        }
        return new Ball(input);
    }

    private static boolean validate(int value) {
        return 1 <= value && value <= 9;
    }

    public int getValue() {
        return this.value;
    }
}

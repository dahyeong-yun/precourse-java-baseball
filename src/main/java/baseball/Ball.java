package baseball;

public class Ball {
    private int value;

    public Ball(String input) {
        int value = Integer.parseInt(input);
        if(validate(value)) {
            this.value = value;
        }
    }

    private boolean validate(int value) {
        if(1 > value || value > 9) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int getValue() {
        return this.value;
    }
}

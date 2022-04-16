package baseball;

import java.util.List;

public class Ball {
    private final int order;
    private final int value;


    private Ball(int order, int value) {
        this.order = order;
        this.value = value;
    }

    public static Ball createBall(int order, int input) {
        if(!validate(input)) {
            throw new IllegalArgumentException();
        }
        return new Ball(order, input);
    }

    private static boolean validate(int value) {
        return 1 <= value && value <= 9;
    }

    public int getValue() {
        return this.value;
    }

    private PlayJudge pitch(Ball answer) {
        if(this.order == answer.order && this.value == answer.value) {
            return PlayJudge.STRIKE;
        }
        if(this.order != answer.order && this.value == answer.value) {
            return PlayJudge.BALL;
        }
        return null;
    }

    public PlayJudge play(List<Ball> answers) {
        PlayJudge result = null;

        int idx = 0;
        while(result == null && idx < 3) {
            result = pitch(answers.get(idx));
            idx++;
        }

        if(result == null) {
            result = PlayJudge.NOTHING;
        }

        return result;
    }
}

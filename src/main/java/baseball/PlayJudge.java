package baseball;

public enum PlayJudge {
    STRIKE, BALL, NOTHING;

    public boolean isBall() {
        return this==PlayJudge.BALL;
    }

    public boolean isStrike() {
        return this==PlayJudge.STRIKE;
    }

    public boolean isNothing() {
        return this==PlayJudge.NOTHING;
    }
}

package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    private PlayResult() {}

    public static PlayResult init() {
        return new PlayResult();
    }

    public boolean isNotGameEnd() {
        return this.strike != 3;
    }

    public void note(PlayJudge judgement) {
        if(judgement==PlayJudge.BALL) {
            this.ball++;
        }
        if(judgement==PlayJudge.STRIKE) {
            this.strike++;
        }
    }

    public void report() {
        if(this.ball == 0 && this.strike == 0) {
            System.out.println("낫싱");
        }
        if(this.ball > 0 && this.strike == 0) {
            System.out.println(this.ball + "볼");
        }
        if(this.ball == 0 && this.strike > 0) {
            System.out.println(this.strike + "스트라이크");
        }
        if(this.ball > 0 && this.strike > 0) {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        }
    }

    public int getStrikeCount() {
        return this.strike;
    }

    public int getBallCount() {
        return this.ball;
    }
}

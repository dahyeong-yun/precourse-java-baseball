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
        if(judgement.isBall()) {
            this.ball++;
        }
        if(judgement.isStrike()) {
            this.strike++;
        }
    }

    public void report() {
        if(isNoBallAndNoStrike()) {
            System.out.println("낫싱");
        }
        if(hasBallAndNoStrike()) {
            System.out.println(this.ball + "볼");
        }
        if(hasStrikeAndNoBall()) {
            System.out.println(this.strike + "스트라이크");
        }
        if(hasBallAndStrike()) {
            System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
        }
    }

    private boolean hasBallAndStrike() {
        return this.ball > 0 && this.strike > 0;
    }

    private boolean hasStrikeAndNoBall() {
        return this.ball == 0 && this.strike > 0;
    }

    private boolean hasBallAndNoStrike() {
        return this.ball > 0 && this.strike == 0;
    }

    private boolean isNoBallAndNoStrike() {
        return this.ball == 0 && this.strike == 0;
    }

    public int getStrikeCount() {
        return this.strike;
    } // TODO 오로지 테스트를 위해 삽입한 메소드 삭제

    public int getBallCount() {
        return this.ball;
    } // TODO 오로지 테스트를 위해 삽입한 메소드 삭제
}

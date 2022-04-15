package baseball;

import java.util.List;

public class PlayResult {
    public int strike;
    public int ball;

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
        // 낫싱이면
        // 볼이 없으면
        // 스트라이크가 없으면
        System.out.println("낫싱" + "3스트라이크" + "1볼 1스트라이크" + "3스트라이크" + "게임 종료");
    }
}

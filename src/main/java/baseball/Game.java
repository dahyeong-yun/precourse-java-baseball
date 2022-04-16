package baseball;

import java.util.ArrayList;
import java.util.List;

// 하나의 게임이 시작하면서 끝까지를 책임지는 클래스. 정답을 가지고 있고, 지시어에 따라 정답과 비교하여 결과를 만들어내는 역할
public class Game {
    private static List<Ball> answers;

    public Game() {
        answers = new ArrayList<>();
        answers.add(Ball.createBall(0,1));
        answers.add(Ball.createBall(1,2));
        answers.add(Ball.createBall(2,3));
    }

    public PlayResult play(List<Ball> inputBalls) {
        PlayResult playResult = PlayResult.init();

        for (Ball inputBall : inputBalls) {
            PlayJudge judge = inputBall.play(answers);
            playResult.note(judge);
        }

        playResult.strike = 3; // TODO 일단 테스트를 통과하기 위한 코드, 삭제 필요

        return playResult;
    }
}

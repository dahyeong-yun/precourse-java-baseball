package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private static List<Ball> answers;

    public Game() {
        answers = new ArrayList<>();
        setAnswers();
    }

    private void setAnswers() {
        while (answers.size() < 3) {
            pickNonDuplicateBall();
        }
    }

    private void pickNonDuplicateBall() {
        int newNum = Randoms.pickNumberInRange(1, 10);
        if(!isDuplicate(newNum)) {
            answers.add(Ball.createBall(answers.size(), newNum));
        }
    }

    private boolean isDuplicate(int newNum) {
        List<Integer> occupiedNumber = new ArrayList<>();
        for (Ball answer : answers) {
            occupiedNumber.add(answer.getValue());
        }
        return occupiedNumber.contains(newNum);
    }

    public PlayResult play(List<Ball> inputBalls) {
        PlayResult playResult = PlayResult.init();

        for (Ball inputBall : inputBalls) {
            PlayJudge judge = inputBall.play(answers);
            playResult.note(judge);
        }

        return playResult;
    }
}

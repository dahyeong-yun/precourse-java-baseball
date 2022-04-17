package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private static List<Ball> answers;

    private Game() {
        setAnswers();
    }

    public static Game startNewGame() {
        return new Game();
    }

    private void setAnswers() {
        answers = new ArrayList<>();
        while (isAnswersQualified()) {
            pickNonDuplicateBall();
        }
    }

    private boolean isAnswersQualified() {
        return answers.size() < 3;
    }

    private void pickNonDuplicateBall() {
        int newNumber = Randoms.pickNumberInRange(1, 10);
        if(isNotDuplicate(newNumber)) {
            answers.add(Ball.createBall(answers.size(), newNumber));
        }
    }

    private boolean isNotDuplicate(int newNumber) {
        List<Integer> occupiedNumbers = new ArrayList<>();

        for (Ball answer : answers) {
            occupiedNumbers.add(answer.getValue());
        }

        return !occupiedNumbers.contains(newNumber);
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

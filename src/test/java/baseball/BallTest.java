package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    List<Ball> answers;

    @BeforeEach
    void setting() {
        answers = new ArrayList<>();
        answers.add(Ball.createBall(0, 1));
        answers.add(Ball.createBall(1, 2));
        answers.add(Ball.createBall(2, 3));

    }

    @Test
    @DisplayName("공은 String 값을 정수 값으로 갖는다.")
    void 공은_값을_가지고_있다() {
        int input = 5;
        Ball ball = Ball.createBall(0, input);
        assertThat(ball.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("공의 유효 값은 1보다 크거나 같은 한 자리 양의 정수이다.")
    void 공의_값은_1보다_큰_한자리_양의_정수(){
        assertThatThrownBy(() -> Ball.createBall(0, 10)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Ball.createBall(1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThat(Ball.createBall(0, 1).getValue()).isEqualTo(1);
        assertThat(Ball.createBall(1, 9).getValue()).isEqualTo(9);
    }

    @Test
    @DisplayName("순서와 값이 같으면 스트라이크")
    void 순서와_값이_같으면_스트라이트() {
        Ball userBall = Ball.createBall(0,1);
        PlayJudge playJudge = userBall.play(answers);
        assertThat(playJudge).isEqualTo(PlayJudge.STRIKE);
    }

    @Test
    @DisplayName("순서는 다르고, 값이 같으면 볼")
    void 순서는_다르고_값이_같으면_볼() {
        Ball userBall = Ball.createBall(1,1);
        PlayJudge playJudge = userBall.play(answers);
        assertThat(playJudge).isEqualTo(PlayJudge.BALL);
    }

    @Test
    @DisplayName("순서와 값이 모두 다르면 NULL")
    void 순서와_값이_모두_다르면_NULL() {
        Ball userBall = Ball.createBall(0,5);
        PlayJudge playJudge = userBall.play(answers);
        assertThat(playJudge).isEqualTo(PlayJudge.NOTHING);
    }
}

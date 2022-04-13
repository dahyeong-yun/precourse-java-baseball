package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    @DisplayName("공은 String 값을 정수 값으로 갖는다.")
    void 공은_값을_가지고_있다() {
        String input = "5";
        Ball ball = new Ball(input);
        assertThat(ball.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("공의 유효 값은 1보다 크거나 같은 한 자리 양의 정수이다.")
    void 공의_값은_1보다_큰_한자리_양의_정수(){
        assertThatThrownBy(() -> new Ball("10"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ball("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(new Ball("1").getValue()).isEqualTo(1);
        assertThat(new Ball("9").getValue()).isEqualTo(9);
    }
}

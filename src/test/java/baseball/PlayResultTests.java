package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTests {
    @Test
    @DisplayName("3스트라이크면 게임 종료 상태가 된다.")
    void 스트라이크_3개면_게임종료() {
        PlayResult result = new PlayResult();
        result.strike = 3;
        assertThat(result.isGameEnd()).isEqualTo(true);
    }
}

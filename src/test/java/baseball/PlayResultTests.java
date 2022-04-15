package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTests {
    @Test
    @DisplayName("볼_판정 결과가 나오면 결과에 기록된다.")
    void 볼_판정_결과를_기록() {
        PlayResult result = new PlayResult();
        result.note(PlayJudge.BALL);
        assertThat(result.ball).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크_판정 결과가 나오면 결과에 기록된다.")
    void 스트라이크_판정_결과를_기록() {
        PlayResult result = new PlayResult();
        result.note(PlayJudge.STRIKE);
        assertThat(result.strike).isEqualTo(1);
    }

    @Test
    @DisplayName("3스트라이크면 게임 종료 상태가 된다.")
    void 스트라이크_3개면_게임종료() {
        PlayResult result = new PlayResult();
        result.strike = 3;
        assertThat(!result.isNotGameEnd()).isEqualTo(true);
    }
}

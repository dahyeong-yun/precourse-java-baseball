package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTests {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    @DisplayName("볼_판정 결과가 나오면 결과에 기록된다.")
    void 볼_판정_결과를_기록() {
        PlayResult result = PlayResult.init();
        result.note(PlayJudge.BALL);
        result.report();
        assertThat(outputMessage.toString()).isEqualTo("1볼\n");
    }

    @Test
    @DisplayName("스트라이크_판정 결과가 나오면 결과에 기록된다.")
    void 스트라이크_판정_결과를_기록() {
        PlayResult result = PlayResult.init();
        result.note(PlayJudge.STRIKE);
        result.report();
        assertThat(outputMessage.toString()).isEqualTo("1스트라이크\n");
    }

    @Test
    @DisplayName("3스트라이크면 게임 종료 상태가 된다.")
    void 스트라이크_3개면_게임종료() {
        PlayResult result = PlayResult.init();
        result.note(PlayJudge.STRIKE);
        result.note(PlayJudge.STRIKE);
        result.note(PlayJudge.STRIKE);
        assertThat(!result.isNotGameEnd()).isEqualTo(true);
    }
}

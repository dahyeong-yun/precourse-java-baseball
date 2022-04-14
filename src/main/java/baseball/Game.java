package baseball;

import java.util.List;

// 하나의 게임이 시작하면서 끝까지를 책임지는 클래스. 정답을 가지고 있고, 지시어에 따라 정답과 비교하여 결과를 만들어내는 역할
public class Game {
    private List<Ball> answers;

    public static void play(List<Ball> inputBalls) {
        // while(false) 3 strike가 나와야 종료

        System.out.println("낫싱" + "3스트라이크" + "1볼 1스트라이크" + "3스트라이크" + "게임 종료");
    }
}

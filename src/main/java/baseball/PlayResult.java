package baseball;

public class PlayResult {
    public int strike;

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}

# 1주차 미션


## 미션 요구사항


### 기능 요구사항
- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
- e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후에 애플리케이션은 종료되어야 한다.

### 주요 프로그래밍 요구사항
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console`과 `Random`을 사용할 것
- `ApplicationTest`의 2개 테스트는 통과 되어야 함.
- 프로그램 시작 지점은 `Application`의 `main()` 이다.
- indent는 1까지만 허용한다.
- else 예약어를 쓰지 않는다.

### 과제 진행 요구사항
- 커밋 메세지 규칙은 AngularJS commit conventions를 [참고](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)한다.

## 기능 리스트

### `baseball.GameConsole`
- [X] 게임을 시작하면 게임 콘솔을 실행한다.
  - 게임 콘솔에서
    - [X] 2를 입력하면 종료
    - [X] 1을 입력하면 게임을 다시 시작한다.
  - [X] 입력값은 validation 체크가 되어야 한다.
    - [ ] 전체 입력값은 오로지 1~3자리 이하의 숫자만 가능하다.
      - [X] 1 <= String.length() <= 3
      - [ ] String.chatAt(i) -> int casting이 가능해야함 
  - [X] `baseball.GameConsole.excute()` 안에서는 '입력()) -> 종료 여부 체크(`PlayResult.isNotGameEnd()`)' 루틴(=3스트라이크를 체크)을 반복해야한다.

### `baseball.Game`
- [X] 게임은 기본 setting으로 3개의 공을 갖는다.
  - [X] `baseball.Game`는 `List<Ball> answers`를 가지고 시작한다.
- 게임을 플레이 하는 경우는 `baseball.Game.play()` 해당 (게임을 시작하는 것과 매판 플레이 하는 것을 별개로 봄)
  - [X] 입력값과 게임이 갖고 있는 공 전체를 비교한다.
    - `PlayJudge judge = inputBall.play(answers);`
    - [X] 이때 input의 length만큼 비교를 반복한다. -> for
  - [X] 3스트라이크 일때까지 지속한다. ` while(playResult.isNotGameEnd())`

### `baseball.PlayResult`
- [X] `PlayResult.note(PlayJudge)` 에서 판정 결과를 가지고 플레이 전체의 결과를 저장한다. 
  - [X] 스트라이크의 수
  - [X] 볼의 수
- [X] 플레이의 결과를 가지고 종료 여부(3스트라이크여부)를 판단한다. `PlayResult.isNotGameEnd()`
- [X] 플레이 결과를 유저가 인지할 수 있는 형태로 출력한다. `PlayResult.report()`

### `baseball.Ball`
- [X] 각각의 공은 순서와 값을 갖는다. 
  - `baseball.Ball`은 멤버 변수로 `value`와 `order`를 가진다.
  - [X] 공의 값은 매번 랜덤으로 주어진다.
  - [X] 각 공의 값은 중복되지 않는다.
- [X] 생성 시점에 입력 값이 유효값인지 판단한다.
- [X] 공과 공을 비교하여 strike냐, ball이냐, 낫싱이냐 를 판정한다. `Ball.play(List<Ball>)`
  - [X] 입력값과 공의 순서와 값이 모두 같으면 `스트라이크` -> `PlayJudge.STRIKE`
  - [X] 입력값과 공의 순서는 다르고 값만 같으면 `볼` -> `PlayJudge.BALL`
  - [X] 입력값과 공의 순서와 값이 모두 같지 않으면 `낫싱` -> `PlayJudge.NOTHING`
  - [X] 전체 결과를 `PlayJudge`를 반환한다.

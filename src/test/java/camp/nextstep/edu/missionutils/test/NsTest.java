package camp.nextstep.edu.missionutils.test;

import java.util.List;

public abstract class NsTest {
	
	static List<String> result;	
	
	public void runMain() {
		
	}
	
	public List<String> output() {
		return result;
	}
	
	public void run(String ...string) {
		// run의 return을 검사하는 것이 아니기 때문에 상태를 변경한다고 추측할 수 있음.
	}
	
	public void runException(String string) throws Exception {
		
	}
}

package camp.nextstep.edu.missionutils.test;

import org.junit.jupiter.api.function.Executable;

public class Assertions {
	public static void assertRandomNumberInRangeTest(Executable executable, int... scale) {
		
		// TODO scale로 random number 만들기
		try {
			executable.execute();
		} catch (Throwable actualException) {
			
		}
	}
	
	public static void assertSimpleTest(Executable executable) {
		
	}
}

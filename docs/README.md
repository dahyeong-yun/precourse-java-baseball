# 1차 미션 개요

## 요구 사항

- 모든 도메인 로직에 대한 단위테스트가 작성되어야 함.
- 기본 컨벤션을 지킬 것
- 커밋 메세지
- 기능 목록 작성

## 기능 목록


## 일자별 진행
### 4/12
- [ ] `ApplicationTest` 일단 돌아가게 만들기
  - [ ] gradle 의존성 추가
  - [ ] NsTest 클래스 생성
    - [ ] 메소드 추가
    - `Executable` 관련 참고
    ```java
    /*
     * Copyright 2015-2020 the original author or authors.
     *
     * All rights reserved. This program and the accompanying materials are
     * made available under the terms of the Eclipse Public License v2.0 which
     * accompanies this distribution and is available at
     *
     * https://www.eclipse.org/legal/epl-v20.html
     */
    
    package org.junit.jupiter.api;
    
    import static org.junit.jupiter.api.AssertionUtils.buildPrefix;
    import static org.junit.jupiter.api.AssertionUtils.format;
    import static org.junit.jupiter.api.AssertionUtils.getCanonicalName;
    import static org.junit.jupiter.api.AssertionUtils.nullSafeGet;
    
    import java.util.function.Supplier;
    
    import org.junit.jupiter.api.function.Executable;
    import org.junit.platform.commons.util.UnrecoverableExceptions;
    import org.opentest4j.AssertionFailedError;
    
    /**
     * {@code AssertThrows} is a collection of utility methods that support asserting
     * an exception of an expected type is thrown.
     *
     * @since 5.0
     */
    class AssertThrows {
    
    	private AssertThrows() {
    		/* no-op */
    	}
    
    	static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable) {
    		return assertThrows(expectedType, executable, (Object) null);
    	}
    
    	static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable, String message) {
    		return assertThrows(expectedType, executable, (Object) message);
    	}
    
    	static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable,
    			Supplier<String> messageSupplier) {
    
    		return assertThrows(expectedType, executable, (Object) messageSupplier);
    	}
    
    	@SuppressWarnings("unchecked")
    	private static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable,
    			Object messageOrSupplier) {
    
    		try {
    			executable.execute();
    		}
    		catch (Throwable actualException) {
    			if (expectedType.isInstance(actualException)) {
    				return (T) actualException;
    			}
    			else {
    				UnrecoverableExceptions.rethrowIfUnrecoverable(actualException);
    				String message = buildPrefix(nullSafeGet(messageOrSupplier))
    						+ format(expectedType, actualException.getClass(), "Unexpected exception type thrown");
    				throw new AssertionFailedError(message, actualException);
    			}
    		}
    
    		String message = buildPrefix(nullSafeGet(messageOrSupplier))
    				+ String.format("Expected %s to be thrown, but nothing was thrown.", getCanonicalName(expectedType));
    		throw new AssertionFailedError(message);
    	}
    
    }
    ```
  - [ ]  
    
   
	


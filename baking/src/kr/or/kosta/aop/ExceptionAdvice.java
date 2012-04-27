package kr.or.kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	public Object aroundException(ProceedingJoinPoint jp){
		Object returnValue=null;	
			//사용자 또는 스트럿츠가 호출한 메서드를 호출
			//jp.proceed()
			//스트럿츠가 호출한 메서드의 리턴값을 returnValue에 저장
		try {
				returnValue=jp.proceed();
				System.out.println(returnValue);
		}catch(Throwable e){
			e.printStackTrace();
			return "error";
		}
		return returnValue;
	}
}

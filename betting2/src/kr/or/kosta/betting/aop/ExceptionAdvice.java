package kr.or.kosta.betting.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	
	public Object aroundException(ProceedingJoinPoint jp){
		Object returnValue=null;
		
			//사용자 또는 스트럿츠가 호출한 메서드를 호출
			//jp.proceed()
			//스트럿츠가 호출한 메서드의 리턴값을 returnValue에 저장
		try {
				
				returnValue=jp.proceed();			
		}catch(Throwable e){
			//Exception발생
			e.printStackTrace();//Exception발생이유를 console출력
			return "error";//"error"리턴 메서드 종료
		}
		return returnValue;
	}
}

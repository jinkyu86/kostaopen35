package kr.or.kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	public Object arroundException(ProceedingJoinPoint jp){
		Object returnValue=null;
		try{
			//사용자 또는 스트럿츠가 호출한 메서드를 호출
			//jp.proceed();
			//스트럿츠(사용자)가 호출한 메서드의 리턴값을 returnValue에 저장
			returnValue=jp.proceed();
		}catch (Throwable e) {
			e.printStackTrace();//Exception발생이유를 Console 출력
			return "error"; //"error"리턴 메서드 종료
		}
		return returnValue; 
	}
}

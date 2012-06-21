package kr.or.kosta.moviesystem.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	public Object aroundException(ProceedingJoinPoint jp	){
		Object returnValue=null;
		try{
			returnValue=jp.proceed();
		}catch(Throwable e){
			e.printStackTrace();
			return "error";
		}
		return returnValue;
	}
}

package kr.or.kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
 public Object aroundException(ProceedingJoinPoint jp){
	 Object returnValue=null;
	 try{
		 returnValue=jp.proceed();
		 
	 }catch(Throwable e){
		 //Exception이 발생
		 e.printStackTrace();//Exception발생 이유를 console창에 출력
		 return "error";//"error"리턴 메서드 종료. 종료가 안됐다는 것은 catch를 실행하지 않았다는 것이고 그 얘기는 에러가 나지 않았따는 얘기다.
	 }
	 return returnValue; 
 }
}

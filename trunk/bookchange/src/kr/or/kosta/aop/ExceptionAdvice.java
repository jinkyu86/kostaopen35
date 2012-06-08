package kr.or.kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
 public Object aroundException(ProceedingJoinPoint jp){
	 Object returnValue=null;
	 try{
		 returnValue=jp.proceed();
		 
	 }catch(Throwable e){
		 //Exception�� �߻�
		 e.printStackTrace();//Exception�߻� ������ consoleâ�� ���
		 return "error";//"error"���� �޼��� ����. ���ᰡ �ȵƴٴ� ���� catch�� �������� �ʾҴٴ� ���̰� �� ���� ������ ���� �ʾҵ��� ����.
	 }
	 return returnValue; 
 }
}

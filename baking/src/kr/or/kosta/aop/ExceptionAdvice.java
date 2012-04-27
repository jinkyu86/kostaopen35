package kr.or.kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	public Object aroundException(ProceedingJoinPoint jp){
		Object returnValue=null;	
			//����� �Ǵ� ��Ʈ������ ȣ���� �޼��带 ȣ��
			//jp.proceed()
			//��Ʈ������ ȣ���� �޼����� ���ϰ��� returnValue�� ����
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

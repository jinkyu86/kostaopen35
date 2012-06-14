package kr.or.kosta.betting.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	
	public Object aroundException(ProceedingJoinPoint jp){
		Object returnValue=null;
		
			//����� �Ǵ� ��Ʈ������ ȣ���� �޼��带 ȣ��
			//jp.proceed()
			//��Ʈ������ ȣ���� �޼����� ���ϰ��� returnValue�� ����
		try {
				
				returnValue=jp.proceed();			
		}catch(Throwable e){
			//Exception�߻�
			e.printStackTrace();//Exception�߻������� console���
			return "error";//"error"���� �޼��� ����
		}
		return returnValue;
	}
}

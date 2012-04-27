package kr.or.kosta.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	public Object arroundException(ProceedingJoinPoint jp){
		Object returnValue=null;
		try{
			//����� �Ǵ� ��Ʈ������ ȣ���� �޼��带 ȣ��
			//jp.proceed();
			//��Ʈ����(�����)�� ȣ���� �޼����� ���ϰ��� returnValue�� ����
			returnValue=jp.proceed();
		}catch (Throwable e) {
			e.printStackTrace();//Exception�߻������� Console ���
			return "error"; //"error"���� �޼��� ����
		}
		return returnValue; 
	}
}

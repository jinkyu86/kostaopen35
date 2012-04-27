package kr.or.kosta.betting.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExceptionAdvice {
	public Object aroundException(ProceedingJoinPoint jp){
		Object returnValue=null;
		try{
			//����� �Ǵ� ��Ʈ��ġ�� ȣ���� �޼��带 ȣ��
			//jp.proceed()
			//��Ʈ��ġ�� ȣ���� �޼����� ���ϰ��� returnValue�� ����
			returnValue=jp.proceed();
		}catch(Throwable e){
			//Exception�߻�
			e.printStackTrace();//Exception�߻������� console���
			return "error";//"error"���� �޼��� ����
		}
		return returnValue;
	}
}

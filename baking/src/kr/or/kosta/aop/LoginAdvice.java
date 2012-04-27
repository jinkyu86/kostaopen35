package kr.or.kosta.aop;

import java.util.Map;

import kr.or.kosta.member.Member;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAdvice {
	public Object aroundLogin(ProceedingJoinPoint jp) throws Throwable {
		Object returnValue=null;
		//��Ʈ������ ȣ���� ��ü����(StudentService,
		//                                         ProfessorService,BoardService)
		//-jp.getTarget()
		IService service=(IService)jp.getTarget();
		Map session=service.getSession();
		if(session==null){
			return "loginForm";
		}
		Member member= (Member)session.get("member");
		
		if(member==null){
			return "loginForm";
		}
		try {
				returnValue=jp.proceed();			
		}catch(Throwable e){
			throw e;//Exception�� �ٸ� AOPŬ������ ����
		}
		return returnValue;
		
	}
}

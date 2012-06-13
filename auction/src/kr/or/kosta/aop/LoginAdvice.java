package kr.or.kosta.aop;

import java.util.Map;

import kr.or.kosta.student.Student;
import kr.or.kosta.student.StudentService;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAdvice {
	public Object aroundLogin(ProceedingJoinPoint jp) throws Throwable{
		Object returnValue=null;
		//스트럿츠가 호출한 객체리턴(StudentService,
		//                                         ProfessorService,BoardService)
		//-jp.getTarget()
		IService service=(IService)jp.getTarget();
		Map session=service.getSession();
		if(session==null){
			return "loginForm";
		}
		Student student=
				 (Student)session.get("LOGIN_STUDENT");
		if(student==null){
			return "loginForm";
		}
		try {
				returnValue=jp.proceed();			
		}catch(Throwable e){
			throw e;//Exception을 다른 AOP클래스로 전달
		}
		return returnValue;
	}
}

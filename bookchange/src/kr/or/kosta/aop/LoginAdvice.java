package kr.or.kosta.aop;

import java.util.Map;

import kr.or.kosta.bookchange.member.Member;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAdvice {
 public Object aroundLogin(ProceedingJoinPoint jp) throws Throwable{
	 Object returnValue=null;
	 //스트럿츠가 호출한 객체 리턴(StudentService,ProfessorService,BoardService)
	 //jp.getTarget()
	 IService service=(IService) jp.getTarget();
	 Map session=service.getSession();
	 
	 if(session==null){
		 return "loginForm";
	 }
	 Member member=(Member) session.get("LOGIN_EMAIL");
	 if(member==null){
		 return "loginForm";
	 }
	 
	 try{		 
		 returnValue=jp.proceed();//이상 없으면 실제 메서드 리턴해줌 
	 }catch(Throwable e){
		throw e;//Exception을 다른 AOP클래스로 전달하겠다.
	 }
	 return returnValue; 
 }
}

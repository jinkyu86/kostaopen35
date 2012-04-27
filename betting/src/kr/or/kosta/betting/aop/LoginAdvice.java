package kr.or.kosta.betting.aop;

import java.util.Map;

import kr.or.kosta.betting.member.Member;


import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAdvice {
	public Object aroundLogin(ProceedingJoinPoint jp) throws Throwable{
		Object returnValue=null;
		IService service = (IService)jp.getTarget();
		Map session= service.getSession();
		System.out.println(jp.getSignature());
		System.out.print(session);
		if(session==null){
			return "loginForm";
		}
		Member member =(Member)session.get("LOGIN_MEMBER");
		System.out.println(member);
		if(member==null){
			return "loginForm";
		}
		try{
			returnValue=jp.proceed();
		}catch(Throwable e){
			throw e;
		}
		return returnValue;
	}
}

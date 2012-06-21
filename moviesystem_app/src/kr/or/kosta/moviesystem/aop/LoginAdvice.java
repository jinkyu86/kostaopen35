package kr.or.kosta.moviesystem.aop;

import java.util.Map;

import kr.or.kosta.moviesystem.member.Member;


import org.aspectj.lang.ProceedingJoinPoint;

public class LoginAdvice {
	public Object aroundLogin(ProceedingJoinPoint jp	) throws Throwable{
		Object returnValue=null;
		IService service=(IService)jp.getTarget();
		Map session=service.getSession();
		if(session==null){
			return "loginForm";
		}
		Member member=(Member)session.get("LOGIN_MEMBER");
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

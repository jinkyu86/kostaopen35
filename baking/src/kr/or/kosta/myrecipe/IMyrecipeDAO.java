package kr.or.kosta.myrecipe;

import java.util.ArrayList;

public interface IMyrecipeDAO {

	void insertMember(Myrecipe myrecipe);
	void deleteMyrecipe(int boardnum);
	void updateMyrecipe(Myrecipe myrecipe);
	
	ArrayList selectMyrecipeList(int length, int page);
	Myrecipe selectMyrecipe(int int$20boardnum);

	;

}

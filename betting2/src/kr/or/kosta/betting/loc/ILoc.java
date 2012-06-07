package kr.or.kosta.betting.loc;

import java.util.List;

public interface ILoc {

	List<Loc> selectLocList();

	Loc selectLoc(String locNum);

}

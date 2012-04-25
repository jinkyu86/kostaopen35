package kr.or.kosta.bookchange.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.kosta.bookchange.member.Member;

public class QaService implements ModelDriven {
	private IQaDAO qaDAO;
	private static final long serialVersionUID = 1L;
	private Qa qa=new Qa();	
	private Qa EDITQA;
	private String boardNo;
	private String qaNo;
	
	public QaService(){
		super();
	}	
	
	public QaService(IQaDAO qaDAO) {
		super();
		System.out.println("QaService(IQaDAO qaDAO)");
		System.out.println("qaDAO:"+qaDAO);
		this.qaDAO = qaDAO;
	}


	public Qa getEDITQA() {
		return EDITQA;
	}

	public void setEDITQA(Qa eDITQA) {
		EDITQA = eDITQA;
	}

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public Qa getQa() {
		return qa;
	}

	public void setQa(Qa qa) {
		this.qa = qa;
	}

	/**	 * 상품문의 글 추가 */
	public String addQa() throws Exception {
		
		qaDAO.insertQa(qa);

		return "success";
		
	}

	/**	 * 상품문의 수정  */
	public String editQa() throws Exception {
				
		qaDAO.updateQa(qa);		
				
		return "success";
	}

	/**	 * 상품문의 삭제  */
	public String removeQa() throws Exception {
		
		qaDAO.deleteQabyQaNo(qaNo);	
		
		return "success";
	}

	/**	 * 상품문의 수정 창  */
	public String editQaForm() throws Exception {
		
		EDITQA=qa;
		return "success";
	}

	@Override
	public Object getModel() {
		return qa;
	}

	/**	 * 상품문의 보기	 */
	/*public void viewQa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo=request.getParameter("boardNo");
		Qa qa=QaDAO.selectQaList(length, page, boardNo);
		request.setAttribute("QA",qa);
		
		RequestDispatcher rd=request.getRequestDispatcher("/BoardService?method=viewBoard&boardNo="+boardNo);
		rd.forward(request, response);
	}*/
}

package kr.or.kosta.file.receive;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/filesend.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//임시 폴더 temp의 절대 경로를 리턴!
		String tempRealPath=getServletContext().getRealPath("/temp");
		System.out.println("tempRealPath:"+tempRealPath);		
		//임시폴더 temp의 정보를 알아내는 객체 생성
		File tempDirectory=new File(tempRealPath);
		//temp폴더가 존재 안하는가!?
		if(!tempDirectory.exists()){
			//폴더 생성
			tempDirectory.mkdir();
		}
		
		//파일을 저장할 폴더의 절대경로 리턴
		String uploadRealPath=getServletContext().getRealPath("/bookimg");
		System.out.println("uploadRealPath:"+uploadRealPath);
		//파일 저장 폴더의 정보를 알아내는 객체 생성(있는지 없는지~)
		File uploadDirectory=new File(uploadRealPath);
		//파일 저장 폴더가 존재하지 않는다면
		if(!uploadDirectory.exists()){
			//폴더 생성
			uploadDirectory.mkdir();
		}		
		
		//임시폴더에 저장할 수 있는 파일 1개의 최대 사이즈 설정(단위는 바이트)
		int fileMaxSize=1024*1000*1000;//1기가
		//HttpServletRequest request의 파일의 내용을 꺼내서 임시폴더에 저장
		//new DiskFileItemFactory(임시파일 하나 최대사이즈,임시파일 폴더)
		DiskFileItemFactory factory=new DiskFileItemFactory(fileMaxSize,tempDirectory);
		//임시파일로 저장된 정보 리턴해주는 객체 -파일수,원래 이름
		ServletFileUpload upload=new ServletFileUpload(factory);
		//임시파일의 정보를 저장할 List 선언
		List<FileItem> fileList=null;
		//임시파일들의 정보를 리턴
		//temp폴더 내용들은 서블렛 종료되면 다 삭제됨
		try {
			fileList=upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String realSaveFileName=null;	
		for(int i=0;i<fileList.size();i++){
			//임시파일 하나의 정보 리턴
			FileItem file=fileList.get(i);
			//파일의 원래 파일의 이름(화장자포함)을 리턴
			String originalFileName=file.getName();
			System.out.println("업로드파일명:"+originalFileName);
			if(originalFileName!=null){
			//이동할 파일의 경로, 파일명 정보 저장 객체
			File uploadFile=new File(uploadDirectory+"/"+originalFileName);
			//같은 이름의 파일이 존재하면 파일명에 번호 붙여서 리턴
			uploadFile=FileRenamePolicy.rename(uploadFile);
			//파일 이동
			try {
				file.write(uploadFile);
				//진짜로 저장한 파일 이름 리턴
				realSaveFileName=uploadFile.getName();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}//end if
			
		}//end for
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(realSaveFileName);
		out.flush();
		out.close();
	}

}









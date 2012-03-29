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

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/fileSend.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//임시폴더 temp의 절대경로를 리턴
		  String tempRealPath=getServletContext().getRealPath("/temp");
		  System.out.println("tempRealPath:"+tempRealPath);
		  //임시폴더 temp의 정보를 알아내는 객체 생성
		  File tempDirectory=new File(tempRealPath);
		  //temp 폴더가 존재 하는가?
		  if(!tempDirectory.exists()){
			  tempDirectory.mkdir();
		 }
		  
		  //파일을 지정할 폴더의 절대경로 리턴
		  String uploadRealPath=getServletContext().getRealPath("/gphoto");
		  System.out.println("uploadRealPath:"+uploadRealPath);
		  //파일 저장 폴더의 정보를 알아내는 객체 생성
		  File uploadDirectory=new File(uploadRealPath);
		  //파일 저장 폴더가 존재하지 않는다면
		  //폴더 생성
		  if(!uploadDirectory.exists()) uploadDirectory.mkdir();
		  
		  
		  //임시폴더에 저장할수 있는 파일 1개
		  //최대 사이즈 설정 (단위 byte)
		  int fileMaxSize=1024*1000*1000;//1G
		  //HttpServletRequest request의 파일의 내용을 꺼내서
		  //임시폴더에 저장
		  //new DiskFileItemFactory(임시파일 하나 최대사이즈,임시파일 폴더)
		  DiskFileItemFactory factory=new DiskFileItemFactory(fileMaxSize,tempDirectory);
		  //임시파일로 저장된 정보리턴 객체-파일 수,원래이름
		  ServletFileUpload upload=new ServletFileUpload(factory);
		  //임시 파일의 정보를 저장할 List선언
		  List<FileItem> fileList=null;
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
			  //파일의 원래 이름을 리턴
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
		  }
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out=response.getWriter();
		  out.println(realSaveFileName);
		  out.flush();
		  out.close();
	}
}

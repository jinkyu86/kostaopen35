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

import kr.or.kosta.gooddivision.Good_division;
import kr.or.kosta.photo.Photo;
import kr.or.kosta.photo.PhotoDAO;
import kr.or.kosta.recipe.Recipe;
import kr.or.kosta.recipe.RecipeDAO;

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
		RequestDispatcher rd=
				request.getRequestDispatcher("/fileSend.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("UploadServlet");
		List<FileItem>  fileList=null;
		
		//C:\devlopement\workspace\baking\WebContent\img
		String  tempRealPath= "c://devlopement/workspace/baking/WebContent/img/temp";
		System.out.println("tempRealPath:"+ tempRealPath);
		File  tempDirectory=new File(tempRealPath);
		if(!tempDirectory.exists()){
				tempDirectory.mkdir();
		}
		
		String uploadRealPath= "c://devlopement/workspace/baking/WebContent/img/gphoto";
		System.out.println("uploadRealPath:"+ uploadRealPath);
		File uploadDirectory=new File(uploadRealPath);
		if(!uploadDirectory.exists()){
			uploadDirectory.mkdir();
		}	
		
		int fileMaxSize=1024*1000*1000;//1G
		DiskFileItemFactory factory = new DiskFileItemFactory(fileMaxSize, tempDirectory);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			fileList=upload.parseRequest(request);
		} catch (FileUploadException e) {	e.printStackTrace();}
		
		String realSaveFileName="c://devlopement/workspace/baking/WebContent/img/recipe_";
		String realNameList="[";
		String forderName="";
		int division=0;
		
		for(int i=0;i<fileList.size();i++){
			//임시파일 하나의 정보 리턴
			FileItem file=fileList.get(i);
			String parameterName=file.getFieldName();
				
			if("code1".equals(parameterName)){
				System.out.println("code1:"+file.getString());
				division=Integer.parseInt(file.getString());
				System.out.println(division);
				if(division==1){//cookie
					forderName="cookie";
				}else if(division==2){//cake
					forderName="cake";
				}else if(division==3){//chocolete
					forderName="chocolete";
				}
			}
			//파일의 원래 파일의 이름(확장자포함)을 리턴
			
			String originalFileName=file.getName();
			
			if(i==4){
				System.out.println("==================================");
				System.out.println("업로드파일명:"+ originalFileName);
				realNameList+="originalFileName,";
			}
			if(originalFileName!=null){
				//이동할 파일의 경로,파일명 정보 저장 객체
				File  uploadFile=new File(realSaveFileName+forderName+"/"+originalFileName);
				//같은 이름의 파일이 존재하면 파일명에 번호 붙여서 리턴
				uploadFile= FileRenamePolicy.rename(uploadFile);
				//파일 이동
				try {
					file.write(uploadFile);
					realSaveFileName=uploadFile.getName();
				} catch (Exception e) {	e.printStackTrace();}
			}//end if
		}//end for
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		realNameList+="]";
		System.out.println(realNameList);
		out.println(realSaveFileName);
		out.flush();
		out.close();
	}

}





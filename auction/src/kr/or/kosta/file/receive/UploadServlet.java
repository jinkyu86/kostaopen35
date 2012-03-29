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
		//�ӽ����� temp�� �����θ� ����
		  String tempRealPath=getServletContext().getRealPath("/temp");
		  System.out.println("tempRealPath:"+tempRealPath);
		  //�ӽ����� temp�� ������ �˾Ƴ��� ��ü ����
		  File tempDirectory=new File(tempRealPath);
		  //temp ������ ���� �ϴ°�?
		  if(!tempDirectory.exists()){
			  tempDirectory.mkdir();
		 }
		  
		  //������ ������ ������ ������ ����
		  String uploadRealPath=getServletContext().getRealPath("/gphoto");
		  System.out.println("uploadRealPath:"+uploadRealPath);
		  //���� ���� ������ ������ �˾Ƴ��� ��ü ����
		  File uploadDirectory=new File(uploadRealPath);
		  //���� ���� ������ �������� �ʴ´ٸ�
		  //���� ����
		  if(!uploadDirectory.exists()) uploadDirectory.mkdir();
		  
		  
		  //�ӽ������� �����Ҽ� �ִ� ���� 1��
		  //�ִ� ������ ���� (���� byte)
		  int fileMaxSize=1024*1000*1000;//1G
		  //HttpServletRequest request�� ������ ������ ������
		  //�ӽ������� ����
		  //new DiskFileItemFactory(�ӽ����� �ϳ� �ִ������,�ӽ����� ����)
		  DiskFileItemFactory factory=new DiskFileItemFactory(fileMaxSize,tempDirectory);
		  //�ӽ����Ϸ� ����� �������� ��ü-���� ��,�����̸�
		  ServletFileUpload upload=new ServletFileUpload(factory);
		  //�ӽ� ������ ������ ������ List����
		  List<FileItem> fileList=null;
		  try {
			fileList=upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String realSaveFileName=null;
		  for(int i=0;i<fileList.size();i++){
			  //�ӽ����� �ϳ��� ���� ����
			  FileItem file=fileList.get(i);
			  //������ ���� �̸��� ����
			  String originalFileName=file.getName();
			  System.out.println("���ε����ϸ�:"+originalFileName);
			  if(originalFileName!=null){
				  //�̵��� ������ ���, ���ϸ� ���� ���� ��ü
				  File uploadFile=new File(uploadDirectory+"/"+originalFileName);
				  //���� �̸��� ������ �����ϸ� ���ϸ� ��ȣ �ٿ��� ����
				  uploadFile=FileRenamePolicy.rename(uploadFile);
				  //���� �̵�
				  try {
					file.write(uploadFile);
					//��¥�� ������ ���� �̸� ����
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

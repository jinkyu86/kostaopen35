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
		RequestDispatcher rd=
				request.getRequestDispatcher("/fileSend.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//�ӽ� ���� temp�� ���� ��θ� ����
		String  tempRealPath=
				getServletContext().getRealPath("/temp");
		System.out.println("tempRealPath:"+tempRealPath);
		//�ӽ����� temp�� ������ �˾Ƴ��� ��ü ����
		File  tempDirectory=new File(tempRealPath);
		//temp ������ ���� ���ϴ°�?
		if(!tempDirectory.exists()){
			//���� ����
			tempDirectory.mkdir();
		}
		//������ ������ ������ ������ ����
		String uploadRealPath=
				getServletContext().getRealPath("/upload");
		System.out.println("uploadRealPath:"+
				uploadRealPath);
		//���� ���� ������ ������ �˾Ƴ��� ��ü ����
		File uploadDirectory=new File(uploadRealPath);
		//���� ���� ������ �������� �ʴ´ٸ�
		if(!uploadDirectory.exists()){
			//���� ����
			uploadDirectory.mkdir();
		}	
		
		//�ӽ������� �����Ҽ� �ִ� ���� 1��
		//�ִ� ������ ���� (���� byte)
		int fileMaxSize=1024*1000*1000;//1G
		//HttpServletRequest request �� ������ ������ ������
		//�ӽ������� ����
		//new DiskFileItemFactory(�ӽ����� �ϳ� �ִ������,
		//                                                        �ӽ����� ����)
		DiskFileItemFactory factory = 
				 new DiskFileItemFactory(fileMaxSize, 
						 tempDirectory);
		//�ӽ����Ϸ� ����� �������� ��ü-���ϼ�,�����̸�
		ServletFileUpload upload = 
				  new ServletFileUpload(factory);
		//�ӽ� ������ ������ ������ List����
		List<FileItem>  fileList=null;
		
		//�ӽ����ϵ��� ������ ����
		try {
			fileList=upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<fileList.size();i++){
			//�ӽ����� �ϳ��� ���� ����
			FileItem file=fileList.get(i);
			String parameterName=file.getFieldName();
			System.out.println("parameterName:"+parameterName);
			if("code1".equals(parameterName)){
				System.out.println("code1:"+file.getString());
			}else if("code2".equals(parameterName)){
				System.out.println("code2:"+file.getString());
			}
			//������ ���� ������ �̸�(Ȯ��������)�� ����
			
			String originalFileName=file.getName();
		
//			String method=file.getString("method");
//			System.out.println(method);
//			String code2=file.getString("code2");
//			System.out.println(code2);
			System.out.println("���ε����ϸ�:"+
			        originalFileName);
			if(originalFileName!=null){
				//�̵��� ������ ���,���ϸ� ���� ���� ��ü
				File  uploadFile=new File(uploadDirectory+"/"+
			                                 originalFileName);
				//���� �̸��� ������ �����ϸ� ���ϸ� ��ȣ �ٿ�
				//�� ����
				uploadFile=
						 FileRenamePolicy.rename(uploadFile);
				//���� �̵�
				try {
					file.write(uploadFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//end if
		}//end for
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("���� ���� �Ϸ�");
		out.flush();
		out.close();
	}

}





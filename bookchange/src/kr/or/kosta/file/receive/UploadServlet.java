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
		//�ӽ� ���� temp�� ���� ��θ� ����!
		String tempRealPath=getServletContext().getRealPath("/temp");
		System.out.println("tempRealPath:"+tempRealPath);		
		//�ӽ����� temp�� ������ �˾Ƴ��� ��ü ����
		File tempDirectory=new File(tempRealPath);
		//temp������ ���� ���ϴ°�!?
		if(!tempDirectory.exists()){
			//���� ����
			tempDirectory.mkdir();
		}
		
		//������ ������ ������ ������ ����
		String uploadRealPath=getServletContext().getRealPath("/bookimg");
		System.out.println("uploadRealPath:"+uploadRealPath);
		//���� ���� ������ ������ �˾Ƴ��� ��ü ����(�ִ��� ������~)
		File uploadDirectory=new File(uploadRealPath);
		//���� ���� ������ �������� �ʴ´ٸ�
		if(!uploadDirectory.exists()){
			//���� ����
			uploadDirectory.mkdir();
		}		
		
		//�ӽ������� ������ �� �ִ� ���� 1���� �ִ� ������ ����(������ ����Ʈ)
		int fileMaxSize=1024*1000*1000;//1�Ⱑ
		//HttpServletRequest request�� ������ ������ ������ �ӽ������� ����
		//new DiskFileItemFactory(�ӽ����� �ϳ� �ִ������,�ӽ����� ����)
		DiskFileItemFactory factory=new DiskFileItemFactory(fileMaxSize,tempDirectory);
		//�ӽ����Ϸ� ����� ���� �������ִ� ��ü -���ϼ�,���� �̸�
		ServletFileUpload upload=new ServletFileUpload(factory);
		//�ӽ������� ������ ������ List ����
		List<FileItem> fileList=null;
		//�ӽ����ϵ��� ������ ����
		//temp���� ������� ���� ����Ǹ� �� ������
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
			//������ ���� ������ �̸�(ȭ��������)�� ����
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









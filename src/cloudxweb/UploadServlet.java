package cloudxweb;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/reg")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu=new ServletFileUpload(factory);
		try
		{
			List<FileItem> list=sfu.parseRequest(request);
			
			FileItem item=list.get(0);
			
			String path=item.getName(); //"D:/abc/ox.jpg"
			File f=new File(path);
			
			String name=f.getName();	//"ox.jpg"	
			
			File f1=new File("E:/upload/"+name);
			item.write(f1);
			
		}
		catch(Exception e)
		{
			
		}
		
	}

}

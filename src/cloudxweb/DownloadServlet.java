package cloudxweb;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String filename="pics.jpg";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("content-Disposition","attachment;filename=\""+filename+"\"");
		FileInputStream fis=new FileInputStream("E:/upload/pics.jpg");	
		int i=fis.read();
		while(i!=-1)
		{
			out.write(i);
			i=fis.read();
		}
		
	}

}

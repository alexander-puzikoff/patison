package ru.aupuzikov.img.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ImageProcessor
 */
public class ImageProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageProcessor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String appPath = request.getServletContext().getRealPath("");
		Part p = request.getPart("fileToUpload");
		String fileName = p.getSubmittedFileName();
		InputStream is = p.getInputStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		File f = new File(appPath + "\\img\\" + fileName);
		// f.mkdirs();
		PrintWriter pw;
		response.setContentType("text/html; charset=UTF-8");
		pw = response.getWriter();
		pw.println("Создаём файл для данных " + f.getCanonicalPath());
		f.createNewFile();
		if (!f.canWrite()) {
			pw.println("нельзя сохранить файл по адресу <br>");
			response.getWriter().println(f.getAbsolutePath());
		} else {
			f.createNewFile();
			FileOutputStream fw = new FileOutputStream(f);
			byte[] s = new byte[1024];
			int read = is.read(s);
			do {
				fw.write(s, 0, read);
			} while ((read = is.read(s)) != (-1));
			fw.flush();
			fw.close();
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("/src/processimg.jsp");
		Properties prop = new Properties();
		String filePropPath = "propt.path";
		File fProp = new File(f.getParent() + "/" + filePropPath);
		if (fProp.exists()) {
			FileReader fr = new FileReader(fProp);
			prop.load(fr);
			fr.close();
		}
		FileWriter fw = new FileWriter(fProp);
		// prop.setProperty(String.valueOf(f.hashCode()), f.getPath());
		prop.put(String.valueOf(f.hashCode()), f.getPath());
		prop.store(fw, "list of files");
		pw.println("Файл сохранен по адресу " + f.getPath());
		pw.println("prop по адресу " + fProp.getAbsolutePath());
		rd.forward(request, response);
		// br.close();
		is.close();
	}
}

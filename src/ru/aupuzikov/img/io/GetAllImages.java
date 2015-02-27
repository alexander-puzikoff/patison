package ru.aupuzikov.img.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class GetAllImages
 */
public class GetAllImages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllImages() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Properties prop = new Properties();
		String filePropPath = "propt.path";

		RequestDispatcher rd = request
				.getRequestDispatcher("/src/chooceimg.jsp");

		String appPath = request.getServletContext().getRealPath("");
		File fProp = new File(appPath + "/" + filePropPath);
		if (fProp.exists()) {
			FileReader fr = new FileReader(fProp);
			prop.load(fr);
			fr.close();
		}
		int i = 0;
		request.setAttribute("images_count", prop.values().size());
		for (Iterator<Object> it = prop.values().iterator(); it.hasNext();) {
			request.setAttribute(String.valueOf(i++), it.next());
		}
		rd.forward(request, response);
		// br.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
/*
 * Abstract for MSRSC Hello! I want to participate in this year school because
 * information technologies in general and of course machine learning is very
 * important for me. I want to use my new skills to help people wherever I can.
 * For example I want to use it by helping Russian medical centers to automate
 * processing of x-ray images, this problem is very big nowadays and it is up to
 * me to solve it as quick as possible, because subject will be my PhD thesis in
 * future. About myself : I learned machine learning and image processing during
 * my education in Saint-Petersburg state university on software engineer chair
 * and had excellent mark , that’s why including me will be the best choice for
 * judges. My experience in this subjects doesn’t ends with university. It was
 * lucky to me to participate as trainee in startup named “system of methods and
 * tools of digital processing”, this company also base in Saint-Petersburg. In
 * this company I was able to use machine learning and image processing while
 * making software that provides recognition of some documents on scanned image
 * files. Such abilities my software got with OpenCV library. Also by myself I
 * studied online course of Yaser S. Abu-Mustafa “learning from data” in
 * California Institute of Technology. In adding: I lived in Saint-Petersburg
// * for two years since 2014 year so I’ll be able to help some foreigners to
 * accommodate faster.
 */

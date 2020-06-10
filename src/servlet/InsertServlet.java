package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Keizibandao;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
@MultipartConfig(maxFileSize=1048576) // 1Mまで
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String content = request.getParameter("content");
		Part part = request.getPart("file");
		String imgname = this.getFileName(part);
		part.write("C:\\pleiades\\workspace\\Keiziban\\WebContent\\upload\\" + imgname);

		//特殊文字置換
		name = name.replace("&", "&amp;");
		name = name.replace("<", "&lt;");
		name = name.replace(">", "&gt;");
		name = name.replace("\"", "&quot;");
		mail = mail.replace("&", "&amp;");
		mail = mail.replace("<", "&lt;");
		mail = mail.replace(">", "&gt;");
		mail = mail.replace("\"", "&quot;");
		content = content.replace("&", "&amp;");
		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
		content = content.replace("\"", "&quot;");

		//時間取得
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = sdf.format(timestamp);

		String updtime = "";

		//新しい投稿を登録
		Keizibandao.InsertPost2(name,mail,content,time,updtime,imgname);

		String url = "/Keiziban/StartServlet";
		response.sendRedirect(url);
	}

	private String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return name;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

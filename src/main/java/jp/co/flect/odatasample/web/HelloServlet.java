package jp.co.flect.odatasample.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.getOutputStream().write("Hello world!".getBytes());
	}
}
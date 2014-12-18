package jp.co.flect.odatasample.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.persistence.EntityManager;
import jp.co.flect.odatasample.entities.Car;
import jp.co.flect.odatasample.odata.EntityManagerFactoryHolder;

public class JPATestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		EntityManager em = EntityManagerFactoryHolder.getInstance().createEntityManager();
		Car car = em.find(Car.class, 1);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(car.getCar_name() + ": " + car.getMaker().getMaker_name());
	}
}


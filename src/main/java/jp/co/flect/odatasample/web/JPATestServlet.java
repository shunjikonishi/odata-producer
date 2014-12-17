package jp.co.flect.odatasample.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jp.co.flect.odatasample.entities.Car;

public class JPATestServlet extends HttpServlet {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		EntityManager em = emf.createEntityManager();
		Car car = em.find(Car.class, 1);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(car.getCar_name() + ": " + car.getMaker().getMaker_name());
	}
}


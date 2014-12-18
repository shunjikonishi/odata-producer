package jp.co.flect.odatasample.odata;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.HashMap;

public class EntityManagerFactoryHolder {

	public static final String PUNIT_NAME = "defaultPersistenceUnit";
	private static final EntityManagerFactory INSTANCE;

	static {
		String strUri = System.getenv("DATABASE_URL");
		if (strUri == null) {
			throw new IllegalStateException("DATABASE_URL not found");
		}
		try {
			URI uri = new URI(strUri);
			String host = uri.getHost();
			int port = uri.getPort();
			if (port > 0) {
				host += ":" + port;
			}
			String db = uri.getPath();
			String username = uri.getUserInfo();
			String password = null;
			int idx = username == null ? -1 : username.indexOf(':');
			if (idx != -1) {
				password = username.substring(idx + 1);
				username = username.substring(0, idx);
			}
			String jdbcUrl = "jdbc:postgresql://" + host + db;
			Map<String, String> properties = new HashMap<>();
			properties.put("javax.persistence.jdbc.url", jdbcUrl);
			if (username != null) {
				properties.put("javax.persistence.jdbc.user", username);
			}
			if (password != null) {
				properties.put("javax.persistence.jdbc.password", password);
			}
			INSTANCE = Persistence.createEntityManagerFactory(PUNIT_NAME, properties);
		} catch (URISyntaxException e) {
			throw new IllegalStateException("Can not parse DATABASE_URL: " + strUri);
		}
	}

	public static EntityManagerFactory getInstance() {
		return INSTANCE;
	}
}
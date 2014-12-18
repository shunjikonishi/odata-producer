package jp.co.flect.odataproducer;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.apache.olingo.odata2.jpa.processor.ref.factory.JPAEntityManagerFactory;

import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.processor.ODataErrorCallback;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPAException;

public class MyODataJPAServiceFactory extends ODataJPAServiceFactory {
	private static final String PUNIT_NAME = "defaultPersistenceUnit";
	
	public MyODataJPAServiceFactory() {
		setDetailErrors(true);
	}

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext context = getODataJPAContext();
		context.setEntityManagerFactory(HerokuEntityManagerFactory.getInstance());
		context.setPersistenceUnitName(HerokuEntityManagerFactory.PUNIT_NAME);
		return context;
	}

	@Override
	public <T extends ODataCallback> T getCallback(final Class<? extends ODataCallback> callbackInterface) {
		if (callbackInterface.isAssignableFrom(ODataErrorCallback.class)) {
			return (T) new MyErrorCallback();
		}
		return super.getCallback(callbackInterface);
	}

	public static class MyErrorCallback implements ODataErrorCallback {
		@Override
		public ODataResponse handleError(final ODataErrorContext context) throws ODataApplicationException {
			final String SEPARATOR = " : ";
			Throwable t = context.getException();
			if (t != null) {
				System.out.println("*************** " + t.toString() + " *********************");
				t.printStackTrace();
			} else {
				System.out.println("*************** Unknown error *********************");
			}
			if (t instanceof ODataJPAException && t.getCause() != null) {
				StringBuilder errorBuilder = new StringBuilder();
				errorBuilder.append(t.getCause().getClass().toString());
				errorBuilder.append(SEPARATOR);
				errorBuilder.append(t.getCause().getMessage());
				context.setInnerError(errorBuilder.toString());
			}
			return EntityProvider.writeErrorDocument(context);
		}
	}
}
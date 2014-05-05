package edu.esprit.banque.client.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ServiceLocator {
	private static Context context;
	private static Map<String, Object> cache = new HashMap<String, Object>();
	
	public static Object lookup(String jndiName)

	{
		Object o=null;
		try 
		{
			if (context==null)
			{
			Properties properties = new Properties();
			
			properties.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
			properties.put("java.naming.factory.initial","org.jboss.naming.remote.client.InitialContextFactory");
			properties.put("java.naming.provider.url","remote://localhost:4447");
			properties.put("jboss.naming.client.ejb.context","true");
			properties.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT","false");
		

			context = new InitialContext(properties);
			}
			if (cache.containsKey(jndiName))
			{
			o=context.lookup(jndiName);
			}
			else
			{
				o=context.lookup(jndiName);
				cache.put(jndiName, o);	
			}
			}
		
		catch (NamingException e)
		{
			e.printStackTrace();
		}
		
		return o;
		}
		
		
	
}

/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfiguration {
	@Autowired
	private ApplicationConfiguration configuration;
	
  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		if ("production".equalsIgnoreCase(configuration.getEnv())) {
			MongoClient mc = new MongoClient(configuration.getHost(), configuration.getPort());
			
			return new SimpleMongoDbFactory(
				mc, 
				configuration.getDbName(), 
				new UserCredentials(configuration.getDbUser(), configuration.getDbPassword())
			);
		}
		else {
			return new SimpleMongoDbFactory(new MongoClient(), configuration.getDbName());
		}
  }
}


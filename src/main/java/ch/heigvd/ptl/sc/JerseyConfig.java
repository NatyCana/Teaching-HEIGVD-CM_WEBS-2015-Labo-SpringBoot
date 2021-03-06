/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc;

import ch.heigvd.ptl.sc.rest.ActionResource;
import ch.heigvd.ptl.sc.rest.UserResource;
import ch.heigvd.ptl.sc.rest.DataResource;
import ch.heigvd.ptl.sc.rest.IssueResource;
import ch.heigvd.ptl.sc.rest.IssueTypeResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(ObjectMapperProvider.class);
		register(CityEngagementExceptionMapper.class);
		register(DataResource.class);
		register(UserResource.class);
		register(IssueTypeResource.class);
                register(ActionResource.class);
                register(IssueResource.class);
	}
}

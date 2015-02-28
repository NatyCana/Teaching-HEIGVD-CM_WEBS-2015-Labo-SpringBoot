/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc;

import ch.heigvd.ptl.sc.to.ErrorTO;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CityEngagementExceptionMapper implements ExceptionMapper<CityEngagementException>{
	@Override
	public Response toResponse(CityEngagementException exception) {
		return Response.status(exception.getStatus()).entity(new ErrorTO(exception.getMessage())).build();
	}
}

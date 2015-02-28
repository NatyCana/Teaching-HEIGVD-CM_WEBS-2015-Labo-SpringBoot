/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.converter.IssueTypeConverter;
import ch.heigvd.ptl.sc.model.IssueType;

import ch.heigvd.ptl.sc.persistence.IssueTypeRepository;
import ch.heigvd.ptl.sc.to.IssueTypeTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/issueTypes")
public class IssueTypeResource {

    @Autowired
    private IssueTypeRepository issueTypeRepository;
    @Autowired
    private IssueTypeConverter issueTypeConverter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(issueTypeConverter.convertSourceToTarget(issueTypeRepository.findAll())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(IssueTypeTO issueTypeTO) {
        IssueType issueType = issueTypeRepository.save(issueTypeConverter.convertTargetToSource(issueTypeTO));

        return Response.ok(issueTypeConverter.convertSourceToTarget(issueType)).status(201).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        IssueType issueType = issueTypeRepository.findOne(id);

        if (issueType == null) {
            throw new CityEngagementException(404, "Model not found.");
        }

        return Response.ok(issueTypeConverter.convertSourceToTarget(issueType)).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, IssueTypeTO issueTypeTO) {
        IssueType issueType = issueTypeRepository.findOne(id);

        if (issueType == null) {
            throw new CityEngagementException(404, "Model not found.");
        }

        issueTypeConverter.fillSourceFromTarget(issueType, issueTypeTO);

        issueType = issueTypeRepository.save(issueType);

        return Response.ok(issueTypeConverter.convertSourceToTarget(issueType)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        issueTypeRepository.delete(id);
        return Response.ok().status(204).build();
    }
}

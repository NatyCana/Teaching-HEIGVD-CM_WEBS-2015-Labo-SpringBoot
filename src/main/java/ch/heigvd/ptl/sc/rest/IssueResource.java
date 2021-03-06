/*
 * Developped at Heig-VD.ch during the WebService lecture
 * Authors: Natalie Canonica, Maya Jeanmonod
 * Date: 18-feb-2015
 */
package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.converter.IssueConverter;
import ch.heigvd.ptl.sc.model.Action;
import ch.heigvd.ptl.sc.model.Issue;
import ch.heigvd.ptl.sc.model.IssueType;
import ch.heigvd.ptl.sc.model.User;
import ch.heigvd.ptl.sc.persistence.ActionRepository;
import ch.heigvd.ptl.sc.persistence.IssueRepository;
import ch.heigvd.ptl.sc.persistence.IssueTypeRepository;
import ch.heigvd.ptl.sc.persistence.UserRepository;
import ch.heigvd.ptl.sc.to.IssueTO;
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
@Path("/issues")
public class IssueResource {

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private IssueTypeRepository issueTypeRepository;
    @Autowired
    private IssueConverter issueConverter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(issueConverter.convertSourceToTarget(issueRepository.findAll())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(IssueTO issueTO) {
        User user = userRepository.findOne(issueTO.getAuthorId());
        IssueType issueType = issueTypeRepository.findOne(issueTO.getTypeId());
        Action action = actionRepository.findOne(issueTO.getActionId());

        Issue issue = issueRepository.save(issueConverter.convertTargetToSource(issueTO));

        issue.setAuthor(user);
        issue.setType(issueType);
        issue.setAction(action);
        issueRepository.save(issue);

        return Response.ok(issueConverter.convertSourceToTarget(issue)).status(201).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        Issue issue = issueRepository.findOne(id);

        if (issue == null) {
            throw new CityEngagementException(404, "Model not found.");
        }

        return Response.ok(issueConverter.convertSourceToTarget(issue)).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") String id, IssueTO issueTO) {
        Issue issue = issueRepository.findOne(id);

        if (issue == null) {
            throw new CityEngagementException(404, "Model not found.");
        }

        issueConverter.fillSourceFromTarget(issue, issueTO);

        issue = issueRepository.save(issue);

        return Response.ok(issueConverter.convertSourceToTarget(issue)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        issueRepository.delete(id);
        return Response.ok().status(204).build();
    }
}

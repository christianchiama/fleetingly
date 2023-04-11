package org.fleetingly.user;

import org.fleetingly.user.domain.UserDetails;
import org.fleetingly.user.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @Inject
    UserDetailsRepository repository;

    @POST
    public UserDetails add(@Valid UserDetails UserDetails) {
        LOGGER.info("UserDetails add: {}", UserDetails);
        return repository.add(UserDetails);
    }

    @Path("/{id}")
    @GET
    public UserDetails findById(@PathParam("id") Long id) {
        LOGGER.info("UserDetails find: id={}", id);
        return repository.findById(id);
    }

    @GET
    public Set<UserDetails> findAll() {
        LOGGER.info("UserDetails find");
        return repository.findAll();
    }

}

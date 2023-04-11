package org.fleetingly.auth;

import org.fleetingly.auth.domain.UserDetails;
import org.fleetingly.auth.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationResource.class);

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

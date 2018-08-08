package com.taoxiaopang.rest.server.user;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/api/v1.0/user")
public interface UserService {

    @POST
    @Path("/email")
    @Consumes("application/json")
    @Produces("application/json, text/plain")
    public Response createUser(@Valid @NotNull RegisterRequest regMsg);

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json, text/plain")
    public Response userLogin(@Valid @NotNull LoginRequest loginMsg);

    @POST
    @Path("/logout")
    @Produces("application/json, text/plain")
    public Response userLogout(@HeaderParam("userId") int userId);

}

package com.taoxiaopang.rest.server.user;

import javax.ws.rs.core.Response;

public class UserServiceImpl implements UserService {

    @Override
    public Response createUser(RegisterRequest regMsg) {
        return Response.ok("Create user successfully.").build();
    }

    @Override
    public Response userLogin(LoginRequest loginMsg) {
        return Response.ok("User login successfully.").build();
    }

    @Override
    public Response userLogout(int userId) {
        return Response.ok("User logout successfully.").build();
    }

}

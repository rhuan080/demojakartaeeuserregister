package net.rhuanrocha.democadastrousuario.resources;

import net.rhuanrocha.democadastrousuario.business.UserBusiness;
import net.rhuanrocha.democadastrousuario.dtos.UserInDto;
import net.rhuanrocha.democadastrousuario.dtos.UserOutDto;
import net.rhuanrocha.democadastrousuario.entities.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("users")
public class UserEndpoint {

    @Inject
    private UserBusiness userBusiness;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response
                .ok(
                        userBusiness.findAll()
                                .stream()
                                .map(UserOutDto::of)
                                .collect(Collectors.toList())

                )
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        Optional<User> user = userBusiness.findById(id);
        if(!user.isPresent()){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

        return Response
                .ok(UserOutDto.of(user.get()))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid UserInDto userInDto){
        User user = userInDto.toEntity();
        userBusiness.save(user);
        return Response
                .created(URI.create(String.format("/users/%d",user.getId())))
                .build();
    }
}

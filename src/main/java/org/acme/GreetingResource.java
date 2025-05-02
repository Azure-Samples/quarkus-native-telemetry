package org.acme;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    EntityManager manager;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String hello() {
        MyEntity o = new MyEntity();
        o.field = "data to store";
        manager.persist(o);
        return "Hello from Quarkus REST";
    }
}

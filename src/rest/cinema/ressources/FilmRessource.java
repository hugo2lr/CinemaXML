package rest.cinema.ressources;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.todo.dao.TodoDao;
import rest.todo.model.Todo;

public class FilmRessource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public CinemaResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Film getFilm() {
        Film film = TodoDao.instance.getModel().get(id);
        if(todo==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return todo;
    }
}

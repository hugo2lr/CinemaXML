package rest.cinema.ressources;

//JAX RS

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import rest.cinema.dao.FilmDao;
import rest.cinema.model.Film;

public class FilmRessource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public FilmRessource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Film getFilm() {
        Film film = FilmDao.instance.getModel().get(id);
        if(film==null)
            throw new RuntimeException("Get: Film with " + id +  " not found");
        return film;
    }
    
 // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Film getFilmHTML() {
        Film film = FilmDao.instance.getModel().get(id);
        if(film==null)
            throw new RuntimeException("Get: Film with " + id +  " not found");
        return film;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putFilm(JAXBElement<Film> film) {
        Film c = film.getValue();
        return putAndGetResponse(c);
    }
    
    @DELETE
    public void deleteFilm() {
        Film c = FilmDao.instance.getModel().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: Film with " + id +  " not found");
    }

    private Response putAndGetResponse(Film film) {
        Response res;
        if(FilmDao.instance.getModel().containsKey(film.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        FilmDao.instance.getModel().put(film.getId(), film);
        return res;
    }
}

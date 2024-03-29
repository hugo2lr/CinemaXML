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

import rest.cinema.dao.MovieDao;
import rest.cinema.model.Movie;

public class MovieRessource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public MovieRessource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Movie getMovie() {
        Movie movie = MovieDao.instance.getModel().get(id);
        if(movie==null)
            throw new RuntimeException("Get: Movie with " + id +  " not found");
        return movie;
    }
    
 // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Movie getMovieHTML() {
        Movie movie = MovieDao.instance.getModel().get(id);
        if(movie==null)
            throw new RuntimeException("Get: Movie with " + id +  " not found");
        return movie;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putMovie(JAXBElement<Movie> movie) {
        Movie c = movie.getValue();
        return putAndGetResponse(c);
    }
    
    @DELETE
    public void deleteMovie() {
        Movie c = MovieDao.instance.getModel().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: Movie with " + id +  " not found");
    }

    private Response putAndGetResponse(Movie movie) {
        Response res;
        if(MovieDao.instance.getModel().containsKey(movie.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        MovieDao.instance.getModel().put(movie.getId(), movie);
        return res;
    }
}

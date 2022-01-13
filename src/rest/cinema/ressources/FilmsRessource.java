package rest.cinema.ressources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.cinema.dao.FilmDao;
import rest.cinema.model.Film;


/// Will map the resource to the URL films
@Path("/films")
public class FilmsRessource {
	// Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of films to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Film> getFilmsBrowser() {
        List<Film> films = new ArrayList<Film>();
        films.addAll(FilmDao.instance.getModel().values());
        return films;
    }

    // Return the list of films for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Film> getFilms() {
        List<Film> films = new ArrayList<Film>();
        films.addAll(FilmDao.instance.getModel().values());
        return films;
    }

    // returns the number of films
    // Use http://localhost:8080/com.vogella.jersey.film/rest/films/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = FilmDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newFilm(@FormParam("id") String id,
            @FormParam("summary") String summary,
            @FormParam("description") String description,
            @Context HttpServletResponse servletResponse) throws IOException {
        Film film = new Film(id, summary);
        if (description != null) {
            film.setDescription(description);
        }
        FilmDao.instance.getModel().put(id, film);

        servletResponse.sendRedirect("../create_film.html");
    }

    // Defines that the next path parameter after films is
    // treated as a parameter and passed to the FilmResources
    // Allows to type http://localhost:8080/rest.film/rest/films/1
    // 1 will be treaded as parameter film and passed to FilmResource
    @Path("{film}")
    public FilmRessource getFilm(@PathParam("film") String id) {
        return new FilmRessource(uriInfo, request, id);
    }
}

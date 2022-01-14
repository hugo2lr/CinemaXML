package rest.cinema.dao;

import java.util.HashMap;
import java.util.Map;

import rest.cinema.model.Movie;

public enum MovieDao {
	instance;

    private Map<String, Movie> contentProvider = new HashMap<>();

    private MovieDao() {
        Movie movie = new Movie("1", "nom");
        contentProvider.put("1", movie);
    }
    
    public Map<String, Movie> getModel(){
        return contentProvider;
    }

}

package rest.cinema.dao;

import java.util.HashMap;
import java.util.Map;

import rest.cinema.model.Film;

public enum FilmDao {
	instance;

    private Map<String, Film> contentProvider = new HashMap<>();

    private FilmDao() {
        Film film = new Film("1", "nom");
        contentProvider.put("1", film);
    }
    
    public Map<String, Film> getModel(){
        return contentProvider;
    }

}

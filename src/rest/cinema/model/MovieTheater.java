package rest.cinema.model;

import java.util.ArrayList;

public class MovieTheater {
	private int id;
	private String name;
	private String city;
	private String street;
	private int zipCode;
	private ArrayList<Movie> listMovies;
	
	public MovieTheater() {}

	public MovieTheater(int id, String name, String city, String street, int zipCode) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		ArrayList<Movie> listMovies = new ArrayList<>();
	}
	
	public String getCity() {
		return this.city;
	}
	
	public int getId() {
		return this.id;
	}
	
	public ArrayList<Movie> getListMovies() {
		return listMovies;
	}
	
	public void addMovie(Movie m) {
		this.listMovies.add(m);
	}
	
	public void deleteMovie(Movie m) {
		this.listMovies.remove(m);
	}
	
	public void readMovie() {
		for (Movie m : this.listMovies) 
			System.out.println(m.toString());
	}

}

package rest.cinema.model;

public class MovieTheater {
	private int id;
	private String name;
	private String city;
	private String street;
	private int zipCode;
	private ArrayList<Movie> listMovies;

	public MovieTheater(int id, String name, String city, String street, int zipCode) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		ArrayList<Movie> listMovies = new ArrayList<>();
	}
	
	public Movie getListMovies() {
		return listMovies;
	}

}

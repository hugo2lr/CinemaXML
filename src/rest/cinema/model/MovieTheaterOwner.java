package rest.cinema.model;

public class MovieTheaterOwner {

	private int id;
	private String login;
	private String password;
	private ArrayList<Movie> lm;
	private Movie m;
	
	public MovieTheaterOwner(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
		ArrayList<Movie> lm = new ArrayList<>();
		Movie m = new Movie();
	}
	
	public void addMovie() {
		lm.add(m);
	}
	
	public void deleteMovie() {
		lm.remove(m);
	}
	
	public Movie readMovie() {
		for (m : lm) 
			return Movie m;
	}

}

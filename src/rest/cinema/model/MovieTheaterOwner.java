package rest.cinema.model;

import java.util.ArrayList;

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

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<Movie> getLm() {
		return lm;
	}

	public Movie getM() {
		return m;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLm(ArrayList<Movie> lm) {
		this.lm = lm;
	}

	public void setM(Movie m) {
		this.m = m;
	}
	
	

}

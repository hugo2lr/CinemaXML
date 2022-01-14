package rest.cinema.model;

import java.util.Date;

public class Session {
	private int id;
	private Date date;
	private String startHour;
	private String endHour;
	private MovieTheater address;
	
	public Session() {}
	
	public Session(int id, Date d, String sH, String eH) {
		this.id = id;
		this.date = d;
		this.startHour = sH;
		this.endHour = eH;
		MovieTheater address = new MovieTheater();
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public String getStartHour() {
		return startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public MovieTheater getAddress() {
		return address;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public void setAddress(MovieTheater address) {
		this.address = address;
	}
	
	

}

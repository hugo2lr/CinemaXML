package rest.cinema.model;
 
public class Session {
	private int id;
	private Date date;
	private String startHour;
	private String endHour;
	private MovieTheater address;
	
	public Session(int id, Date d, String sH, String eH) {
		this.id = id;
		this.date = d;
		this.startHour = sH;
		this.endHour = eH;
		MovieTheater address = new MovieTheater();
	}
	

}

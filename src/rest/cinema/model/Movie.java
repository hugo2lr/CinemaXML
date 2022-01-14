/**

 * 
 */

package rest.cinema.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Hugo
 *
 */
public class Movie {
	private int id;
	private String title;
	private int duration;
	private boolean subtitles;
	private String director;
	private ArrayList<String> mainActors;
	private int minAge;
	private Date startDate;
	private Date endDate;
	private String language;
	
	public Movie() {}
	
	// Without subtitles
	public Movie(int i, String t, int d, String director, Date sD, Date eD) {
		this.subtitles = false;
		this.id = i;
		this.title = t;
		this.duration = d;
		this.director = director;
		this.mainActors = new ArrayList<String>();
		this.startDate = sD;
		this.endDate = eD;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", duration=" + duration + ", subtitles=" + subtitles
				+ ", director=" + director + ", mainActors=" + mainActors + ", minAge=" + minAge + ", startDate="
				+ startDate + ", endDate=" + endDate + ", language=" + language + "]";
	}

	// With subtitles
	public Movie(int i, String t, int d, boolean s, String director, Date sD, Date eD) {
		this.id = i;
		this.title = t;
		this.duration = d;
		this.subtitles = s;
		this.director = director;
		this.mainActors = new ArrayList<String>();
		this.startDate = sD;
		this.endDate = eD;
	}

	public Movie(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setSubtitles(boolean subtitles) {
		this.subtitles = subtitles;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setMainActors(ArrayList<String> mainActors) {
		this.mainActors = mainActors;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}
	
		

}

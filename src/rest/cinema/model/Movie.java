/**

 * 
 */
package rest.cinema.model;

/**
 * @author Hugo
 *
 */
public class Film {
	private int id;
	private String title;
	private int duration;
	private boolean subtitles;
	private String director;
	private ArrayList<String> mainActors;
	private int minAge;
	private Date startDate;
	private Date endDate;
	
	public Film(int i, String t, int d, boolean s, String director, int mA, Date sD, Date eD) {
		this.id = i;
		this.title = t;
		this.duration = d;
		this.subtitles = s;
		this.director = director;
		this.mainActors = mA;
		this.startDate = sD;
		this.endDate = eD;
	}
	
	public void setSubtitles(boolean subtitles) {
		
	}

}

package org.benfarhat.movie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Benfarhat Elyes
 *
 */
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    @NotNull
    @Size(max = 100)
	private String title;
	private int year;
	private int duration;
	@ManyToMany(mappedBy="movies")
	private List<Genre> genres;
	private String director;
	@ManyToMany(mappedBy="movies")
	private List<Actor> actors;
	private String imageUrl;
	
	public Movie() {
		super();
	}

	/**
	 * @param title
	 * @param year
	 * @param duration
	 * @param genres
	 * @param director
	 * @param actors
	 * @param imageUrl
	 */
	public Movie(String title, int year, int duration, List<Genre> genres, String director, List<Actor> actors,
			String imageUrl) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.genres = genres;
		this.director = director;
		this.actors = actors;
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the genres
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the actors
	 */
	public List<Actor> getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", duration=" + duration + ", genres="
				+ genres + ", director=" + director + ", actors=" + actors + ", imageUrl=" + imageUrl + "]";
	}
	
}

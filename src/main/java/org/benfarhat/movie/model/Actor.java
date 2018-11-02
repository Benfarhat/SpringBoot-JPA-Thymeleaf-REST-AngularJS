package org.benfarhat.movie.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.benfarhat.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Benfarhat Elyes
 *
 */
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private Date birthDate;
	private String birthPlace;
	
	/**
	 * @return the movies
	 */
	@Autowired
	public List<Movie> getMovies(MovieRepository movieRepository) {
		
		return movieRepository.findAll().stream()
				.filter(x -> x.getActors().contains(this))
				.collect(Collectors.toList());	
	}
	/**
	 * @param movies the movies to set
	 */
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	@ManyToMany
	private List<Movie> movies;
	
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param birthDate
	 * @param birthPlace
	 */
	public Actor(String name, Date birthDate, String birthPlace) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace + "]";
	}
	
}

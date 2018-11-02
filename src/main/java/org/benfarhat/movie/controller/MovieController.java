package org.benfarhat.movie.controller;

import java.util.List;

import org.benfarhat.movie.model.Movie;
import org.benfarhat.movie.repository.MovieRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
@Api(
		name="Filmotheque API", 
		description = "Some restful method to manage movies", 
		stage = ApiStage.RC)
public class MovieController {

	private MovieRepository movieRepository;

	/**
	 * @param movieRepository
	 */
	@Autowired
	public MovieController(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	public MovieController() {
		super();
	}


	@RequestMapping(value = "/all", method = RequestMethod.GET)
	// @GetMapping("/all") // Did'nt work with JSONDoc
	@ApiMethod(description = "Retrieve all movies from the database")
	public List<Movie> getAll(){
		return movieRepository.findAll();
	}	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ApiMethod(description = "Display movies containing request param provided")
	public List<Movie> getMovieContaining(@ApiPathParam(name = "name") @RequestParam("name") String name){
		return movieRepository.findByTitleContaining(name);
	}
	
	@RequestMapping(value="/year/{year}", method=RequestMethod.GET)
	@ApiMethod(description = "Get movie produced at the provided year value")
	public List<Movie> getByYear(@ApiPathParam(name = "year") @PathVariable int year){
		/*
		return movieRepository.findAll().stream()
				.filter(x -> x.getYear() = year)
				.collect(Collectors.toList());	
		*/
		return movieRepository.findByYear(year);
	}
	
	@PostMapping("/create")
	@ApiMethod(description = "Create a hotel booking and save it to the database")
	public List<Movie> create(@RequestBody Movie hotelBooking){
		movieRepository.save(hotelBooking);
		return movieRepository.findAll();
	}
	
	@PostMapping("/delete/{id}")
	@ApiMethod(description = "Remove a movie with the provided ID, from the database")
	public List<Movie> create(@ApiPathParam(name = "id") @PathVariable Long id){	
		if(movieRepository.existsById(id))
			movieRepository.deleteById(id);
		return movieRepository.findAll();
	}
	
}

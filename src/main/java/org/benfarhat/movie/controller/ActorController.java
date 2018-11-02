package org.benfarhat.movie.controller;

import java.util.List;

import org.benfarhat.movie.model.Actor;
import org.benfarhat.movie.model.Movie;
import org.benfarhat.movie.repository.ActorRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/actors")
@Api(
		name="Filmotheque API", 
		description = "Some restful method to manage actors", 
		stage = ApiStage.RC)
public class ActorController {

	private ActorRepository actorRepository;

	/**
	 * @param actorRepository
	 */
	@Autowired
	public ActorController(ActorRepository actorRepository) {
		super();
		this.actorRepository = actorRepository;
	}

	public ActorController() {
		super();
	}


	@RequestMapping(value = "/all", method = RequestMethod.GET)
	// @GetMapping("/all") // Did'nt work with JSONDoc
	@ApiMethod(description = "Retrieve all actors from the database")
	public List<Actor> getAll(){
		return actorRepository.findAll();
	}	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ApiMethod(description = "Display movies containing request param provided")
	public List<Actor> getActorNameContaining(@ApiPathParam(name = "name") @RequestParam("name") String name){
		return actorRepository.findByNameContaining(name);
	}
	
	
}

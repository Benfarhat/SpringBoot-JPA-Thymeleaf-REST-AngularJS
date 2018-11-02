package org.benfarhat.movie.repository;

import java.util.List;

import org.benfarhat.movie.model.Actor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Benfarhat Elyes
 *
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{

    @Cacheable("actors")
	List<Actor> findByName(String actorName);
    @Cacheable("actors")
	List<Actor> findByNameContaining(String partialActorName);
}

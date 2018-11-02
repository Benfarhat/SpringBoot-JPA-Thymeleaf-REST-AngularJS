package org.benfarhat.movie.repository;

import java.util.List;

import org.benfarhat.movie.model.Movie;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
    @Cacheable("movies")
	List<Movie> findByTitleContaining(String title);
    @Cacheable("movies")
	List<Movie> findByYear(int year);

}
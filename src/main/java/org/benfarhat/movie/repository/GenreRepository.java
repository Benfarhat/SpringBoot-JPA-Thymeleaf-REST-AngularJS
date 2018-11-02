package org.benfarhat.movie.repository;

import java.util.List;

import org.benfarhat.movie.model.Genre;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Benfarhat Elyes
 *
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

    @Cacheable("genres")
	List<Genre> findByName(String genreName);
    @Cacheable("genres")
	List<Genre> findByNameContaining(String partialGenreName);

}

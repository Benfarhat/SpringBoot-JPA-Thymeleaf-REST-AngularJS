package org.benfarhat.movie.runner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.benfarhat.movie.model.Actor;
import org.benfarhat.movie.model.Genre;
import org.benfarhat.movie.model.Movie;
import org.benfarhat.movie.repository.ActorRepository;
import org.benfarhat.movie.repository.GenreRepository;
import org.benfarhat.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner{
	private MovieRepository movieRep;
	private ActorRepository actorRep;
	private GenreRepository genreRep;
	
	/**
	 * @param movieRep
	 * @param actorRep
	 * @param genreRep
	 */
	@Autowired
	public DatabaseSeeder(MovieRepository movieRep, ActorRepository actorRep, GenreRepository genreRep) {
		super();
		this.movieRep = movieRep;
		this.actorRep = actorRep;
		this.genreRep = genreRep;
	}



	@Override
	public void run(String... args) throws Exception {
		List<Actor> actors = new ArrayList<>();
		List<Genre> genres = new ArrayList<>();
		List<Movie> movies = new ArrayList<>();
		
		/* Add some actors */
		String pattern = "dd/MM/YYYY";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		actors.add(new Actor("Rama Dillard",simpleDateFormat.parse("23/08/1980"),"Macao"));		
		actors.add(new Actor("Vincent Obrien",simpleDateFormat.parse("06/08/1995"),"Tonga"));
		actors.add(new Actor("Bert Rosario",simpleDateFormat.parse("17/01/1997"),"Suriname"));
		actors.add(new Actor("Shay Wolfe",simpleDateFormat.parse("17/09/1986"),"Marshall Islands"));
		actors.add(new Actor("Maite Hood",simpleDateFormat.parse("16/03/1994"),"United States"));
		actors.add(new Actor("Leonard Tyler",simpleDateFormat.parse("27/07/1995"),"Ethiopia"));
		actors.add(new Actor("Basil Chan",simpleDateFormat.parse("02/04/1981"),"New Zealand"));
		actors.add(new Actor("Liberty Hardy",simpleDateFormat.parse("12/05/1988"),"Lesotho"));
		actors.add(new Actor("Helen Carlson",simpleDateFormat.parse("30/11/1996"),"United States"));
		actors.add(new Actor("Bianca Chan",simpleDateFormat.parse("13/05/2001"),"Svalbard and Jan Mayen Islands"));
		actors.add(new Actor("Micah Padilla",simpleDateFormat.parse("27/04/1990"),"Belarus"));
		actors.add(new Actor("Rajah Randall",simpleDateFormat.parse("13/03/1998"),"Tanzania"));
		actors.add(new Actor("Iola Hammond",simpleDateFormat.parse("15/08/1983"),"Pitcairn Islands"));
		actors.add(new Actor("Trevor Chavez",simpleDateFormat.parse("21/06/1979"),"Libya"));
		actors.add(new Actor("Tyrone Carter",simpleDateFormat.parse("05/03/1984"),"Germany"));
		actors.add(new Actor("Kiara Cain",simpleDateFormat.parse("11/01/2000"),"Algeria"));
		actors.add(new Actor("Basil White",simpleDateFormat.parse("17/09/1977"),"Sao Tome and Principe"));
		actors.add(new Actor("Olga Weber",simpleDateFormat.parse("19/01/1985"),"Korea, North"));
		actors.add(new Actor("Jayme Rivas",simpleDateFormat.parse("15/10/1976"),"Egypt"));
		actors.add(new Actor("Angela Deleon",simpleDateFormat.parse("20/10/1991"),"Lesotho"));
		actorRep.saveAll(actors);

		/* Add some genres */
		genres.add(new Genre("Action"));
		genres.add(new Genre("Romance"));
		genres.add(new Genre("Science"));
		genres.add(new Genre("Fantasy"));
		genres.add(new Genre("Children"));
		genres.add(new Genre("Horror"));
		genres.add(new Genre("Western"));
		genres.add(new Genre("Biography"));
		genres.add(new Genre("Thriller"));
		genres.add(new Genre("Adventure"));
		genreRep.saveAll(genres);
		
		/*Add some films */
		movies.add(new Movie("Avatar",2009,162,genreRep.findByNameContaining("a"),"James Cameron", actorRep.findByNameContaining("a"),"http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg"));
		movies.add(new Movie("I am a legend",2007,101,genreRep.findByNameContaining("b"),"Francis Lawrence", actorRep.findByNameContaining("b"),"http://ia.media-imdb.com/images/M/MV5BMTU4NzMyNDk1OV5BMl5BanBnXkFtZTcwOTEwMzU1MQ@@._V1_SX300.jpg"));
		movies.add(new Movie("300",2006,117,genreRep.findByNameContaining("c"),"Zack Snyder", actorRep.findByNameContaining("c"),"http://ia.media-imdb.com/images/M/MV5BMjAzNTkzNjcxNl5BMl5BanBnXkFtZTYwNDA4NjE3._V1_SX300.jpg"));
		movies.add(new Movie("The Avengers",2012,143,genreRep.findByNameContaining("d"),"Joss Whedon", actorRep.findByNameContaining("d"),"http://ia.media-imdb.com/images/M/MV5BMTk2NTI1MTU4N15BMl5BanBnXkFtZTcwODg0OTY0Nw@@._V1_SX300.jpg"));
		movies.add(new Movie("The Wolf of Wall Street",2013,180,genreRep.findByNameContaining("e"),"Martin Scorsese", actorRep.findByNameContaining("e"),"https://ia.media-imdb.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_SX300.jpg"));
		movies.add(new Movie("Interstellar",2014,169,genreRep.findByNameContaining("f"),"Christopher Nolan", actorRep.findByNameContaining("f"),"http://ia.media-imdb.com/images/M/MV5BMTY2MjMwNDE4OV5BMl5BanBnXkFtZTgwNjI1NjU0OTE@._V1_SX300.jpg"));
		movies.add(new Movie("Gotham",2014,42,genreRep.findByNameContaining("g"),"JBruno Heller", actorRep.findByNameContaining("g"),"http://ia.media-imdb.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg"));
		movies.add(new Movie("Doctor Strange",2016,116,genreRep.findByNameContaining("h"),"Scott Derrickson", actorRep.findByNameContaining("h"),"http://ia.media-imdb.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_SX300.jpg"));
		movieRep.saveAll(movies);
	}
	

}


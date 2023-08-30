package com.lookup.lookup.movies;

import com.lookup.lookup.BaseCrudController;
import com.lookup.lookup.BaseResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesResource extends BaseCrudController<MoviesResource.Movie> {

    @Override
    public void init() {
        super.setItems(Arrays.asList(new Movie(1, "Doctors Appointment", "Feb 5th at 2:30pm", "It is a period of civil war. Rebel spaceships, striking from a hidden base, have won their first victory against the evil Galactic Empire. During the battle, Rebel spies managed to steal secret plans to the Empire's ultimate weapon, the DEATH STAR, an armored space station with enough power to destroy an entire planet. Pursued by the Empire's sinister agents, Princess Leia races home aboard her starship, custodian of the stolen plans that can save her people and restore freedom to the galaxy"),
                new Movie(2, "Meeting at School", "Feb 6th at 2:30pm", "It is a dark time for the Rebellion. Although the Death Star has been destroyed, Imperial troops have driven the Rebel forces from their hidden base and pursued them across the galaxy. Evading the dreaded Imperial Starfleet, a group of freedom fighters led by Luke Skywalker has established a new secret base on the remote ice world of Hoth. The evil lord Darth Vader, obsessed with finding young Skywalker, has dispatched thousands of remote probes into the far reaches of space...."),
                new Movie(3, "Food Shopping", "Feb 7th at 2:30pm", "Luke Skywalker has returned to his home planet of Tatooine in an attempt to rescue his friend Han Solo from the clutches of the vile gangster Jabba the Hutt. Little does Luke know that the GALACTIC EMPIRE has secretly begun construction on a new armored space station even more powerful than the first dreaded Death Star. When completed, this ultimate weapon will spell certain doom for the small band of rebels struggling to restore freedom to the galaxy...")));
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovies() {
        return getItems();
    }

    @GetMapping(path = "/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovie(@PathVariable("movieId") long movieId) {
        return getItem(movieId);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie createMovie(@RequestBody Movie movie) {
        return addItem(movie);
    }

    @DeleteMapping("/{movieId}")
    public List<Movie> deleteMovie(@PathVariable("movieId") int movieId) {
        return deleteItem(movieId);
    }

    @PutMapping(value = "/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return merge(movieId, movie);
    }


    static class Movie extends BaseResponse<Movie> {

        private String title;
        private String openingText;
        private String releaseDate;

        public Movie() {

        }

        public Movie(long id, String title, String releaseDate, String openingText) {
            setId(id);
            this.title = title;
            this.releaseDate = releaseDate;
            this.openingText = openingText;
        }

        @Override
        public Movie copy(Movie movie) {
            this.title = movie.title;
            this.releaseDate = movie.releaseDate;
            this.openingText = movie.openingText;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOpeningText() {
            return openingText;
        }

        public void setOpeningText(String openingText) {
            this.openingText = openingText;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
    }
}

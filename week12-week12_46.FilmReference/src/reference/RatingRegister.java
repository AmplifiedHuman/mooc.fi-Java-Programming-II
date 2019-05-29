package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class RatingRegister {

    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> peopleRatings;

    public RatingRegister() {
        filmRatings = new HashMap<Film, List<Rating>>();
        peopleRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        List<Rating> tempRating;
        if (!filmRatings.containsKey(film)) {
            tempRating = new ArrayList<Rating>();
            filmRatings.put(film, tempRating);
        } else {
            tempRating = filmRatings.get(film);
        }
        tempRating.add(rating);
    }

    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!peopleRatings.containsKey(person)) {
            peopleRatings.put(person, new HashMap<Film, Rating>());
        }
        addRating(film, rating);
        peopleRatings.get(person).put(film, rating);
    }

    public Rating getRating(Person person, Film film) {
        if (!peopleRatings.get(person).containsKey(film)) {
            return Rating.NOT_WATCHED;
        }
        return peopleRatings.get(person).get(film);
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (!peopleRatings.keySet().contains(person)) {
            return new HashMap<Film, Rating>();
        }
        return peopleRatings.get(person);
    }

    public List<Person> reviewers() {
        return new ArrayList<Person>(peopleRatings.keySet());
    }
}
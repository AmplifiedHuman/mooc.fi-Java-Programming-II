package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class Reference {

    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person person) {
        List<Film> filmList = new ArrayList<Film>(ratingRegister.filmRatings().keySet());
        Film recommendedFilm;

        if (!ratingRegister.reviewers().contains(person)) {
            Collections.sort(filmList, new FilmComparator(ratingRegister.filmRatings()));
            recommendedFilm = filmList.get(0);
        } else {
            recommendedFilm = getFilm(person, getMostSimilarPerson(person));
        }
        return recommendedFilm;
    }

    private Person getMostSimilarPerson(Person person) {
        List<Person> allReviewers = ratingRegister.reviewers();
        Person mostSimilarPerson = null;
        int maxPoints = Integer.MIN_VALUE;
        for (Person reviewer : allReviewers) {
            if (reviewer != person && calculatePoints(reviewer, person) > maxPoints) {
                mostSimilarPerson = reviewer;
                maxPoints = calculatePoints(reviewer, person);
            }
        }
        return mostSimilarPerson;
    }

    private int calculatePoints(Person person1, Person person2) {
        Map<Film, Rating> person1Ratings = ratingRegister.getPersonalRatings(person1);
        Map<Film, Rating> person2Ratings = ratingRegister.getPersonalRatings(person2);

        int points = 0;

        for (Film film : person1Ratings.keySet()) {
            if (person2Ratings.containsKey(film)) {
                points += person1Ratings.get(film).getValue() * person2Ratings.get(film).getValue();
            }
        }
        return points;
    }

    private Film getFilm(Person watcher, Person recommender) {

        Map<Film, Rating> watcherRatings = ratingRegister.getPersonalRatings(watcher);
        Map<Film, Rating> recommenderRatings = ratingRegister.getPersonalRatings(recommender);

        List<Film> notWatched = new ArrayList<Film>();

        for (Film film : recommenderRatings.keySet()) {
            if (!watcherRatings.containsKey(film)) {
                notWatched.add(film);
            }
        }

        int maxPoints = Integer.MIN_VALUE;
        Film recommendedFilm = null;

        for (Film film : notWatched) {
            if (recommenderRatings.get(film).getValue() > maxPoints) {
                maxPoints = recommenderRatings.get(film).getValue();
                recommendedFilm = film;
            }
        }

        return recommendedFilm;

    }
}
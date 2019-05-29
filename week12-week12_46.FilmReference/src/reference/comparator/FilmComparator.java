package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import reference.domain.Film;
import reference.domain.Rating;

public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    public double calculateFilmAverage(Film film) {
        List<Rating> rating = ratings.get(film);
        double sum = 0;
        for (Rating eachRating : rating) {
            sum += eachRating.getValue();
        }
        return sum / rating.size();
    }

    @Override
    public int compare(Film o1, Film o2) {
        double difference = calculateFilmAverage(o2) - calculateFilmAverage(o1);
        return (int) difference;
    }

}
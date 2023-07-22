package 실습7_2_1;

import java.util.Arrays;

public class MovieManagerImpl implements IMovieManager{
    private final int MAX_SIZE = 100;
    private Movie[] movieList = new Movie[MAX_SIZE];
    private int size = 0;

    private static MovieManagerImpl mv = new MovieManagerImpl();

    private MovieManagerImpl(){
    }

    public static MovieManagerImpl getInstance(){
        return mv;
    }

    @Override
    public void add(Movie movie) {
        if (size < MAX_SIZE) {
            movieList[size++] = movie;
        } else {
            System.out.println("영화의 수가 100을 넘었습니다. 등록 불가.");
        }
    }

    @Override
    public Movie[] getList() {
        return Arrays.copyOfRange(movieList, 0, size);
    }

    @Override
    public Movie[] searchByTitle(String title) {
        int cnt = 0;

        for (int i = 0; i < this.size; i++) {
            if (movieList[i].getTitle().contains(title)) {
                cnt++;
            }
        }

        if (cnt == 0) return null;

        Movie[] res = new Movie[cnt];

        for (int i = 0, index = 0; i < this.size; i++) {
            if (movieList[i].getTitle().contains(title)) {
                res[index++] = movieList[i];
            }
        }

        return res;
    }

    @Override
    public Movie[] getMovies() {
        int cnt = 0;

        for (int i = 0; i < this.size; i++) {
            if (!(movieList[i] instanceof SeriesMovie)) {
                cnt++;
            }
        }

        if (cnt == 0) {
            return null;
        }

        Movie[] res = new Movie[cnt];

        for (int i = 0, index = 0; i < this.size; i++) {
            if (!(movieList[i] instanceof SeriesMovie)) {
                res[index++] = movieList[i];
            }
        }

        return res;
    }

    @Override
    public SeriesMovie[] getSeriesMovies() {
        int cnt = 0;

        for (int i = 0; i < this.size; i++) {
            if (movieList[i] instanceof SeriesMovie) {
                cnt++;
            }
        }

        if (cnt == 0) {
            return null;
        }

        SeriesMovie[] res = new SeriesMovie[cnt];

        for (int i = 0, index = 0; i < this.size; i++) {
            if (movieList[i] instanceof SeriesMovie) {
                res[index++] = (SeriesMovie) movieList[i];
            }
        }

        return res;
    }

    @Override
    public double getRunningTimeAvg() {
        int run = 0;

        for (int i = 0; i < this.size; i++) {
            run += movieList[i].getRunningTime();
        }
        return run / this.size;
    }
}

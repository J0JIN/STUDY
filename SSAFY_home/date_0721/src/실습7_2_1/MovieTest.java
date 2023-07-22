package 실습7_2_1;

import java.util.Arrays;

public class MovieTest {
    public static void main(String[] args) {
        Movie m1 = new Movie(1, "영화1", "봉주노", "코믹", 20);
        Movie m2 = new Movie(1, "영화2", "봉주르", "공포", 23);
        SeriesMovie s1 = new SeriesMovie(1, "시리즈1", "노봉방주", "스릴러", 10, 3, "1");
        MovieManagerImpl mv = MovieManagerImpl.getInstance();
//        MovieManagerImpl mv2 = MovieManagerImpl.getInstance();

        mv.add(m1);
        mv.add(m2);
        mv.add(s1);

        System.out.println(Arrays.toString(mv.searchByTitle("영화1")));
        System.out.println(Arrays.toString(mv.getMovies()));
        System.out.println(Arrays.toString(mv.getList()));
        System.out.println(mv.getRunningTimeAvg());

//        System.out.println(um.equals(um2));
    }
}

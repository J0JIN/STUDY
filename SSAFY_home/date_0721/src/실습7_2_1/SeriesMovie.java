package 실습7_2_1;

public class SeriesMovie extends Movie{

    private int seriesNum;

    private String episode;


    public SeriesMovie(){
    }

    public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
        super(id, title, director, genre, runningTime);
        this.seriesNum = seriesNum;
        this.episode = episode;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public int getSeriesNum() {
        return seriesNum;
    }

    public void setSeriesNum(int seriesNum) {
        this.seriesNum = seriesNum;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + super.getId() +
                ", title='" + super.getTitle() + '\'' +
                ", director='" + super.getDirector() + '\'' +
                ", genre='" + super.getGenre() + '\'' +
                ", runningTime=" + super.getRunningTime() + '\'' +
                ", seriesNum=" + seriesNum + '\'' +
                ", episode='" + episode + '\'' +
                '}';
    }
}

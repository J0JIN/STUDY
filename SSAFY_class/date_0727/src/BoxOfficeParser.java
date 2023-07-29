import java.io.InputStream;
import java.util.List;

public interface BoxOfficeParser {
    public abstract List<BoxOffice> getBoxOffice(InputStream resource);
}

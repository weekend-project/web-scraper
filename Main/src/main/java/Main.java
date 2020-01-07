import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

// using this tutorial https://www.youtube.com/watch?v=tI1qGwhn_bs
public class Main {
    public static void main(String[] args) throws IOException {

        final String url = "https://www.kingarthurflour.com/learn/ingredient-weight-chart";
        final Document doc = Jsoup.connect(url).get();
        for (Element row : doc.select("div.brick--text__inner tr")) { // unable to find table class ID (https://www.youtube.com/watch?v=tI1qGwhn_bs&t=467s)
            if (row.select("tr:nth-of-type(1)").text().equals("")) {
                break;
            } else {
                final String ingredient = row.select("tr:nth-of-type(1)").text();
                System.out.println(ingredient);
            }
        }
    }
}

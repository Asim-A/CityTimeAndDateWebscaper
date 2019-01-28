package JSoupVersion;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class CityTimeAndDateWebscraper {

    public String getCityTimeAndDate(String city){
        final String url = getCityQuery(city);

        if(url.isEmpty()) throw new IllegalStateException("Cannot query empty URL");

        try {
            final Document document = Jsoup.connect(url).header("Accept-Language", "en").get();
            Element time = document.getElementById("twd");
            Element date = document.getElementById("dd");
            Element place = document.select("h1").first();

            String timeanddate = place.text()+ " " + date.text() + " " + time.text();

            return timeanddate;

        }
        catch(HttpStatusException hs){
            System.err.println("URL Not found, cannot query.");
        }
        catch(IOException ie){
            ie.printStackTrace();
        }

        return "!!!The city is unknown to me!!!";
    }

    private String getCityQuery(String city){
        city = city.replaceAll(" ", "_");
        String cityQuery = "https://time.is/" + city;

        return cityQuery;
    }

}

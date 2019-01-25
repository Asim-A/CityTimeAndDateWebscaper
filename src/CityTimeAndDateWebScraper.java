import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CityTimeAndDateWebScraper {

    public static void main(String[] args) {
        CityTimeAndDateWebScraper cw = new CityTimeAndDateWebScraper();
        System.out.println(cw.getCityTimeAndDate("New York"));
    }

    public String getCityTimeAndDate(String city){
        final String url = getCityQuery(city);

        if(url.isEmpty()) throw new IllegalStateException("Cannot query empty URL");

        try {
            final Document document = Jsoup.connect(url).get();
            Element time = document.getElementById("twd");
            Element date = document.getElementById("dd");

            String timeanddate = time.text() + " " + date.text();

            return timeanddate;

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return "!!!The city is unknown to me!!!";
    }

    private String getCityQuery(String city){
        city = city.replaceAll(" ", "_");
        String cityQuery = "https://time.is/" + city;

        return cityQuery;
    }

}

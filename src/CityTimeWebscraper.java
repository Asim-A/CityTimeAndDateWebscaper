import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CityTimeWebscraper {

    private String getCityTime(String city){
        final String url = getCityQuery(city);

        if(url.isEmpty()) throw new IllegalStateException("Cannot query empty URL");

        try {
            final Document document = Jsoup.connect(url).get();
            Element ele = document.getElementById("p0");

            System.out.println(ele.text());

            return ele.text();

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return "!!!The city is unknown to me!!!";
    }

    public String getCityQuery(String city){
        city = city.replaceAll(" ", "+");
        String cityQuery = "https://www.timeanddate.com/worldclock/?query=" + city;

        return cityQuery;
    }

}

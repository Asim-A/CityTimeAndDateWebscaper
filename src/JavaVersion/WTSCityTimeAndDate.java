package JavaVersion;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WTSCityTimeAndDate {

    private String fetchCityTimeAndDateHTML(String city){
        String content = null;
        URLConnection connection = null;
        String URL = fetchCityQuery(city);

        try {
            connection =  new URL(URL).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }

        return content;
    }

    private String fetchCityQuery(String city){
        city = city.replaceAll(" ", "%20");
        String cityQuery = "https://www.worldtimeserver.com/search.aspx?searchfor=" + city;

        return cityQuery;
    }

    private String findTimeAndDateHTML(String content){
        Pattern pattern = Pattern.compile("[0-9]{2}:[0-9]{2}:[0-9]{2}");
        Pattern pattern2 = Pattern.compile("<span class=\"font6\">\\r\\n.+</span>");

        Matcher matcher = pattern.matcher(content);
        Matcher matcher2 = pattern2.matcher(content);

        if (matcher.find() && matcher2.find()){
            return matcher.group(0) + " " + cleanHTML(matcher2.group(0)).trim();
        }

        return "!!!The city is unknown to me!!!";
    }

    private String cleanHTML(String input){
        return input.replaceAll("\\<.*?>","");
    }

    public String fetchCityTimeAndDate(String city){
        return findTimeAndDateHTML(fetchCityTimeAndDateHTML(city));
    }
}

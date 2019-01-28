# City Time And Date Webscraper

## Notes
### I have provided two ways to scrape time and date one is using JSoup 1.1.13 and the other one
### is soley using Java SE libraries. The latter was added because my teacher decided to not allow us to
### use non Java SE libraries and because we were limited to only using worldtimeserver/google to fetch data.
### The pure java version of the program fetches a raw HTML document as a String and then the String gets 
### processed using regular expressions (regex) to find relevant data (i.e. time and date). 
### Worldtimeserver has a more limited searching interface so fetching city time and date using the pure java
### program will result in less consistent data. For instance I could not find my own city using worldtimeserver
### whereas using time.is I could. I might add a pure java version using time.is as a supplement.


## Disclaimer
### I will not maintain this code and I do not take any responsibility for any abuse of this code.
### This is for educational purposes only.

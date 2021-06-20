//Using Jsoup to fetch the top 20 stock in terms of turnover

//JSOUP reference https://jsoup.org/cookbook/extracting-data/attributes-text-html

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileWriter;   // Import the FileWriter class

public class JSoupHTMLSourceEx {

    public static void main(String[] args) throws IOException {
        
        // String html = Jsoup.connect(webPage).get().html();
        // System.out.println(html);
        //Document doc = Jsoup.connect("http://www.aastocks.com/en/stocks/quote/quick-quote.aspx?symbol=01143").get();  //stock price get not fetched due to the some measure taken
        
        Document document = Jsoup.connect("http://www.etnet.com.hk/www/eng/stocks/realtime/top20.php?subtype=turnover").get();
        // String text = document.body().text();
        // System.out.println(text);
        Elements rows = document.getElementsByTag("tr");
        int i = 1;
        for (Element row : rows) {
            if(i > 21){
                break;
            }
            i++;
            System.out.println(row.text());
        }
    }
}
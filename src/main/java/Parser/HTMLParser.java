package Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class HTMLParser {
    public static void main(String[] args) throws MalformedURLException, IOException {
        List<String> linkList = new ArrayList<>();
        List<String> linkList2 = new ArrayList<>();

        Document document = Jsoup.parse(new URL("http://megapesni.me/popsa/150196-jarico-fiery-sky.html"),1000);
        Element el = document.body();
        Elements elements = el.getElementsByTag("a");
        for(Element element: elements){
            String href = element.attr("href");
            if (href.contains("/get")){
                linkList.add(href);
            }
        }
        linkList.stream().forEach(System.out::println);

        System.out.println("/****************************/");

        Elements elements2 = el.select("a[href^=/get]");
        for (Element el2: elements2){
            linkList2.add(el2.attr("href"));
        }
        linkList2.stream().forEach(System.out::println);
    }
}

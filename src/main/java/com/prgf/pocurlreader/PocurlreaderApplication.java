package com.prgf.pocurlreader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PocurlreaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocurlreaderApplication.class, args);
        read();
    }

    private static void read() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://en.wikipedia.org/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            System.out.println("%s\n\t%s" +
                    headline.attr("title") + headline.absUrl("href"));
        }
    }
}

package mild.batch;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Crawler {
    public static void main(String[] args) {
        try {
            // 1. 수집 대상 URL
            String URL = "https://www.melon.com/chart/index.htm";

            // 2. Connection 생성
            Connection conn = Jsoup.connect(URL);

            // 3. HTML 파싱
            Document html = conn.get();

            // 4. HTML 출력
            //System.out.println(html.toString());

            // 4. 요소 탐색
            // 4-1. 곡 리스트 탐색
            System.out.println("[Attribute 탐색]");
            Elements songInfos = html.getElementsByClass("song_info");
            for(Element songInfo : songInfos) {
                System.out.println(songInfo.attr("title"));


/*
                Elements songs = songInfo.getElementsByTag("a");
                for(Element elm : files) {
                    String text = elm.text();
                    String href = elm.attr("href");

                    System.out.println(text+" > "+href);
                }
                */
            }
/*

            // 4-2. CSS Selector 탐색
            System.out.println("\n[CSS Selector 탐색]");
            Elements files = html.select(".fileblock a");
            for(Element elm : files) {
                String text = elm.text();
                String href = elm.attr("href");

                System.out.println(text+" > "+href);
            }
*/

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

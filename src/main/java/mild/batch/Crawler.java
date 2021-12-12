package mild.batch;

import mild.batch.data.dto.SongDto;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crawler {
    public static void main(String[] args) {
        try {
            // 1. 수집 대상 URL
            String URL = "https://www.melon.com/chart/index.htm";

            // 2. Connection 생성
            Connection conn = Jsoup.connect(URL);

            // 3. HTML 파싱
            Document doc = conn.get();

            // 4. HTML 출력
            //System.out.println(html.toString());

            List<SongDto> songList = new ArrayList<SongDto>();

            // 4. 요소 탐색
            // 4-1. 곡 리스트 탐색
            Elements titles = doc.select("div[class=ellipsis rank01]").select("a");
            Elements singer = doc.select("div[class=ellipsis rank02]").select("a");
            Elements rank   = doc.select("span[class=rank]");
            Elements album  = doc.select("div[class=ellipsis rank03]").select("a");
            Elements songImg  = doc.select("a[class=image_typeAll]").select("img");

            rank.remove(0);

            System.out.println("곡 수 : " + titles.size());

            for(int i=0; i<titles.size(); i++) {

                SongDto song = new SongDto(
                        titles.get(i).text(),
                        Integer.parseInt(rank.get(i).text()),
                        singer.get(i).text(),
                        album.get(i).text(),
                        "",
                        songImg.get(i).attr("src"),
                        "");

                songList.add(song);

                System.out.println(rank.get(i).text() + "\t" + titles.get(i).text() + "\t" + singer.get(i).text() + "\t" + album.get(i).text());

            }
            System.out.println(songList.toString());
/*
                Elements songs = songInfo.getElementsByTag("a");
                for(Element elm : files) {
                    String text = elm.text();
                    String href = elm.attr("href");

                    System.out.println(text+" > "+href);
                }
                */
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

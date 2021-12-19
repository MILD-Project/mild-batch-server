package mild.batch.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_song")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {

    @Id
    @GeneratedValue
    @Column(name = "song_idx")
    private int songIdx;

    private int rank;

    private String title;

    private String singer;

    private String album;

    private String lyrics;

    @Column(name = "main_img")
    private String mainImg;

    @Column(name = "sub_img")
    private String subImg;

    @Builder
    public Song(String title, int rank, String singer, String album, String lyrics, String mainImg, String subImg) {
        this.title = title;
        this.rank = rank;
        this.singer = singer;
        this.album = album;
        this.lyrics = lyrics;
        this.mainImg = mainImg;
        this.subImg = subImg;
    }


}

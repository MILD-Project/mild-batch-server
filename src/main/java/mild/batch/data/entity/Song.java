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

    @Id @GeneratedValue
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

}

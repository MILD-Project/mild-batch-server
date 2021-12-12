package mild.batch.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongDto {

    private String title;
    private int rank;
    private String singer;
    private String album;
    private String lyrics;
    private String mainImg;
    private String subImg;

}

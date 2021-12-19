package mild.batch.data.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SongQueryRepository {

    private final JPAQueryFactory query;
/*
    public Long createChart(SongDto songDto) {
        Long result = query
                .insert(song)
                .columns(song.rank, song.title, song.singer, song.album, song.main_img)
                .values(songDto.getRank(),songDto.getTitle(),songDto.getSinger(), songDto.getAlbum(), songDto.getMainImg())
                .execute();
        return result;
    }
    */
}

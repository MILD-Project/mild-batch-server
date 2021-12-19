package mild.batch.config;

import lombok.RequiredArgsConstructor;
import mild.batch.Crawler;
import mild.batch.chunk.QueueItemReader;
import mild.batch.data.dto.SongDto;
import mild.batch.data.entity.Song;
import mild.batch.data.repository.SongRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class BatchJobConfig {

    private final SongRepository songRepository;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job songJob() {
        return jobBuilderFactory.get("songJob")
                .preventRestart()
                .start(songJobStep(null))
                .build();
    }

    @Bean
    public Step songJobStep(@Value("#{jobParameters[requestDate]}") final String requestDate) {
        return stepBuilderFactory.get("songStep")
                .<Song, Song>chunk(10)
                .reader(songReader())
                .writer(songWriter())
                .build();

    }

    @Bean
    @StepScope
    public QueueItemReader<Song> songReader() {

        Crawler crawler = new Crawler();

        List<Song> songList = crawler.songList();

        return new QueueItemReader<>(songList);
    }

    public ItemWriter<Song> songWriter() {
        return ((List<? extends Song> songs) -> songRepository.saveAll(songs));
    }
/*

    @Bean
    public Job helloJob() {
        return jobBuilderFactory.get("helloJob")
                .start(helloStep1())
                .next(helloStep2())
                .build();
    }

    @Bean
    public Step helloStep1() {
        return stepBuilderFactory.get("helloStep1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(" =========================");
                        System.out.println(" >> Hello Spring Batch!!");
                        System.out.println(" =========================");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

    @Bean
    public Step helloStep2() {
        return stepBuilderFactory.get("helloStep2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println(" =========================");
                        System.out.println(" >> step2 was executed");
                        System.out.println(" =========================");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
*/

    /*
    @Bean
    public BatchConfigurer batchConfigurer() {
        return new InMemoryBatchConfigurer();
    }

    @Autowired
    private UpdateTop100MusicTasklet updateTop100MusicTasklet;

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public Job updateTop100MusicJob() {
        return jobBuilderFactory.get("updateTop100Music")
                .start(updateTop100Music())
                .build();
    }

    @Bean
    public Step updateTop100Music() {
        return stepBuilderFactory.get("updateTop100Music")
                .tasklet(updateTop100MusicTasklet)
                .build();
    }

    */
}

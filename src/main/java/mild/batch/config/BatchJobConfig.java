package mild.batch.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchJobConfig {
    //test
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
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

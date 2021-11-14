package mild.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing  // Batch 활성화
public class MildBatchServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MildBatchServerApplication.class, args);
    }

}

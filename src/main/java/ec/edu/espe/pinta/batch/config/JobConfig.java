package ec.edu.espe.pinta.batch.config;

import ec.edu.espe.pinta.batch.process.AsignStudentParalelo;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@AllArgsConstructor
public class JobConfig {
    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;


    @Bean
    protected Step accountAccrualTask() {
        return steps
                .get("accountAccrualTask")
                .tasklet(new AsignStudentParalelo(this.restTemplate))
                .build();
    }

    @Bean
    public Job AsignedStudents() {
        return jobs
                .get("asignedStudents")
                .start(accountAccrualTask())
                .build();
    }

}


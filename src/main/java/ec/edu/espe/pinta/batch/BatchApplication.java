package ec.edu.espe.pinta.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class BatchApplication {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("asignedStudents")
	Job job1;
	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(BatchApplication.class, args);

	}

	@Scheduled(cron = "0 */1 * * * ?")
	public void perform() throws Exception {
		System.out.println("Iniciando el Job");
		JobParameters params = new JobParametersBuilder()
				.addString("asignedStudents", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job1, params);
	}

}

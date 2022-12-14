package ec.edu.espe.pinta.batch.process;

import ec.edu.espe.pinta.batch.model.Student;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.web.client.RestTemplate;

public class InsertStudentTask  implements Tasklet, StepExecutionListener {

    private final RestTemplate restTemplate;

    public InsertStudentTask(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        Student Student = this.restTemplate.getForObject(
                "http://localhost:8080/students/", Student.class);
        return RepeatStatus.FINISHED;
    }
}

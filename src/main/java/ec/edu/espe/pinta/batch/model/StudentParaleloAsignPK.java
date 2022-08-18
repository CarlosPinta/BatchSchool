package ec.edu.espe.pinta.batch.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class StudentParaleloAsignPK implements Serializable {

    private static final long serialVersionUID = -8742725422349733863L;

    @Column(name = "PARALELO_ID", nullable = false, length = 10)
    @NonNull
    @EqualsAndHashCode.Include
    private String paraleloId;

    @Column(name = "STUDENT_CEDULA", nullable = false, length = 10)
    @NonNull
    @EqualsAndHashCode.Include
    private String studentId;

}

package ec.edu.espe.pinta.batch.model;


import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT_PARALELO_ASIGN")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentParaleloAsign implements Serializable {
    private static final long serialVersionUID = 785744895856L;

    @EmbeddedId
    @NonNull @EqualsAndHashCode.Include private StudentParaleloAsignPK pk;

}

package ec.edu.espe.pinta.batch.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 785744895856L;

    @Id
    @Column(name = "STUDENT_CEDULA", length = 10, nullable = false)
    @NonNull
    @EqualsAndHashCode.Include
    private String cedula;

    @Column(name = "APELLIDO", length = 32, nullable = false)
    @NonNull
    private String apellidos;

    @Column(name = "NOMBRES", length = 32, nullable = false)
    private String nombres;

    @Column(name = "nivel", length = 2, nullable = false)
    @NonNull
    private String nivel;

}

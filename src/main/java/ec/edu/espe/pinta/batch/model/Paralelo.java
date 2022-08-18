package ec.edu.espe.pinta.batch.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "PARALELO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paralelo implements Serializable {
    private static final long serialVersionUID = 785744895856L;
    @Id
    @Column(name = "PARALELO_ID", length = 10, nullable = false)
    @NonNull
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "NOMBRE", length = 32, nullable = false)
    private String nombre;

    @Column(name = "NIVEL", length = 32, nullable = false)
    private String nivel;

    @Column(name = "TOTAL_STUDENTS", length = 32, nullable = false)
    private BigInteger totalStudents;
}

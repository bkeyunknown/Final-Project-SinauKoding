package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
public class Employee extends BaseEntity<Employee>{

    private static final long serialVersionUID = 6123253896463683607L;

    public enum StatusEmployee {
        ACTIVE,
        DEACTIVATE
    }

    @Column(name = "start_date")
    @Temporal(DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(DATE)
    private Date endDate;

    @Column(name = "nip")
    private String nip;

    @Column(name = "status")
    @Enumerated(STRING)
    private StatusEmployee status = StatusEmployee.ACTIVE;

}

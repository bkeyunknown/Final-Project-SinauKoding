package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
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

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}

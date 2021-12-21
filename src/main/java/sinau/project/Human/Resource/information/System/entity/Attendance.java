package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.*;

@Entity
@Table(name = "attendance")
@Setter
@Getter
@NoArgsConstructor
public class Attendance extends BaseEntity<Attendance>{

    private static final long serialVersionUID = 8152706607812625960L;

    @Column(name = "date")
    @Temporal(DATE)
    private Date date;

    @Column(name = "start_time")
    @Temporal(TIME)
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(TIME)
    private Date endTime;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "rest_start_time")
    @Temporal(TIME)
    private Date restStartTime;

    @Column(name = "rest_end_time")
    @Temporal(TIME)
    private Date restEndTime;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}

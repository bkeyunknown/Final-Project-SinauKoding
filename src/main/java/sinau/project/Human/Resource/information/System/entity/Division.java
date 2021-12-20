package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "division")
@Setter
@Getter
@NoArgsConstructor
public class Division extends BaseEntity<Division>{

    private static final long serialVersionUID = 9099882842473546680L;

    @Column(name = "name")
    private String name;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

}

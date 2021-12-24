package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "division")
@Setter
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE division SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Division extends BaseEntity<Division>{

    private static final long serialVersionUID = 9099882842473546680L;

    @Column(name = "name")
    private String name;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

}

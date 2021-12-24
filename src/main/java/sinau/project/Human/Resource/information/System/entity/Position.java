package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "position")
@Setter
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE position SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Position extends BaseEntity<Position>{

    private static final long serialVersionUID = 1516686760606961961L;

    @Column(name = "name")
    private String name;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

}

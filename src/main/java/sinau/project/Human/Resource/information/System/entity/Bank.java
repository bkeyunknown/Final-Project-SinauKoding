package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Setter
@Getter
@NoArgsConstructor
@SQLDelete(sql = "UPDATE bank SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Bank extends BaseEntity<Bank>{

    private static final long serialVersionUID = 6460783416031543243L;

    @Column(name = "code", columnDefinition = "VARCHAR(10)")
    private String code;

    @Column(name = "name", columnDefinition = "VARCHAR(40)")
    private String name;

}

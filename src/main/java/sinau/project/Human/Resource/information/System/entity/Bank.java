package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Setter
@Getter
@NoArgsConstructor
public class Bank extends BaseEntity<Bank>{

    private static final long serialVersionUID = 6460783416031543243L;

}

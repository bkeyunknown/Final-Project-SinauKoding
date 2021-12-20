package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
public class Employee extends BaseEntity<Employee>{

    private static final long serialVersionUID = 6123253896463683607L;

}

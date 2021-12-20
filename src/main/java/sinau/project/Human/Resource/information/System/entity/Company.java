package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Setter
@Getter
@NoArgsConstructor
public class Company extends BaseEntity<Company>{

    private static final long serialVersionUID = -3216589018660874716L;

}

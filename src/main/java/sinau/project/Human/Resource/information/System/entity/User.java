package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.*;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = -2896266994252754612L;

    public enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "no_rekening")
    private String noRekening;

    @Column(name = "active")
    private Boolean active = Boolean.TRUE;

    @Column(name = "date_of_birth")
    @Temporal(DATE)
    private Date dateOfBirth;

    @Column(name = "domicile_address")
    private String domicileAddress;

    @Column(name = "pendidikan_terakhir")
    private String pendidikanTerakhir;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "nama_ibu")
    private String namaIbu;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "no_bpjs_ketenagakerjaan")
    private String noBpjsKetenagakerjaan;

    @Column(name = "no_bpjs_kesehatan")
    private String noBpjsKesehatan;

    @Column(name = "no_ktp")
    private String noKtp;

    @Column(name = "npwp")
    private String npwp;

    @Column(name = "phone")
    private String phone;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "profile_name", columnDefinition = "VARCHAR(50)")
    private String profileName;

    @Column(name = "religion")
    private String religion;

    @Column(name = "residence_address")
    private String residenceAddress;

    @Column(name = "role", columnDefinition = "VARCHAR(50)")
    @Enumerated(STRING)
    private Role role = Role.ROLE_USER;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "division_id")
    private Division division;

}

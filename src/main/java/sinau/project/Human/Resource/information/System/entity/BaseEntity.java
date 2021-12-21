package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
@DynamicUpdate
@SuppressWarnings("unchecked")
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = -2499705514484703954L;

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "created_time", updatable = false)
    @Temporal(TIMESTAMP)
    private Date createTime;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Column(name = "deleted_time")
    @Temporal(TIMESTAMP)
    private Date deletedTime;

    @Column(name = "updated_time")
    @Temporal(TIMESTAMP)
    private Date updatedTime;

    @PrePersist
    protected void onCreate() {
        setCreateTime(new Date());
    }

    @PreUpdate
    protected void onUpdate() {
        setUpdatedTime(new Date());
    }

    @PreRemove
    protected void onDeleted() {
        setDeleted(Boolean.TRUE);
        setDeletedTime(new Date());
    }

}

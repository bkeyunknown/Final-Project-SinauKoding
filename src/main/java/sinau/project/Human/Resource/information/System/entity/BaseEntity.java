package sinau.project.Human.Resource.information.System.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import sinau.project.Human.Resource.information.System.HumanResourceInformationSystemApplication;

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

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @PrePersist
    protected void onCreate() {
        setCreateTime(new Date());
        setCreatedBy(HumanResourceInformationSystemApplication.getCurrentUser() != null
                ? HumanResourceInformationSystemApplication.getCurrentUser().getId()
                : 0);
    }

    @PreUpdate
    protected void onUpdate() {
        setUpdatedTime(new Date());
        setUpdatedBy(HumanResourceInformationSystemApplication.getCurrentUser() != null
                ? HumanResourceInformationSystemApplication.getCurrentUser().getId()
                : 0);
    }

    @PreRemove
    protected void onRemove() {
        setDeleted(Boolean.TRUE);
        setDeletedTime(new Date());
        setDeletedBy(HumanResourceInformationSystemApplication.getCurrentUser() != null
                ? HumanResourceInformationSystemApplication.getCurrentUser().getId()
                : 0);
    }

}

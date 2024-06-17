package ITS.BTinside.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.sql.Date;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHE_IDX", nullable = false)
    private Long sche_idx;

    @Column(name = "SCHE_TITLE", nullable = false)
    private String sche_title;

    @Column(name = "SCHE_LOC")
    private String sche_loc;

    @Column(name = "SCHE_START_TIME")
    private Date sche_start_time;

    @Column(name = "SCHE_END_TIME")
    private Date sche_end_time;

    @Column(name = "SCHE_PERSON")
    private String sche_person;

    @Column(name = "CREATED_AT", nullable = false, insertable = false)
    private Timestamp create_at;

    @Column(name = "UPDATED_AT", insertable = false)
    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    private User user;

    public Long getSche_idx() {
        return sche_idx;
    }

    public void setSche_idx(Long sche_idx) {
        this.sche_idx = sche_idx;
    }

    public String getSche_title() {
        return sche_title;
    }

    public void setSche_title(String sche_title) {
        this.sche_title = sche_title;
    }

    public String getSche_loc() {
        return sche_loc;
    }

    public void setSche_loc(String sche_loc) {
        this.sche_loc = sche_loc;
    }

    public Date getSche_start_time() {
        return sche_start_time;
    }

    public void setSche_start_time(Date sche_start_time) {
        this.sche_start_time = sche_start_time;
    }

    public Date getSche_end_time() {
        return sche_end_time;
    }

    public void setSche_end_time(Date sche_end_time) {
        this.sche_end_time = sche_end_time;
    }

    public String getSche_person() {
        return sche_person;
    }

    public void setSche_person(String sche_person) {
        this.sche_person = sche_person;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

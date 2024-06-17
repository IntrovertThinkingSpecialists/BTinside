package ITS.BTinside.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_IDX", nullable = false)
    private Long profile_idx;

    @Column(name = "PROFILE_PIC")
    private String profile_pic;

    @Column(name = "PROFILE_NAME", nullable = false)
    private String profile_name;

    @Column(name = "PROFILE_TYPE", nullable = false)
    private int profile_type;

    @Column(name = "CREATED_AT", nullable = false, insertable = false)
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private User user;

    public Long getProfile_idx() {
        return profile_idx;
    }

    public void setProfile_idx(Long profile_idx) {
        this.profile_idx = profile_idx;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public int getProfile_type() {
        return profile_type;
    }

    public void setProfile_type(int profile_type) {
        this.profile_type = profile_type;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

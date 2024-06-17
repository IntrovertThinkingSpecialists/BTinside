package ITS.BTinside.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "FOLLOWERS")
public class Followers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOLLOWERS_IDX", nullable = false)
    private Long followers_idx;

    @Column(name = "FOLLOWEE", nullable = false)
    private Long followee;

    @Column(name = "CREATED_AT", nullable = false, insertable = false)
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "PROFILE_IDX", referencedColumnName = "PROFILE_IDX", nullable = false)
    private Profile profile;

    public Long getFollowers_idx() {
        return followers_idx;
    }

    public void setFollowers_idx(Long followers_idx) {
        this.followers_idx = followers_idx;
    }

    public Long getFollowee() {
        return followee;
    }

    public void setFollowee(Long followee) {
        this.followee = followee;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

package ITS.BTinside.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Loc_IDX", nullable = false)
    private Long loc_idx;

    @Column(name = "LOC_NAME", nullable = false)
    private String loc_name;

    @Column(name = "LOC_LAT")
    private Float loc_lat;

    @Column(name = "LOC_LON")
    private Float loc_lon;

    @ManyToOne
    @JoinColumn(name = "POST_IDX", referencedColumnName = "POST_IDX", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "PROFILE_IDX", referencedColumnName = "PROFILE_IDX", nullable = false)
    private Profile profile;

    public Long getLoc_idx() {
        return loc_idx;
    }

    public void setLoc_idx(Long loc_idx) {
        this.loc_idx = loc_idx;
    }

    public String getLoc_name() {
        return loc_name;
    }

    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }

    public Float getLoc_lat() {
        return loc_lat;
    }

    public void setLoc_lat(Float loc_lat) {
        this.loc_lat = loc_lat;
    }

    public Float getLoc_lon() {
        return loc_lon;
    }

    public void setLoc_lon(Float loc_lon) {
        this.loc_lon = loc_lon;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

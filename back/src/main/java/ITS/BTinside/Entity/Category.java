package ITS.BTinside.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATE_IDX", nullable = false)
    private Long cate_idx;

    @Column(name = "CATE_NAME", nullable = false)
    private String cate_name;

    @Column(name = "PARENT_CATE")
    private Long parent_cate;

    @ManyToOne
    @JoinColumn(name = "PARENT_IDX", referencedColumnName = "CATE_IDX")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "PROFILE_IDX", referencedColumnName = "PROFILE_IDX")
    private Profile profile;

    public Long getCate_idx() {
        return cate_idx;
    }

    public void setCate_idx(Long cate_idx) {
        this.cate_idx = cate_idx;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Long getParent_cate() {
        return parent_cate;
    }

    public void setParent_cate(Long parent_cate) {
        this.parent_cate = parent_cate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}

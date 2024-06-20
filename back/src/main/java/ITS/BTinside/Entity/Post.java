package ITS.BTinside.Entity;

import jakarta.persistence.*;

import java.sql.Clob;
import java.sql.Timestamp;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_IDX", nullable = false)
    private Long post_idx;

    @Column(name = "POST_TITLE", nullable = false)
    private String post_title;

    @Column(name = "POST_CONTENT")
    private Clob post_content;

    @Column(name = "CREATE_AT", nullable = false, insertable = false)
    private Timestamp created_at;

    @Column(name = "POST_VIEWS")
    private Long post_views;

    @Column(name = "POST_LIKES")
    private Long post_likes;

    @Column(name = "UPDATED_AT", insertable = false)
    private Timestamp updated_at;

    @Column(name = "POST_FILE")
    private String post_file;

    @ManyToOne
    @JoinColumn(name = "PROFILE_IDX", referencedColumnName = "PROFILE_IDX", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "CATE_IDX", referencedColumnName = "CATE_IDX", nullable = false)
    private Category category;

    public Post() {
        this.post_views = 0L;
        this.post_likes = 0L;
    }

    public Long getPost_idx() {
        return post_idx;
    }

    public void setPost_idx(Long post_idx) {
        this.post_idx = post_idx;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public Clob getPost_content() {
        return post_content;
    }

    public void setPost_content(Clob post_content) {
        this.post_content = post_content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Long getPost_views() {
        return post_views;
    }

    public void setPost_views(Long post_views) {
        this.post_views = post_views;
    }

    public Long getPost_likes() {
        return post_likes;
    }

    public void setPost_likes(Long post_likes) {
        this.post_likes = post_likes;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getPost_file() {
        return post_file;
    }

    public void setPost_file(String post_file) {
        this.post_file = post_file;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

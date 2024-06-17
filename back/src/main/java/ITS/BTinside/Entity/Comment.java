package ITS.BTinside.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "TB_COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CMT_IDX", nullable = false)
    private Long cmt_idx;

    @Column(name = "CMT_CONTENT", nullable = false)
    private String cmt_content;

    @Column(name = "CREATE_AT", nullable = false, insertable = false)
    private Date created_at;

    @Column(name = "CMT_LIKES")
    private Long cmt_likes;

    @Column(name = "PARENT_COMMENTS", nullable = false)
    private Long parent_comments;

    @ManyToOne
    @JoinColumn(name = "PROFILE_IDX", referencedColumnName = "PROFILE_IDX", nullable = false)
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "POST_IDX", referencedColumnName = "POST_IDX", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "CATE_IDX", referencedColumnName = "CATE_IDX", nullable = false)
    private Category category;

    public Comment() {
        this.cmt_likes = 0L;
    }

    public Long getCmt_idx() {
        return cmt_idx;
    }

    public void setCmt_idx(Long cmt_idx) {
        this.cmt_idx = cmt_idx;
    }

    public String getCmt_content() {
        return cmt_content;
    }

    public void setCmt_content(String cmt_content) {
        this.cmt_content = cmt_content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Long getCmt_likes() {
        return cmt_likes;
    }

    public void setCmt_likes(Long cmt_likes) {
        this.cmt_likes = cmt_likes;
    }

    public Long getParent_comments() {
        return parent_comments;
    }

    public void setParent_comments(Long parent_comments) {
        this.parent_comments = parent_comments;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

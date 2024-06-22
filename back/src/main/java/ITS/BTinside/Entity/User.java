package ITS.BTinside.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "PW", nullable = false)
    private String pw;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "JOINED_AT", nullable = false, insertable = false)
    private Timestamp joined_at;

    @ManyToOne
    @JoinColumn(name = "CATEGORY", referencedColumnName = "CATE_IDX", nullable = false)
    private Category category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(Timestamp joined_at) {
        this.joined_at = joined_at;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

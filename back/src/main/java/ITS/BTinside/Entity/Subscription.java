package ITS.BTinside.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "TB_SUBSCRIPTION")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBSCRIPTION_ID", nullable = false)
    private Long subscriptionId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "PLAN_ID", referencedColumnName = "PLAN_ID", nullable = false)
    private SubscriptionPlan subscriptionPlan;
    //3가지의 구독 방식

    @Column(name = "START_DATE", nullable = false)
    private Timestamp startDate;

    @Column(name = "END_DATE", nullable = false)
    private Timestamp endDate;


    public void setSubscriptionType(String subscriptionType) {

    }

    public void setStatus(String active) {
    }
}
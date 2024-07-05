package ITS.BTinside.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_SUBSCRIPTION_PLAN")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_ID", nullable = false)
    private Long planId;

    @Column(name = "PLAN_NAME", nullable = false)
    private String planName;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "DURATION", nullable = false) // in months
    private Integer duration;

    @Column(name = "PERSONA_LIMIT", nullable = false)
    private Integer personaLimit;

    @Column(name = "NEIGHBOR_LIMIT", nullable = false)
    private Integer neighborLimit;

    @Column(name = "DAILY_POST_LIMIT", nullable = false)
    private Integer dailyPostLimit;

}

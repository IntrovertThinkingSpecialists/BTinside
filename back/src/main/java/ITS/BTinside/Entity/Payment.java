package ITS.BTinside.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "TB_PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID", nullable = false)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "PLAN_ID", referencedColumnName = "PLAN_ID", nullable = false)
    private SubscriptionPlan subscriptionPlan;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private Timestamp paymentDate;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

}

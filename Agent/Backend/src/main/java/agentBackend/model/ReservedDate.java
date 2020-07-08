package agentBackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="reserved_date")
public class ReservedDate {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "oneDate", nullable = false)
   private String oneDate;

   @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
   @JoinColumn(name="addvertisment_id")
   public Addvertisment addvertisment;

   public ReservedDate() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getOneDate() {
      return oneDate;
   }

   public void setOneDate(String oneDate) {
      this.oneDate = oneDate;
   }

   public Addvertisment getAddvertisment() {
      return addvertisment;
   }

   public void setAddvertisment(Addvertisment addvertisment) {
      this.addvertisment = addvertisment;
   }
}
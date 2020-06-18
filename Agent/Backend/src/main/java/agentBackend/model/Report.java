
package agentBackend.model;

import javax.persistence.*;

@Entity
public class Report {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "kilometresCrossed", nullable = false)
   private float kilometres_crossed;

   @Column(name = "additionalInformation", nullable = false)
   private String additional_information;

   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "purchase_id")
   public Purchase purchase;

   public Report() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public float getKilometresCrossed() {
      return kilometres_crossed;
   }

   public void setKilometresCrossed(float kilometresCrossed) {
      this.kilometres_crossed = kilometresCrossed;
   }

   public String getAdditionalInformation() {
      return additional_information;
   }

   public void setAdditionalInformation(String additionalInformation) {
      this.additional_information = additionalInformation;
   }

   public Purchase getPurchase() {
      return purchase;
   }

   public void setPurchase(Purchase purchase) {
      this.purchase = purchase;
   }
}
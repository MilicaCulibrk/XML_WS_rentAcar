
package agentBackend.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="transmission_type")
public class TransmissionType {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "transmission_type_name", nullable = false)
   private String transmission_type_name;

   @OneToMany(fetch = FetchType.LAZY)
   @JoinColumn(name = "transmission_type_id")
   public List<Addvertisment> addvertisments;

   public TransmissionType() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTransmission_type_name() {
      return transmission_type_name;
   }

   public void setTransmission_type_name(String transmission_type_name) {
      this.transmission_type_name = transmission_type_name;
   }

   public List<Addvertisment> getAddvertisments() {
      return addvertisments;
   }

   public void setAddvertisments(List<Addvertisment> addvertisments) {
      this.addvertisments = addvertisments;
   }
}
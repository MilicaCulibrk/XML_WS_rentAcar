/***********************************************************************
 * Module:  ReservedDate.java
 * Author:  23nik
 * Purpose: Defines the Class ReservedDate
 ***********************************************************************/

package agentBackend.model;

import java.util.Date;

/** @pdOid 361a829b-37b5-4354-87a1-4b46e2548c1d */
public class ReservedDate {
   /** @pdOid 951773b9-75da-4508-babb-3d31a17aac50 */
   private Date dateFrom;
   /** @pdOid e4c8225f-b90f-4af4-93b7-44fd80c87f6c */
   private Date dateTo;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association8 mult=1..1 side=A */
   public Addvertisment addvertisment;
   
   
   /** @pdGenerated default parent getter */
   public Addvertisment getAddvertisment() {
      return addvertisment;
   }
   
   /** @pdGenerated default parent setter
     * @param newAddvertisment */
   public void setAddvertisment(Addvertisment newAddvertisment) {
      if (this.addvertisment == null || !this.addvertisment.equals(newAddvertisment))
      {
         if (this.addvertisment != null)
         {
            Addvertisment oldAddvertisment = this.addvertisment;
            this.addvertisment = null;
            oldAddvertisment.removeReservedDate(this);
         }
         if (newAddvertisment != null)
         {
            this.addvertisment = newAddvertisment;
            this.addvertisment.addReservedDate(this);
         }
      }
   }

}
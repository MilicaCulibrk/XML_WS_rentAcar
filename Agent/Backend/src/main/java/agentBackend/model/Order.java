/***********************************************************************
 * Module:  Order.java
 * Author:  23nik
 * Purpose: Defines the Class Order
 ***********************************************************************/

package agentBackend.model;

import java.util.Date;

/** @pdOid ba3de7e0-c632-4c44-85ab-2c48ab376dfb */
public class Order {
   /** @pdOid dd5f13fc-56ec-4607-86b7-481554a6a6db */
   private Long id;
   /** @pdOid 2d2459ba-0c0d-4489-861d-98825ca0cd63 */
   private Date dateFrom;
   /** @pdOid e06dfdd9-e1d6-4ccb-825f-294187977712 */
   private Date dateTo;
   /** @pdOid 3250edf2-ed49-4456-84ed-54a3681dec13 */
   private boolean ordered;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association6 mult=1..1 */
   public Addvertisment addvertisment;
   /** @pdRoleInfo migr=no name=RequestForRenting assc=association5 mult=1..1 side=A */
   public RequestForRenting requestForRenting;
   /** @pdRoleInfo migr=no name=User assc=association7 mult=1..1 side=A */
   public User user;
   /** @pdRoleInfo migr=no name=RentingReport assc=association9 mult=1..1 side=A */
   public RentingReport rentingReport;
   
   
   /** @pdGenerated default parent getter */
   public RequestForRenting getRequestForRenting() {
      return requestForRenting;
   }
   
   /** @pdGenerated default parent setter
     * @param newRequestForRenting */
   public void setRequestForRenting(RequestForRenting newRequestForRenting) {
      if (this.requestForRenting == null || !this.requestForRenting.equals(newRequestForRenting))
      {
         if (this.requestForRenting != null)
         {
            RequestForRenting oldRequestForRenting = this.requestForRenting;
            this.requestForRenting = null;
            oldRequestForRenting.removeOrder(this);
         }
         if (newRequestForRenting != null)
         {
            this.requestForRenting = newRequestForRenting;
            this.requestForRenting.addOrder(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public User getUser() {
      return user;
   }
   
   /** @pdGenerated default parent setter
     * @param newUser */
   public void setUser(User newUser) {
      if (this.user == null || !this.user.equals(newUser))
      {
         if (this.user != null)
         {
            User oldUser = this.user;
            this.user = null;
            oldUser.removeOrder(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addOrder(this);
         }
      }
   }

}
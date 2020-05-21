/***********************************************************************
 * Module:  Grade.java
 * Author:  23nik
 * Purpose: Defines the Class Grade
 ***********************************************************************/

package agentBackend.model;

/** @pdOid 927bc4c5-c234-4451-9666-ad932dfafe46 */
public class Grade {
   /** @pdOid e3e56a53-be4a-4a34-8c76-98c03989b1bb */
   private long id;
   /** @pdOid 41a3369f-b44e-414e-bed9-793763aeec4d */
   private int number;
   
   /** @pdRoleInfo migr=no name=User assc=association17 mult=1..1 side=A */
   public User user;
   /** @pdRoleInfo migr=no name=Addvertisment assc=association18 mult=1..1 side=A */
   public Addvertisment addvertisment;
   
   
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
            oldUser.removeGrade(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addGrade(this);
         }
      }
   }
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
            oldAddvertisment.removeGrade(this);
         }
         if (newAddvertisment != null)
         {
            this.addvertisment = newAddvertisment;
            this.addvertisment.addGrade(this);
         }
      }
   }

}
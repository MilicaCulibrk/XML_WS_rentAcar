/***********************************************************************
 * Module:  Comment.java
 * Author:  23nik
 * Purpose: Defines the Class Comment
 ***********************************************************************/

package agentBackend.model;

import java.util.*;

/** @pdOid 1572204e-5d17-476e-b36c-b1dddbfaaa70 */
public class Comment {
   /** @pdOid 195cac59-559b-4458-9271-f7c04c8095ce */
   private String text;
   /** @pdOid 10bd50a0-4c18-4178-8052-eed88f88ae99 */
   private boolean accepted;
   /** @pdOid 3589a0a1-efbd-48c4-b3ff-e083cb1ef959 */
   private long id;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association10 mult=1..1 side=A */
   public Addvertisment addvertisment;
   /** @pdRoleInfo migr=no name=User assc=association19 mult=1..1 side=A */
   public User user;
   
   
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
            oldAddvertisment.removeComment(this);
         }
         if (newAddvertisment != null)
         {
            this.addvertisment = newAddvertisment;
            this.addvertisment.addComment(this);
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
            oldUser.removeComment(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addComment(this);
         }
      }
   }

}
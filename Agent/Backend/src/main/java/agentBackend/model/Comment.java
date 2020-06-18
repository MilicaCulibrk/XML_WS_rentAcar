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
   
   


}
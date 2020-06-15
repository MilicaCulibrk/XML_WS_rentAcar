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
   
   


}
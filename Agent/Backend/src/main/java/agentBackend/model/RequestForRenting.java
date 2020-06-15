/***********************************************************************
 * Module:  RequestForRenting.java
 * Author:  23nik
 * Purpose: Defines the Class RequestForRenting
 ***********************************************************************/

package agentBackend.model;

/** @pdOid b384a8ec-4146-4b1f-9ace-a96b16c8cf81 */
public class RequestForRenting {
   /** @pdOid 70974c5f-ef1a-41ba-8589-9288cfd8efa5 */
   private Long id;
   /** @pdOid 9048cbd9-ca64-4f8a-a901-ded966872eba */
   private String status;
   
   /** @pdRoleInfo migr=no name=Order assc=association5 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Order> order;
   

}
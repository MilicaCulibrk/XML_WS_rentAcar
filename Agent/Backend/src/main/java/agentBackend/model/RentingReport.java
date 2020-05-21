/***********************************************************************
 * Module:  RentingReport.java
 * Author:  23nik
 * Purpose: Defines the Class RentingReport
 ***********************************************************************/

package agentBackend.model;

/** @pdOid fb5a2bec-565d-441d-a663-bcfc468f088f */
public class RentingReport {
   /** @pdOid 4ea3794d-d465-4de3-a457-e7493ac6cfe5 */
   private float numberOfKm;
   /** @pdOid 9f6012a9-0fae-48fb-ac8d-34b15aa7b420 */
   private String comment;
   /** @pdOid dde3fabc-5433-4cc9-9e94-6962949b756e */
   private long id;
   
   /** @pdRoleInfo migr=no name=Order assc=association9 mult=1..1 */
   public Order order;

}
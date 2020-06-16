/***********************************************************************
 * Module:  PriceList.java
 * Author:  23nik
 * Purpose: Defines the Class PriceList
 ***********************************************************************/

package agentBackend.model;

/** @pdOid 35f6761b-253e-410c-be65-ff31ea96304f */
public class PriceList {
   /** @pdOid c25f61f9-ee07-4b94-ba11-fd603e5c430e */
   private Long id;
   /** @pdOid d10a0aba-f19f-45d8-a40e-709b35e1e885 */
   private float dailyPrice;
   /** @pdOid fa0398eb-6bd4-46dd-8e7a-7d1d25bd0330 */
   private float overlimitPrice;
   /** @pdOid a1ed19ec-d9ec-477f-bdbe-81061071f368 */
   private float cdwPrice;
   /** @pdOid 5af4cbb6-3841-4f70-901b-cacfb06df57a */
   private float discount;
   /** @pdOid 330396f2-a751-4705-b873-687281937045 */
   private int numberOfDays;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association3 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Addvertisment> addvertisment;
   /** @pdRoleInfo migr=no name=Company assc=association4 mult=1..1 side=A */
   public Company company;
   /** @pdRoleInfo migr=no name=User assc=association20 mult=1..1 side=A */
   public User user;
   


}
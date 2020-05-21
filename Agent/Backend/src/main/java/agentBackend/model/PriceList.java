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
   
   
   /** @pdGenerated default getter */
   public java.util.List<Addvertisment> getAddvertisment() {
      if (addvertisment == null)
         addvertisment = new java.util.ArrayList<Addvertisment>();
      return addvertisment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAddvertisment() {
      if (addvertisment == null)
         addvertisment = new java.util.ArrayList<Addvertisment>();
      return addvertisment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAddvertisment */
   public void setAddvertisment(java.util.List<Addvertisment> newAddvertisment) {
      removeAllAddvertisment();
      for (java.util.Iterator iter = newAddvertisment.iterator(); iter.hasNext();)
         addAddvertisment((Addvertisment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAddvertisment */
   public void addAddvertisment(Addvertisment newAddvertisment) {
      if (newAddvertisment == null)
         return;
      if (this.addvertisment == null)
         this.addvertisment = new java.util.ArrayList<Addvertisment>();
      if (!this.addvertisment.contains(newAddvertisment))
      {
         this.addvertisment.add(newAddvertisment);
         newAddvertisment.setPriceList(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAddvertisment */
   public void removeAddvertisment(Addvertisment oldAddvertisment) {
      if (oldAddvertisment == null)
         return;
      if (this.addvertisment != null)
         if (this.addvertisment.contains(oldAddvertisment))
         {
            this.addvertisment.remove(oldAddvertisment);
            oldAddvertisment.setPriceList((PriceList)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAddvertisment() {
      if (addvertisment != null)
      {
         Addvertisment oldAddvertisment;
         for (java.util.Iterator iter = getIteratorAddvertisment(); iter.hasNext();)
         {
            oldAddvertisment = (Addvertisment)iter.next();
            iter.remove();
            oldAddvertisment.setPriceList((PriceList)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Company getCompany() {
      return company;
   }
   
   /** @pdGenerated default parent setter
     * @param newCompany */
   public void setCompany(Company newCompany) {
      if (this.company == null || !this.company.equals(newCompany))
      {
         if (this.company != null)
         {
            Company oldCompany = this.company;
            this.company = null;
            oldCompany.removePriceList(this);
         }
         if (newCompany != null)
         {
            this.company = newCompany;
            this.company.addPriceList(this);
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
            oldUser.removePriceList(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addPriceList(this);
         }
      }
   }

}
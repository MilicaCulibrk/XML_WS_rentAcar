/***********************************************************************
 * Module:  Company.java
 * Author:  23nik
 * Purpose: Defines the Class Company
 ***********************************************************************/

package agentBackend.model;

/** @pdOid b5e45fae-1045-46fc-999e-d66d19f55abc */
public class Company {
   /** @pdOid 51361c8c-9fc1-47bc-8b1d-2d219d579bae */
   private Long id;
   /** @pdOid 7d95aa1d-f14c-49cc-acc1-1d9128e28ec8 */
   private String name;
   /** @pdOid 45b9f20d-1645-49d1-9362-1f2ebca59a3b */
   private String email;
   /** @pdOid 3c4d4fb3-502e-4093-bff5-ca936522efdb */
   private String password;
   /** @pdOid 2e81fd8e-9fa2-4a4e-a89b-b39e1e3c50a0 */
   private String address;
   /** @pdOid a2412afe-0848-4231-b5b2-651a2dff4929 */
   private String city;
   /** @pdOid 9a8b2d44-aa36-42a2-a8c9-3951c6b5b51d */
   private String phoneNumber;
   /** @pdOid f53f6215-97b0-45a8-b17b-afe8d2883c6a */
   private String companyNumber;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association1 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Addvertisment> addvertisment;
   /** @pdRoleInfo migr=no name=PriceList assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<PriceList> priceList;
   
   
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
         newAddvertisment.setCompany(this);      
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
            oldAddvertisment.setCompany((Company)null);
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
            oldAddvertisment.setCompany((Company)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<PriceList> getPriceList() {
      if (priceList == null)
         priceList = new java.util.ArrayList<PriceList>();
      return priceList;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPriceList() {
      if (priceList == null)
         priceList = new java.util.ArrayList<PriceList>();
      return priceList.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPriceList */
   public void setPriceList(java.util.List<PriceList> newPriceList) {
      removeAllPriceList();
      for (java.util.Iterator iter = newPriceList.iterator(); iter.hasNext();)
         addPriceList((PriceList)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPriceList */
   public void addPriceList(PriceList newPriceList) {
      if (newPriceList == null)
         return;
      if (this.priceList == null)
         this.priceList = new java.util.ArrayList<PriceList>();
      if (!this.priceList.contains(newPriceList))
      {
         this.priceList.add(newPriceList);
         newPriceList.setCompany(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPriceList */
   public void removePriceList(PriceList oldPriceList) {
      if (oldPriceList == null)
         return;
      if (this.priceList != null)
         if (this.priceList.contains(oldPriceList))
         {
            this.priceList.remove(oldPriceList);
            oldPriceList.setCompany((Company)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPriceList() {
      if (priceList != null)
      {
         PriceList oldPriceList;
         for (java.util.Iterator iter = getIteratorPriceList(); iter.hasNext();)
         {
            oldPriceList = (PriceList)iter.next();
            iter.remove();
            oldPriceList.setCompany((Company)null);
         }
      }
   }

}
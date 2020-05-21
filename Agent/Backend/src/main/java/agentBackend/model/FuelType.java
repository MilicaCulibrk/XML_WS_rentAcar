/***********************************************************************
 * Module:  FuelType.java
 * Author:  23nik
 * Purpose: Defines the Class FuelType
 ***********************************************************************/

package agentBackend.model;

/** @pdOid 1e31e023-1140-42e5-bc74-12649152e600 */
public class FuelType {
   /** @pdOid b92ae024-a65c-4808-b58e-fad233fea518 */
   private long id;
   /** @pdOid 0f32105e-e060-47bc-8866-7b6783ca4a86 */
   private String fuelTypeName;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Addvertisment> addvertisment;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Addvertisment> getAddvertisment() {
      if (addvertisment == null)
         addvertisment = new java.util.HashSet<Addvertisment>();
      return addvertisment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAddvertisment() {
      if (addvertisment == null)
         addvertisment = new java.util.HashSet<Addvertisment>();
      return addvertisment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAddvertisment */
   public void setAddvertisment(java.util.Collection<Addvertisment> newAddvertisment) {
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
         this.addvertisment = new java.util.HashSet<Addvertisment>();
      if (!this.addvertisment.contains(newAddvertisment))
      {
         this.addvertisment.add(newAddvertisment);
         newAddvertisment.setFuelType(this);      
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
            oldAddvertisment.setFuelType((FuelType)null);
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
            oldAddvertisment.setFuelType((FuelType)null);
         }
      }
   }

}
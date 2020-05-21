/***********************************************************************
 * Module:  VehicleClass.java
 * Author:  23nik
 * Purpose: Defines the Class VehicleClass
 ***********************************************************************/

package agentBackend.model;

/** @pdOid f2b41f08-aa6a-4322-a9e1-33241ac2a48d */
public class VehicleClass {
   /** @pdOid 74fe6184-1db5-4c80-9a22-69551af2596b */
   private long id;
   /** @pdOid a38236f7-6f64-4357-9796-165e6e4fd31f */
   private String vehicleClassName;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
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
         newAddvertisment.setVehicleClass(this);      
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
            oldAddvertisment.setVehicleClass((VehicleClass)null);
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
            oldAddvertisment.setVehicleClass((VehicleClass)null);
         }
      }
   }

}
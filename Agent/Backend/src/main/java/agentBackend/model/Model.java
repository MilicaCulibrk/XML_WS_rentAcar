/***********************************************************************
 * Module:  Model.java
 * Author:  23nik
 * Purpose: Defines the Class Model
 ***********************************************************************/

package agentBackend.model;

/** @pdOid f8f8e34c-50c3-40f4-a89c-3755670b398c */
public class Model {
   /** @pdOid 718138ec-db2b-41ba-ad06-fbf595856b94 */
   private long id;
   /** @pdOid eb6edcad-e279-466b-a0f3-1c92df1237e6 */
   private String modelName;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Addvertisment> addvertisment;
   /** @pdRoleInfo migr=no name=Brand assc=association12 mult=1..1 side=A */
   public Brand brand;
   
   
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
         newAddvertisment.setModel(this);      
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
            oldAddvertisment.setModel((Model)null);
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
            oldAddvertisment.setModel((Model)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Brand getBrand() {
      return brand;
   }
   
   /** @pdGenerated default parent setter
     * @param newBrand */
   public void setBrand(Brand newBrand) {
      if (this.brand == null || !this.brand.equals(newBrand))
      {
         if (this.brand != null)
         {
            Brand oldBrand = this.brand;
            this.brand = null;
            oldBrand.removeModel(this);
         }
         if (newBrand != null)
         {
            this.brand = newBrand;
            this.brand.addModel(this);
         }
      }
   }

}
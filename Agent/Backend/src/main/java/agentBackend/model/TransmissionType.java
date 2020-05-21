/***********************************************************************
 * Module:  TransmissionType.java
 * Author:  23nik
 * Purpose: Defines the Class TransmissionType
 ***********************************************************************/

package agentBackend.model;

/** @pdOid 8a47b0c6-b412-4498-ad3f-330e91b90640 */
public class TransmissionType {
   /** @pdOid 903b0e66-70a4-412d-b8af-fa150127f83f */
   private long id;
   /** @pdOid 897ce7ec-6490-478b-92ab-bf0507dc406f */
   private String transmissionTypeName;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
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
         newAddvertisment.setTransmissionType(this);      
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
            oldAddvertisment.setTransmissionType((TransmissionType)null);
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
            oldAddvertisment.setTransmissionType((TransmissionType)null);
         }
      }
   }

}
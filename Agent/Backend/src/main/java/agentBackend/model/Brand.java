/***********************************************************************
 * Module:  Brand.java
 * Author:  23nik
 * Purpose: Defines the Class Brand
 ***********************************************************************/

package agentBackend.model;

import java.util.*;

/** @pdOid 55bee8eb-187f-4c0b-ad7a-ce0927c8c9a6 */
public class Brand {
   /** @pdOid 75236a6e-5e7e-4e7e-b0a1-b053b6ca9e9e */
   private Long id;
   /** @pdOid f6209012-942a-454e-9d74-f6d636ce30a2 */
   private String brandName;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Addvertisment> addvertisment;
   /** @pdRoleInfo migr=no name=Model assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Model> model;
   
   
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
         newAddvertisment.setBrand(this);      
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
            oldAddvertisment.setBrand((Brand)null);
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
            oldAddvertisment.setBrand((Brand)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Model> getModel() {
      if (model == null)
         model = new java.util.HashSet<Model>();
      return model;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorModel() {
      if (model == null)
         model = new java.util.HashSet<Model>();
      return model.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newModel */
   public void setModel(java.util.Collection<Model> newModel) {
      removeAllModel();
      for (java.util.Iterator iter = newModel.iterator(); iter.hasNext();)
         addModel((Model)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newModel */
   public void addModel(Model newModel) {
      if (newModel == null)
         return;
      if (this.model == null)
         this.model = new java.util.HashSet<Model>();
      if (!this.model.contains(newModel))
      {
         this.model.add(newModel);
         newModel.setBrand(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldModel */
   public void removeModel(Model oldModel) {
      if (oldModel == null)
         return;
      if (this.model != null)
         if (this.model.contains(oldModel))
         {
            this.model.remove(oldModel);
            oldModel.setBrand((Brand)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllModel() {
      if (model != null)
      {
         Model oldModel;
         for (java.util.Iterator iter = getIteratorModel(); iter.hasNext();)
         {
            oldModel = (Model)iter.next();
            iter.remove();
            oldModel.setBrand((Brand)null);
         }
      }
   }

}
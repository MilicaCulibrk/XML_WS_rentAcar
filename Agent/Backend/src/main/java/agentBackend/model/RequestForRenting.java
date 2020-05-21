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
   
   
   /** @pdGenerated default getter */
   public java.util.List<Order> getOrder() {
      if (order == null)
         order = new java.util.ArrayList<Order>();
      return order;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorOrder() {
      if (order == null)
         order = new java.util.ArrayList<Order>();
      return order.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOrder */
   public void setOrder(java.util.List<Order> newOrder) {
      removeAllOrder();
      for (java.util.Iterator iter = newOrder.iterator(); iter.hasNext();)
         addOrder((Order)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOrder */
   public void addOrder(Order newOrder) {
      if (newOrder == null)
         return;
      if (this.order == null)
         this.order = new java.util.ArrayList<Order>();
      if (!this.order.contains(newOrder))
      {
         this.order.add(newOrder);
         newOrder.setRequestForRenting(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldOrder */
   public void removeOrder(Order oldOrder) {
      if (oldOrder == null)
         return;
      if (this.order != null)
         if (this.order.contains(oldOrder))
         {
            this.order.remove(oldOrder);
            oldOrder.setRequestForRenting((RequestForRenting)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOrder() {
      if (order != null)
      {
         Order oldOrder;
         for (java.util.Iterator iter = getIteratorOrder(); iter.hasNext();)
         {
            oldOrder = (Order)iter.next();
            iter.remove();
            oldOrder.setRequestForRenting((RequestForRenting)null);
         }
      }
   }

}
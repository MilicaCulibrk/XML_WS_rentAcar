/***********************************************************************
 * Module:  User.java
 * Author:  23nik
 * Purpose: Defines the Class User
 ***********************************************************************/

package agentBackend.model;

/** @pdOid c76c6f87-ab62-4302-82f2-ebd8bd415b84 */
public class User {
   /** @pdOid 82304a5c-6a06-4aaf-8872-cccf1f55f020 */
   private Long id;
   /** @pdOid 447a0645-3808-40d7-bdad-12a18e13a46e */
   private String name;
   /** @pdOid 60214bda-bbab-4a0b-9d3b-fd7545ce5e83 */
   private String surname;
   /** @pdOid da0bf7e8-6f6c-4a60-8e16-d1cff9958b50 */
   private String email;
   /** @pdOid 93eb1974-3e6b-4dd4-ada2-6341523f9f26 */
   private String password;
   /** @pdOid a73de113-a8eb-439d-8528-dd0095196d3a */
   private String address;
   /** @pdOid 5a7bf397-7259-4c80-981d-109d62c62cc0 */
   private String city;
   /** @pdOid 17b7c3d1-9bad-4be8-afe9-4884c06f08f7 */
   private String phoneNumber;
   /** @pdOid 5b4e3b39-6a5d-43a1-8578-3338eed73186 */
   private int numberOfAddvertisment;
   
   /** @pdRoleInfo migr=no name=Addvertisment assc=association2 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Addvertisment> addvertisment;
   /** @pdRoleInfo migr=no name=Order assc=association7 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Order> order;
   /** @pdRoleInfo migr=no name=Grade assc=association17 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Grade> grade;
   /** @pdRoleInfo migr=no name=Comment assc=association19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Comment> comment;
   /** @pdRoleInfo migr=no name=PriceList assc=association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<PriceList> priceList;
   
   
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
         newAddvertisment.setUser(this);      
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
            oldAddvertisment.setUser((User)null);
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
            oldAddvertisment.setUser((User)null);
         }
      }
   }
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
         newOrder.setUser(this);      
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
            oldOrder.setUser((User)null);
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
            oldOrder.setUser((User)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Grade> getGrade() {
      if (grade == null)
         grade = new java.util.HashSet<Grade>();
      return grade;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorGrade() {
      if (grade == null)
         grade = new java.util.HashSet<Grade>();
      return grade.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newGrade */
   public void setGrade(java.util.Collection<Grade> newGrade) {
      removeAllGrade();
      for (java.util.Iterator iter = newGrade.iterator(); iter.hasNext();)
         addGrade((Grade)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGrade */
   public void addGrade(Grade newGrade) {
      if (newGrade == null)
         return;
      if (this.grade == null)
         this.grade = new java.util.HashSet<Grade>();
      if (!this.grade.contains(newGrade))
      {
         this.grade.add(newGrade);
         newGrade.setUser(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGrade */
   public void removeGrade(Grade oldGrade) {
      if (oldGrade == null)
         return;
      if (this.grade != null)
         if (this.grade.contains(oldGrade))
         {
            this.grade.remove(oldGrade);
            oldGrade.setUser((User)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllGrade() {
      if (grade != null)
      {
         Grade oldGrade;
         for (java.util.Iterator iter = getIteratorGrade(); iter.hasNext();)
         {
            oldGrade = (Grade)iter.next();
            iter.remove();
            oldGrade.setUser((User)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Comment> getComment() {
      if (comment == null)
         comment = new java.util.HashSet<Comment>();
      return comment;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorComment() {
      if (comment == null)
         comment = new java.util.HashSet<Comment>();
      return comment.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newComment */
   public void setComment(java.util.Collection<Comment> newComment) {
      removeAllComment();
      for (java.util.Iterator iter = newComment.iterator(); iter.hasNext();)
         addComment((Comment)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newComment */
   public void addComment(Comment newComment) {
      if (newComment == null)
         return;
      if (this.comment == null)
         this.comment = new java.util.HashSet<Comment>();
      if (!this.comment.contains(newComment))
      {
         this.comment.add(newComment);
         newComment.setUser(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldComment */
   public void removeComment(Comment oldComment) {
      if (oldComment == null)
         return;
      if (this.comment != null)
         if (this.comment.contains(oldComment))
         {
            this.comment.remove(oldComment);
            oldComment.setUser((User)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllComment() {
      if (comment != null)
      {
         Comment oldComment;
         for (java.util.Iterator iter = getIteratorComment(); iter.hasNext();)
         {
            oldComment = (Comment)iter.next();
            iter.remove();
            oldComment.setUser((User)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.Collection<PriceList> getPriceList() {
      if (priceList == null)
         priceList = new java.util.HashSet<PriceList>();
      return priceList;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPriceList() {
      if (priceList == null)
         priceList = new java.util.HashSet<PriceList>();
      return priceList.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPriceList */
   public void setPriceList(java.util.Collection<PriceList> newPriceList) {
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
         this.priceList = new java.util.HashSet<PriceList>();
      if (!this.priceList.contains(newPriceList))
      {
         this.priceList.add(newPriceList);
         newPriceList.setUser(this);      
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
            oldPriceList.setUser((User)null);
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
            oldPriceList.setUser((User)null);
         }
      }
   }

}
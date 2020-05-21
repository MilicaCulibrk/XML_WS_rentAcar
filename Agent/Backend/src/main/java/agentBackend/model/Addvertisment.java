/***********************************************************************
 * Module:  Addvertisment.java
 * Author:  23nik
 * Purpose: Defines the Class Addvertisment
 ***********************************************************************/

package agentBackend.model;



/** @pdOid 7dd887c3-f061-4afa-87d8-9aff3778b8c8 */
public class Addvertisment {
   /** @pdOid c35f419e-58ea-418e-9a2d-78ccb0963196 */
   private Long id;
   /** @pdOid a55a6a48-0822-4e6f-a762-bdfa12098024 */
   private float price;
   /** @pdOid 041b771c-7c44-48db-a0e4-15f1da0dd093 */
   private float mileage;
   /** @pdOid 5326269d-8616-40b2-8a1b-91ca5b29717b */
   private boolean cdw;
   /** @pdOid 58a43857-65df-4568-9625-c1927a47a1fb */
   private int childSeat;
   /** @pdOid 38f81fc0-a5d5-4782-89f7-90d1d6706c2b */
   private String location;
   /** @pdOid 5caeff9a-a76f-43fd-a924-4b7e7d9ade00 */
   private float averageGrade;
   /** @pdOid f7789ec7-f2ee-4680-8557-775153e0c8fa */
   private float mileageLimit;
   
   /** @pdRoleInfo migr=no name=ReservedDate assc=association8 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<ReservedDate> reservedDate;
   /** @pdRoleInfo migr=no name=Comment assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Comment> comment;
   /** @pdRoleInfo migr=no name=Grade assc=association18 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Grade> grade;
   /** @pdRoleInfo migr=no name=Company assc=association1 mult=0..1 side=A */
   public Company company;
   /** @pdRoleInfo migr=no name=User assc=association2 mult=0..1 side=A */
   public User user;
   /** @pdRoleInfo migr=no name=PriceList assc=association3 mult=1..1 side=A */
   public PriceList priceList;
   /** @pdRoleInfo migr=no name=Order assc=association6 mult=1..1 side=A */
   public Order order;
   /** @pdRoleInfo migr=no name=Brand assc=association11 mult=1..1 side=A */
   public Brand brand;
   /** @pdRoleInfo migr=no name=FuelType assc=association13 mult=1..1 side=A */
   public FuelType fuelType;
   /** @pdRoleInfo migr=no name=VehicleClass assc=association14 mult=1..1 side=A */
   public VehicleClass vehicleClass;
   /** @pdRoleInfo migr=no name=TransmissionType assc=association15 mult=1..1 side=A */
   public TransmissionType transmissionType;
   /** @pdRoleInfo migr=no name=Model assc=association16 mult=1..1 side=A */
   public Model model;
   
   
   /** @pdGenerated default getter */
   public java.util.List<ReservedDate> getReservedDate() {
      if (reservedDate == null)
         reservedDate = new java.util.ArrayList<ReservedDate>();
      return reservedDate;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorReservedDate() {
      if (reservedDate == null)
         reservedDate = new java.util.ArrayList<ReservedDate>();
      return reservedDate.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newReservedDate */
   public void setReservedDate(java.util.List<ReservedDate> newReservedDate) {
      removeAllReservedDate();
      for (java.util.Iterator iter = newReservedDate.iterator(); iter.hasNext();)
         addReservedDate((ReservedDate)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newReservedDate */
   public void addReservedDate(ReservedDate newReservedDate) {
      if (newReservedDate == null)
         return;
      if (this.reservedDate == null)
         this.reservedDate = new java.util.ArrayList<ReservedDate>();
      if (!this.reservedDate.contains(newReservedDate))
      {
         this.reservedDate.add(newReservedDate);
         newReservedDate.setAddvertisment(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldReservedDate */
   public void removeReservedDate(ReservedDate oldReservedDate) {
      if (oldReservedDate == null)
         return;
      if (this.reservedDate != null)
         if (this.reservedDate.contains(oldReservedDate))
         {
            this.reservedDate.remove(oldReservedDate);
            oldReservedDate.setAddvertisment((Addvertisment)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllReservedDate() {
      if (reservedDate != null)
      {
         ReservedDate oldReservedDate;
         for (java.util.Iterator iter = getIteratorReservedDate(); iter.hasNext();)
         {
            oldReservedDate = (ReservedDate)iter.next();
            iter.remove();
            oldReservedDate.setAddvertisment((Addvertisment)null);
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
         newComment.setAddvertisment(this);      
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
            oldComment.setAddvertisment((Addvertisment)null);
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
            oldComment.setAddvertisment((Addvertisment)null);
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
         newGrade.setAddvertisment(this);      
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
            oldGrade.setAddvertisment((Addvertisment)null);
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
            oldGrade.setAddvertisment((Addvertisment)null);
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
            oldCompany.removeAddvertisment(this);
         }
         if (newCompany != null)
         {
            this.company = newCompany;
            this.company.addAddvertisment(this);
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
            oldUser.removeAddvertisment(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addAddvertisment(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public PriceList getPriceList() {
      return priceList;
   }
   
   /** @pdGenerated default parent setter
     * @param newPriceList */
   public void setPriceList(PriceList newPriceList) {
      if (this.priceList == null || !this.priceList.equals(newPriceList))
      {
         if (this.priceList != null)
         {
            PriceList oldPriceList = this.priceList;
            this.priceList = null;
            oldPriceList.removeAddvertisment(this);
         }
         if (newPriceList != null)
         {
            this.priceList = newPriceList;
            this.priceList.addAddvertisment(this);
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
            oldBrand.removeAddvertisment(this);
         }
         if (newBrand != null)
         {
            this.brand = newBrand;
            this.brand.addAddvertisment(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public FuelType getFuelType() {
      return fuelType;
   }
   
   /** @pdGenerated default parent setter
     * @param newFuelType */
   public void setFuelType(FuelType newFuelType) {
      if (this.fuelType == null || !this.fuelType.equals(newFuelType))
      {
         if (this.fuelType != null)
         {
            FuelType oldFuelType = this.fuelType;
            this.fuelType = null;
            oldFuelType.removeAddvertisment(this);
         }
         if (newFuelType != null)
         {
            this.fuelType = newFuelType;
            this.fuelType.addAddvertisment(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public VehicleClass getVehicleClass() {
      return vehicleClass;
   }
   
   /** @pdGenerated default parent setter
     * @param newVehicleClass */
   public void setVehicleClass(VehicleClass newVehicleClass) {
      if (this.vehicleClass == null || !this.vehicleClass.equals(newVehicleClass))
      {
         if (this.vehicleClass != null)
         {
            VehicleClass oldVehicleClass = this.vehicleClass;
            this.vehicleClass = null;
            oldVehicleClass.removeAddvertisment(this);
         }
         if (newVehicleClass != null)
         {
            this.vehicleClass = newVehicleClass;
            this.vehicleClass.addAddvertisment(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public TransmissionType getTransmissionType() {
      return transmissionType;
   }
   
   /** @pdGenerated default parent setter
     * @param newTransmissionType */
   public void setTransmissionType(TransmissionType newTransmissionType) {
      if (this.transmissionType == null || !this.transmissionType.equals(newTransmissionType))
      {
         if (this.transmissionType != null)
         {
            TransmissionType oldTransmissionType = this.transmissionType;
            this.transmissionType = null;
            oldTransmissionType.removeAddvertisment(this);
         }
         if (newTransmissionType != null)
         {
            this.transmissionType = newTransmissionType;
            this.transmissionType.addAddvertisment(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Model getModel() {
      return model;
   }
   
   /** @pdGenerated default parent setter
     * @param newModel */
   public void setModel(Model newModel) {
      if (this.model == null || !this.model.equals(newModel))
      {
         if (this.model != null)
         {
            Model oldModel = this.model;
            this.model = null;
            oldModel.removeAddvertisment(this);
         }
         if (newModel != null)
         {
            this.model = newModel;
            this.model.addAddvertisment(this);
         }
      }
   }

}
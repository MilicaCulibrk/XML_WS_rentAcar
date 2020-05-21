/***********************************************************************
 * Module:  SearchDTO.java
 * Author:  23nik
 * Purpose: Defines the Class SearchDTO
 ***********************************************************************/

package agentBackend.model;

import java.util.Date;

/** @pdOid 7fb376a3-f09f-4192-a590-f2933eeb1869 */
public class SearchDTO {
   /** @pdOid 648abc2c-abbe-4945-9cd6-1c6798970e30 */
   private Long id;
   /** @pdOid e2bf2a67-f50d-46cb-a50f-566aaf706b72 */
   private Brand Brand;
   /** @pdOid c532b21c-d2f6-418a-8237-c3e1701ebd32 */
   private Model Model;
   /** @pdOid 642edecf-4772-4677-a74d-6414f920de54 */
   private FuelType FuelType;
   /** @pdOid 6353b339-c4ce-4b6b-b733-f1223eca637a */
   private TransmissionType TransmissionType;
   /** @pdOid 7ef18538-360e-4ebb-84e8-686e96190101 */
   private VehicleClass vehicleClass;
   /** @pdOid dec78d1c-13be-47bf-899d-a84d691398cf */
   private float dailyPrice;
   /** @pdOid 2785164f-3388-42cd-a6ae-14d0fc6559b0 */
   private float mileage;
   /** @pdOid f9fb70df-6358-4ad2-87c1-3213202041c9 */
   private boolean cdw;
   /** @pdOid 9ba4cff1-f254-42df-912d-a0c2dcca78aa */
   private int childSeat;
   /** @pdOid 15ffb376-d417-4de6-ba87-9c3514047be1 */
   private String location;
   /** @pdOid 94741e3c-4972-44f1-a8a8-c8dc1d2dd7c9 */
   private Date dateTo;
   /** @pdOid 4e79b69e-cbb5-4775-9acd-030421aaccdf */
   private Date dateFrom;

}
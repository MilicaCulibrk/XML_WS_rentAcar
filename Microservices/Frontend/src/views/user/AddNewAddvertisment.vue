
<template>

  <div>
        <!-- Snackbar -->
    <v-snackbar v-model="snackbarSuccess" :timeout="3500" top color="success">
      <span>{{snackbarSuccessText}}</span>
      <v-btn text @click="snackbarSuccess = false">Close</v-btn>
    </v-snackbar>
    <v-snackbar v-model="snackbarDanger" :timeout="3500" top color="danger">
      <span>{{snackbarDangerText}}</span>
      <v-btn text @click="snackbarDanger = false">Close</v-btn>
    </v-snackbar>
    <v-alert v-if="user.number_of_addvertisment>=3"       
      dense
      outlined
      type="error">
      We are sorry, this page is not visible for you anymore. You have reached the limit of adds.
    </v-alert>
    <div v-else>
    <v-container>
      <v-card class="detailsBorderColor">
        <v-card-title>
          <span class="primary--text font-italic headline" primary-title>New Addvertisement</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-form ref="form">
              <v-row>
                <v-col cols="4">
                  <v-combobox
                    v-model="selectBrand"
                    :items="brandItems"
                    item-value="brandItems"
                    item-text="brand_name"
                    label="Brand"
                    outlined
                    dense
                    class="pt-4"
                    color="primary"
                  ></v-combobox>
                </v-col>
                <v-col cols="4">
                  <div v-if="selectBrand!=''" @click="getModels">
                    <v-combobox
                      v-model="selectModel"
                      :items="modelItems"
                      item-value="modelItems"
                      item-text="vehicle_model_name"
                      label="Model"
                      outlined
                      dense
                      class="pt-4"
                      color="primary"
                    ></v-combobox>
                  </div>
                </v-col>
              </v-row>
              <v-row class="mt-n8">
                <v-col cols="4">
                  <v-combobox
                    v-model="selectTransmission"
                    :items="transmissionTypeItems"
                    item-value="transmissionTypeItems"
                    item-text="transmission_type_name"
                    label="Transmission type"
                    outlined
                    dense
                    class="pt-4"
                    color="primary"
                  ></v-combobox>
                </v-col>
                <v-col cols="4">
                  <v-combobox
                    v-model="selectFuelType"
                    :items="fuelTypeItems"
                    item-value="fuelTypeItems"
                    item-text="fuel_type_name"
                    label="Gas type"
                    outlined
                    dense
                    class="pt-4"
                    color="primary"
                  ></v-combobox>
                </v-col>
                <v-col cols="4">
                  <v-combobox
                    v-model="selectChildSeats"
                    :items="childSeatsItems"
                    label="Number of child seats"
                    outlined
                    dense
                    class="pt-4"
                    color="primary"
                  ></v-combobox>
                </v-col>
              </v-row>
              <v-row class="mt-n8">
                <v-col cols="4">
                  <v-combobox
                    v-model="selectClass"
                    :items="vehicleClassItems"
                    item-value="vehicleClassItems"
                    item-text="vehicle_class_name"
                    label="Class"
                    outlined
                    dense
                    class="pt-4"
                    color="primary"
                  ></v-combobox>
                </v-col>
                <v-col cols="4">
                  <v-text-field
                    label="Location*"
                    color="black"
                    v-model="selectLocation"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="4">
                  <v-checkbox
                    label="Do you want to include CWD option?"
                    :v-model="selectCdw"
                    
                    color="primary"
                  ></v-checkbox>
                </v-col>
              </v-row>
              <v-row class="mt-n8">
                <v-col cols="4">
                  <v-dialog
                    ref="dialog"
                    v-model="modal"
                    :return-value.sync="dates"
                    persistent
                    full-width
                    max-width="370px"
                    min-width="370px"
                    color="primary"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field
                        v-model="dates"
                        label="Disable dates"
                        prepend-icon="event"
                        readonly
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      v-model="dates"
                      scrollable
                      color="primary"
                      range
                      :min="nowDate"
                      :events="addvertisment.arrayEvents"
                      event-color="red"
                    >
                      <v-spacer></v-spacer>
                      <v-btn text color="primary" @click="modal = false">Close</v-btn>
                      <v-btn text color="primary" @click="reserveDate(dates)">Disable dates</v-btn>
                      <v-btn text color="primary" @click="enableDate(dates)">Enable dates</v-btn>
                    </v-date-picker>
                  </v-dialog>
                </v-col>
                <v-col cols="4">
                  <v-text-field
                    label="Mileage*"
                    color="black"
                    v-model="selectMileage"
                    required
                    suffix="KM"
                  ></v-text-field>
                </v-col>
                <v-col cols="4">
                  <v-text-field
                    label="Mileage Limit*"
                    color="black"
                    v-model="selectMileageLimit"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row class="mt-n8">
                <v-col cols="4" style="margin-top: 30px;">
                  <div class="my-2">
                  <Pricelist v-bind:addvertisment="addvertisment"></Pricelist>
                  </div>
                </v-col>
                <v-col cols="8" style="margin-top: 30px;">
                  <template>
                    <div class="form-group">
                      <label for="addvertisment_image">Upload images for your addvertisement:</label>
                      <input
                        type="file"
                        @change="uploadImage"
                        class="form-control"
                        style="margin-left: 20px;"
                      />
                    </div>
                    <div class="form-group d-flex">
                      <div class="p-1" v-for="(image, index) in addvertisment.images" :key="index">
                        <div class="img-wrapp">
                          <img :src="image" alt width="80px" />
                          <span class="delete-img" @click="deleteImage(image,index)">X</span>
                        </div>
                      </div>
                    </div>
                  </template>
                </v-col>
              </v-row>
            </v-form>
          </v-container>
        </v-card-text>
        <v-card-actions class="pr-10 pb-10">
          <v-spacer></v-spacer>
          <v-btn text color="primary" @click="quit">Quit</v-btn>
          <v-btn color="primary" @click="addNewAddvertisment">Add new</v-btn>
        </v-card-actions>
      </v-card>
    </v-container>
  </div>
  </div>
</template>
  <script>
import axios from "axios";
import { fb, db } from "@/firebase";
import Pricelist from "@/views/agent/Pricelist";
export default {
  components: { Pricelist},
  data() {
    return {
      name: "Addvertisments",
      user: {
        number_of_addvertisment: 0,
      },
      addvertisments: [],
      selectBrand: "",
      selectModel: "",
      selectClass: "",
      selectTransmission: "",
      selectFuelType: "",
      selectMileage: "",
      selectPrice: "",
      selectChildSeats: "",
      selectLocation: "",
      selectCdw: false,
      selectMileageLimit: "",

      addvertisment: {
        brand_id: "",
        fuel_type_id: "",
        vehicle_model_id: "",
        vehicle_class_id: "",
        transmission_type_id: "",
        mileage: "",
        mileage_limit: "",
        cdw: "",
        child_seats: "",
        location: "",
        price: "",
        images: [],
        arrayEvents: [],
        addvertiser_id: "",
        pricelist: [],
      },
      snackbarSuccess: false,
      snackbarSuccessText: "",
      snackbarDanger: false,
      snackbarDangerText: "",
      modelItems: [],
      brandItems: [],
      vehicleClassItems: [],
      transmissionTypeItems: [],
      fuelTypeItems: [],
      childSeatsItems: ["0", "1", "2", "3", "4", "5"],
      plannedToCrossRule: [
        v => /^[0-9]*$/.test(v) || "Only numbers are allowed"
      ],
      nowDate: new Date().toISOString().slice(0, 10) + 2,
      dates: [],
      modal: false
    };
  },

  firestore() {
    return {
      addvertisments: db.collection("addvertisments")
    };
  },

  methods: {
    getModels() {
      axios
        .get("/addvertisment-service/brand/" + this.selectBrand.id + "/model")
        .then(modelItems => {
          this.modelItems = modelItems.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    deleteImage(img, index) {
      let image = fb.storage().refFromURL(img);
      this.addvertisment.images.splice(index, 1);
      image
        .delete()
        .then(function() {
          console.log("image deleted");
        })
        .catch(function() {
          // Uh-oh, an error occurred!
          console.log("an error occurred");
        });
    },
    uploadImage(e) {
      if (e.target.files[0]) {
        let file = e.target.files[0];
        var storageRef = fb
          .storage()
          .ref("addvertisments/" + Math.random() + "_" + file.name);
        let uploadTask = storageRef.put(file);
        uploadTask.on(
          "state_changed",
          () => {},
          () => {},
          () => {
            uploadTask.snapshot.ref.getDownloadURL().then(downloadURL => {
              this.addvertisment.images.push(downloadURL);
            });
          }
        );
      }
    },

    reserveDate(dates) {
      var startDate = new Date(dates[0]);
      var endDate = new Date(dates[1]);
      var arr = new Array();
      var dt = new Date(startDate);
      if (dt < endDate) {
        while (dt <= endDate) {
          arr.push(new Date(dt).toISOString().substr(0, 10));
          dt.setDate(dt.getDate() + 1);
        }
      } else {
        while (endDate <= dt) {
          arr.push(new Date(endDate).toISOString().substr(0, 10));
          endDate.setDate(endDate.getDate() + 1);
        }

      }
      for (const d in arr) {
        this.addvertisment.arrayEvents.push(arr[d]);
      }
    },

    enableDate(dates){
            var startDate = new Date(dates[0]);
            var endDate = new Date(dates[1]);
            var  arr = new Array();
            var  dt = new Date(startDate);
            if(dt<endDate){
            while (dt <= endDate) {
                arr.push(new Date(dt).toISOString().substr(0, 10));
                dt.setDate(dt.getDate() + 1);
            }
            }else{
                while (endDate <= dt) {
                arr.push(new Date(endDate).toISOString().substr(0, 10));
                endDate.setDate(endDate.getDate() + 1);
            }
            }
            for(const d in arr){
            this.addvertisment.arrayEvents = this.addvertisment.arrayEvents.filter(word => word != arr[d]);
        }
        },
    quit() {
      this.$router.push("/");
    },
    addNewAddvertisment(){
      
      if(this.selectBrand=="" || this.selectFuelType=="" || this.selectModel=="" || this.selectClass==""  || this.selectTransmission=="" || this.selectMileage=="" || this.selectMileageLimit=="" || this.selectChildSeats=="" || this.selectLocation=="" || this.addvertisment.pricelist==""){
        this.snackbarDanger = true;
        this.snackbarDangerText="You need to fill all fileds!";
        return;
      }
      var rex = /^[0-9]*$/;
      if(!rex.test(String(this.selectMileage.trim())) || !rex.test(String(this.selectMileageLimit.trim())) || !rex.test(String(this.selectPrice.trim())) ){
          return;
      }
      this.addvertisment.brand_id = this.selectBrand.id;
      this.addvertisment.fuel_type_id = this.selectFuelType.id;
      this.addvertisment.vehicle_model_id = this.selectModel.id;
      this.addvertisment.vehicle_class_id = this.selectClass.id;
      this.addvertisment.transmission_type_id = this.selectTransmission.id;
      this.addvertisment.mileage = this.selectMileage;
      this.addvertisment.mileage_limit = this.selectMileageLimit;
      this.addvertisment.cdw = this.selectCdw;
      this.addvertisment.child_seats = this.selectChildSeats;
      this.addvertisment.location = this.selectLocation;
      this.addvertisment.addvertiser_id = this.$store.state.user.username;
      this.addvertisment.images = this.createListImages(
        this.addvertisment.images
      );
      this.addvertisment.arrayEvents = this.createListDates(
        this.addvertisment.arrayEvents
      );
      axios
        .post("/addvertisment-service/addvertisment", this.addvertisment)
        .then(() => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "You added new addvertisement!";
          this.setOnEmptyString();
          if(this.$store.state.user.role=='USER'){
            this.incrementAdds();
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    setOnEmptyString() {
      this.selectBrand = "";
      this.selectFuelType = "";
      this.selectModel = "";
      this.selectClass = "";
      this.selectTransmission = "";
      this.selectMileage = "";
      this.selectMileageLimit = "";
      this.selectChildSeats = "";
      this.selectLocation = "";
      this.selectPrice = "";
      this.selectCdw = false;
      this.addvertisment.images = [];
      this.addvertisment.arrayEvents = [];
      this.addvertisment.brand_id = "";
      this.addvertisment.fuel_type_id = "";
      this.addvertisment.vehicle_model_id = "";
      this.addvertisment.vehicle_class_id = "";
      this.addvertisment.transmission_type_id = "";
      this.addvertisment.mileage = "";
      this.addvertisment.mileage_limit = "";
      this.addvertisment.cdw = false;
      this.addvertisment.child_seats = "";
      this.addvertisment.location = "";
      this.addvertisment.price = "";
      this.addvertisment.addvertiser_id = "";
      this.addvertisment.pricelist = '';    
    },
    checkUser(){
      if((this.$store.state.user.role)=='USER'){
          axios
        .get("/user-service/user/" +  this.$store.state.user.id)
        .then(response => {
          this.user = response.data;
          this.number_of_addvertisment = this.user.number_of_addvertisment;
        })
        .catch(error => {
          console.log(error);
        });
      }
    },
    incrementAdds(){
      this.user.number_of_addvertisment = this.user.number_of_addvertisment + 1;
        axios
      .put("/user-service/user", this.user)
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        this.snackbarDanger = true;
        this.snackbarDangerText=error;
      });
    },
    createListImages(images) {
      var listImages = [];
      for (const i in images) {
        var image = { id: "", url: "" };
        image.url = images[i];
        listImages.push(image);
      }
      return listImages;
    },
    createListDates(arrayEvents){
          var listDates=[];
        for(const i in arrayEvents){
            var arrayEvent={ id:"", oneDate:"" };
            arrayEvent.oneDate=arrayEvents[i];
            listDates.push(arrayEvent);
        }
        return listDates;
      },
    },
  computed: {
    dateRangeText() {
      return this.dates.join(" ~ ");
    }
  },
  

  mounted() {
    //izlistavanje brendova
    this.checkUser();
    axios
      .get("/addvertisment-service/brand")
      .then(brandItems => {
        this.brandItems = brandItems.data;
      })
      .catch(error => {
        console.log(error);
      });
    //izlistavanje klasa
    axios
      .get("/addvertisment-service/vehicle_class")
      .then(vehicleClassItems => {
        this.vehicleClassItems = vehicleClassItems.data;
       
      })
      .catch(error => {
        console.log(error);
      });
    //izlistavanje tipova menjaca
    axios
      .get("/addvertisment-service/transmission_type")
      .then(transmissionTypeItems => {
        this.transmissionTypeItems = transmissionTypeItems.data;
       
      })
      .catch(error => {
        console.log(error);
      });
    //izlistavanje tipova goriva
    axios
      .get("/addvertisment-service/fuel_type")
      .then(fuelTypeItems => {
        this.fuelTypeItems = fuelTypeItems.data;
       
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>
  
  <style scoped>
.cardBorderColor {
  border-left: 1px solid #fbc02d;
  border-top: 1px solid #fbc02d;
  border-right: 1px solid #fbc02d;
  border-bottom: 1px solid #fbc02d;
}
.image-div {
  display: flex;
  margin: 25px;
}
.image {
  max-width: 100px;
  max-height: 100px;
  margin: 10px;
}
.img-wrapp {
  position: relative;
  max-width: 100px;
  max-height: 100px;
  margin: 10px;
}
.img-wrapp span.delete-img {
  position: absolute;
  top: -14px;
  left: -2px;
}
.img-wrapp span.delete-img:hover {
  cursor: pointer;
}
</style>
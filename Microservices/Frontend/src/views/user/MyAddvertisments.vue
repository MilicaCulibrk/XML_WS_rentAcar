<template>
  <div>
    <v-container class="my-5">
      <v-layout row wrap>
        <v-flex
          xs12
          sm6
          md4
          lg4
          v-for="addvertisment in addvertisments"
          :key="addvertisment.id"
        >
          <v-card class="text-center ma-6">
            <div class="detailsBorderColor">
              <v-responsive class="pt-4" style="height:190px;">
                <carousel :perPage="1">
                  <slide
                    v-for="(image, index) in addvertisment.images"
                    :key="index"
                  >
                    <img :src="image.url" height="100px" />
                  </slide>
                </carousel>
              </v-responsive>
              <v-card-title></v-card-title>
              <v-card-text>
                <div class="primary--text font-weight-bold headline">
                  {{ addvertisment.brand_name }}
                  {{ addvertisment.vehicle_model_name }}
                </div>
                <div>Price: {{ addvertisment.price }}</div>
              </v-card-text>
              <v-card-actions>
                <v-menu
                  v-model="modals[addvertisment.id]"
                  :close-on-content-click="false"
                  :return-value.sync="dates"
                  :nudge-right="40"
                  lazy
                  transition="scale-transition"
                  offset-y
                  full-width
                  max-width="290px"
                  min-width="290px"
                >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      label="Disable dates"
                      prepend-icon="event"
                      readonly
                      v-on="on"
                      @click="findReservedDates(addvertisment.id)"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    v-model="dates"
                    scrollable
                    color="primary"
                    range
                    :min="nowDate"
                    :events="reservedOneDate"
                    event-color="red"
                  >
                    <v-spacer></v-spacer>
                    <v-btn text color="primary" @click="reserveDate(dates)"
                      >Disable dates</v-btn
                    >
                  </v-date-picker>
                </v-menu>

                <EditAddvertisment
                  v-bind:addvertisment="addvertisment"
                ></EditAddvertisment>

                <DeleteAddvertisment
                  @loadAddvertisments="loadAddvertisments()"
                  v-bind:addvertisment="addvertisment"
                ></DeleteAddvertisment>
              </v-card-actions>
            </div>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";
import { fb, db } from "@/firebase";
import EditAddvertisment from "@/views/user/EditAddvertisment";
import DeleteAddvertisment from "@/views/user/DeleteAddvertisment";
export default {
  components: { EditAddvertisment, DeleteAddvertisment },
  data() {
    return {
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
      modals: [],
      addvertisment: {
        /* brand_id: "",
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
        addvertiser_id: "",*/
      },
      add_id: "",
      modelItems: [],
      brandItems: [],
      vehicleClassItems: [],
      transmissionTypeItems: [],
      fuelTypeItems: [],
      childSeatsItems: ["0", "1", "2", "3", "4", "5"],
      dialogCalendar: false,
      addvertisments: {},
      dates: [],
      nowDate: new Date().toISOString().slice(0, 10) + 2,
      reservedDates: [],
      reservedOneDate: [],
      requests: {},
    };
  },
  firestore() {
    return {
      addvertisments: db.collection("addvertisments"),
    };
  },
  methods: {
    findReservedDates(id) {
      this.add_id = id;
      axios
        .get("/addvertisment-service/reservedDate/" + id)
        .then((reservedDates) => {
          this.reservedDates = reservedDates.data;
          this.reservedOneDate = [];
          for (const i in this.reservedDates) {
            this.reservedOneDate.push(this.reservedDates[i].oneDate);
          }
        })
        .catch((error) => {
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
            uploadTask.snapshot.ref.getDownloadURL().then((downloadURL) => {
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
        this.reservedOneDate.push(arr[d]);
      }
      axios
        .post(
          "/addvertisment-service/reservedDate/" + this.add_id,
          this.createListDates(arr)
        )
        .then((response) => {
          console.log(response);
          var i = 0;
          for (i = 0; i < this.modals.length; i++) {
            this.modals[i] = false;
          }
          this.getRequests(dates[0], dates[1]);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    createListDates(arrayEvents) {
      var listDates = [];
      for (const i in arrayEvents) {
        var arrayEvent = { id: "", oneDate: "" };
        arrayEvent.oneDate = arrayEvents[i];
        listDates.push(arrayEvent);
      }
      return listDates;
    },
    getRequests(start, end) {
      var newStart = new Date(start);
      var newEnd = new Date(end);
      axios
        .get("/rent-service/request/to/" + this.$store.state.user.username)
        .then((requests) => {
          this.requests = requests.data;
          this.requests.forEach((request) => {
            request.purchaseDTOS.forEach((purchase) => {
              var startDate = new Date(purchase.date_from);
              var endDate = new Date(purchase.date_to);
              if (
                !(
                  (startDate < newStart && endDate < newStart) ||
                  (startDate > newEnd && endDate > newEnd)
                )
              ) {
                this.declineRequest(request.id);
              }
            });
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    declineRequest(id) {
      axios
        .put("/rent-service/request/decline/" + id)
        .then((response) => {
          this.snackbarSuccess = true;
          this.snackbarSuccessText = "Request is canceled!";
          console.log(response);
        })
        .catch((error) => {
          this.snackbarDanger = true;
          this.snackbarDangerText = "Error";
          console.log(error);
        });
    },
    loadAddvertisments() {
      axios
        .get(
          "/addvertisment-service/addvertisment/user/" +
            this.$store.state.user.username
        )
        .then((addvertisments) => {
          this.addvertisments = addvertisments.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },

  mounted() {
    //izlistavanje brendova
    axios
      .get("/addvertisment-service/brand")
      .then((brandItems) => {
        this.brandItems = brandItems.data;
      })
      .catch((error) => {
        console.log(error);
      });
    //izlistavanje klasa
    axios
      .get("/addvertisment-service/vehicle_class")
      .then((vehicleClassItems) => {
        this.vehicleClassItems = vehicleClassItems.data;
      })
      .catch((error) => {
        console.log(error);
      });
    //izlistavanje tipova menjaca
    axios
      .get("/addvertisment-service/transmission_type")
      .then((transmissionTypeItems) => {
        this.transmissionTypeItems = transmissionTypeItems.data;
      })
      .catch((error) => {
        console.log(error);
      });
    //izlistavanje tipova goriva
    axios
      .get("/addvertisment-service/fuel_type")
      .then((fuelTypeItems) => {
        this.fuelTypeItems = fuelTypeItems.data;
      })
      .catch((error) => {
        console.log(error);
      });

    //izlistavanje oglasa
    axios
      .get(
        "/addvertisment-service/addvertisment/user/" +
          this.$store.state.user.username
      )
      .then((addvertisments) => {
        this.addvertisments = addvertisments.data;

        var i = 0;
        for (i = 0; i < this.addvertisments.length; i++) {
          this.modals.push("modal" + i);
          this.modals[i] = false;
        }
        console.log(this.addvertisments);
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>
<style>
.cardBorderColor {
  border-left: 1px solid #fbc02d;
  border-top: 1px solid #fbc02d;
  border-right: 1px solid #fbc02d;
  border-bottom: 1px solid #fbc02d;
}

.detailsBorderColor {
  border-left: 1.5px solid #fbc02d;
  border-top: 1.5px solid #fbc02d;
  border-right: 1.5px solid #fbc02d;
  border-bottom: 1.5px solid #fbc02d;
}
</style>

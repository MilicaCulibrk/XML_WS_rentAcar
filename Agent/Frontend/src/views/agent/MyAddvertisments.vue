<template>
  <div>
    <v-container class="my-5">
      <v-layout row wrap>
        <v-flex xs12 sm6 md4 lg4 v-for="addvertisment in addvertisments" :key="addvertisment.id">
          <v-card hover elevation="2" class="text-center ma-6">
            <div class="cardBorderColor">
              <v-responsive class="pt-4">
                <img :src="addvertisment.images[0].url" height="130px" />
              </v-responsive>
              <v-card-title></v-card-title>
              <v-card-text>
                <div
                  class="primary--text font-weight-bold headline"
                >{{ addvertisment.brand_name }} {{ addvertisment.vehicle_model_name}}</div>
                <div>Price: {{ addvertisment.price }}</div>
              </v-card-text>
              <v-card-actions>
                <!-- komponenta detalji o autu-->
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
                      @click="findReservedDates(addvertisment.id)"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                    v-model="dates"
                    scrollable
                    color="primary"
                    range
                    :min="nowDate "
                    :events="reservedOneDate"
                    event-color="red"
                  >
                    <v-spacer></v-spacer>
                    <v-btn text color="primary" @click="modal = false">Close</v-btn>
                    <v-btn
                      text
                      color="primary"
                      @click="reserveDate(dates,addvertisment.id)"
                    >Disable dates</v-btn>
                  </v-date-picker>
                </v-dialog>
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
export default {
  data() {
    return {
      dialogCalendar: false,
      addvertisments: {},
      dates: [],
      modal: false,
      nowDate: new Date().toISOString().slice(0, 10) + 2,
      reservedDates: [],
      reservedOneDate: []
    };
  },

  methods: {
    findReservedDates(id) {
      axios
        .get("/reservedDate/" + id)
        .then(reservedDates => {
          this.reservedDates = reservedDates.data;

          this.reservedOneDate = [];
          for (const i in this.reservedDates) {
            console.log(this.reservedDates[i]);
            this.reservedOneDate.push(this.reservedDates[i].oneDate);
          }
        })
        .catch(error => {
          console.log(error);
        });
      console.log(this.reservedOneDate);
    },
    reserveDate(dates, id) {
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
        .post("/reservedDate/" + id, this.createListDates(arr))
        .then(response => {
          console.log(response);
        })
        .catch(error => {
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
    }
  },
  mounted() {
    //izlistavanje oglasa
    axios
      .get("/addvertisment/user/" + this.$store.state.user.id)
      .then(addvertisments => {
        this.addvertisments = addvertisments.data;
      })
      .catch(error => {
        console.log(error);
      });
  }
};
</script>

<style scoped>
.cardBorderColor {
  border-left: 1px solid #ff8a65;
  border-top: 1px solid #ff8a65;
  border-right: 1px solid #ff8a65;
  border-bottom: 1px solid #ff8a65;
}
.detailsBorderColor {
  border-left: 1.5px solid #ff8a65;
  border-top: 1.5px solid #ff8a65;
  border-right: 1.5px solid #ff8a65;
  border-bottom: 1.5px solid #ff8a65;
}
</style>
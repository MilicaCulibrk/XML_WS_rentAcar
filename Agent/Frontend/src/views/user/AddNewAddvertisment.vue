<template>
    <div>
        <v-container class="pt-12 mt-12">
        <v-card class="cardBorderColor">
          <v-card-title>
            <span class="primary--text font-italic headline" primary-title>New Addvertisement</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-form ref="form">
                <v-row>
                    <!-- brend -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectBrand"
                        :items="brandItems"
                        label="Brand"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                    <!-- menjac -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectTransmission"
                        :items="transmissionItems"
                        label="Transmission type"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                    <!-- cena -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectPrice"
                        :items="priceItems"
                        label="Price"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                  </v-row>
                  <!-- drugi red -->
                  <v-row class="mt-n8">
                    <!-- model -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectModel"
                        :items="modelItems"
                        label="Model"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                    <!-- gas -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectGas"
                        :items="gasItems"
                        label="Gas type"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                    <!-- gas -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectChildSeats"
                        :items="childSeatsItems"
                        label="Number of child seats"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                  </v-row>
                  <!-- treci red -->
                  <v-row class="mt-n8">
                    <!-- klasa -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectClass"
                        :items="classItems"
                        label="Class"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                    <!-- kilometraza -->
                    <v-col cols="4">
                      <v-combobox
                        v-model="selectMileage"
                        :items="mileageItems"
                        label="Mileage"
                        multiple
                        outlined
                        dense
                        class="pt-4"
                        color="primary"
                      ></v-combobox>
                    </v-col>
                   
                   
                    <!-- CDW -->
                    <v-col cols="2">
                      <v-checkbox label="CWD" :v-model="cdw" color="primary"></v-checkbox>
                    </v-col>
                  </v-row>
                
              </v-form>
            </v-container>
          </v-card-text>
          <v-card-actions class="pr-10 pb-10">
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="close">Close</v-btn>
            <v-btn color="primary" @click="register">Register</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
   
</v-container class="pt-12 mt-12">
</div>
  </template>
  
  <script>
  export default {
    data: () => ({
      RegisterDialog: false,
      cdw: false,
      brandItems: ["BMW", "Audi", "Mercedes", "Tesla"],
      modelItems: ["M5", "R8", "X6"],
      classItems: ["SUV", "oldtimer", "city-car"],
      transmissionItems: ["manual", "automatic", "semi-automatic"],
      gasItems: ["gasoline", "gas", "diesel"],
      mileageItems: ["50.000-100.000", "100.000-200.000", "200.000-300.000"],
      priceItems: ["10.000-20.000", "20.000-30.000", "30.000-40.000"],
      childSeatsItems: ["0", "1", "2", "3", "4", "5"],
      user: {
        name: "",
        surname: "",
        number: "",
        adrress: "",
        city: "",
        email: "",
        password: ""
      },
      confirmation: "",
      requiredRules: [v => !!v || "This field is required"],
      passwordRules: [
        v => !!v || "This is required",
        v => v == this.confirmation || "Passwords do not match"
      ],
      emailRules: [
        v => !!v || "This field is required",
        v => /.+@.+\..+/.test(v) || "E-mail must be valid"
      ]
    }),
    computed: {
      passwordConfirmationRule() {
        return () =>
          this.user.password === this.confirmation || "Passwords must match";
      }
    },
    methods: {
      register() {
        if (this.$refs.form.validate()) {
          console.log(this.user.name);
          this.close();
        } else {
          console.log("nije validno");
        }
      },
      close() {
        this.RegisterDialog = false;
        this.$refs.form.reset();
      }
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
  </style>
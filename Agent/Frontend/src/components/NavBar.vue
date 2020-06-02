
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
                    <v-col cols="4">
                        <v-text-field
                        label="Price*"
                        color="black"
                        :v-model="price"
                        required
                        :rules="requiredRules"
                        suffix="DIN"
                      ></v-text-field>
                    </v-col>
                  </v-row>
                  <v-row class="mt-n8">
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
                  <v-row class="mt-n8">
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
                    <v-col cols="4">
                        <v-text-field
                        label="Mileage*"
                        color="black"
                        :v-model="mileage"
                        required
                        :rules="requiredRules"
                        suffix="KM"
                      ></v-text-field>
                    </v-col>
                    <v-col cols="4">
                      <v-checkbox label="Do you want to include CWD option?" :v-model="cdw" color="primary"></v-checkbox>
                    </v-col>
                  </v-row>
                  <v-row class="mt-n8">
                    <v-col cols="4" >
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
                          <v-date-picker  v-model="dates" scrollable  color="primary" range 
                          :min="nowDate"
                            :events="arrayEvents"
                            event-color="red">
                              
                            <v-spacer></v-spacer>
                            <v-btn text color="primary" @click="modal = false">Close</v-btn>
                            <v-btn text color="primary" @click="reserveDate(dates)" >Disable dates</v-btn>
                            <v-btn text color="primary"  @click="enableDate(dates)" >Enable dates</v-btn>
                          </v-date-picker>
                        </v-dialog>
                      </v-col>
                    </v-row>
                  <v-row class="mt-n8">
                      <v-col cols="12" >
                      <template>
                        <div id="app">
                            <vue-dropzone
                              ref="imgDropZone"
                              id="customdropzone"
                              :options="dropzoneOptions"
                              @vdropzone-complete="afterComplete"
                            ></vue-dropzone>
                            
                            <div class="form-group d-flex">
                                <div class="p-1" v-for="(image, index) in images" :key="image.src">
                                    <div class="img-wrapp">
                                        <img :src="image.src" alt="" width="80px">
                                        <span class="delete-img" @click="deleteImage(image,index)">X</span>
                                    </div>
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
            <v-btn color="primary">Add new addvertisement</v-btn>
          </v-card-actions>
        </v-card>
</v-container >
</div>
  </template>
  
  <script>
import firebase from "firebase";
import vue2Dropzone from "vue2-dropzone";
import "vue2-dropzone/dist/vue2Dropzone.min.css";
let uuid = require("uuid");


  export default {

    components: {
    vueDropzone: vue2Dropzone
  },
    data: () => ({
        dropzoneOptions: {
        url: "https://httpbin.org/post",
        thumbnailWidth: 150,
        thumbnailHeight: 150,
        addRemoveLinks: false,
        acceptedFiles: ".jpg, .jpeg, .png",
        dictDefaultMessage: `<p class='text-default'><i class='fa fa-cloud-upload mr-2'></i> Drag Images or Click Here</p>
          <p class="form-text">Allowed Files: .jpg, .jpeg, .png</p>
          `
      },
      images: [],
      selectBrand: [],
      selectModel: [],
      selectClass: [],
      selectTransmission: [],
      selectGas: [],
      selectMileage: [],
      selectPrice: [],
      selectChildSeats: [],
      reservedDates: [],
      cdw: false,
      price: null,
      mileage: null,
      brandItems: ["BMW", "Audi", "Mercedes", "Tesla"],
      modelItems: ["M5", "R8", "X6"],
      classItems: ["SUV", "oldtimer", "city-car"],
      transmissionItems: ["manual", "automatic", "semi-automatic"],
      gasItems: ["gasoline", "gas", "diesel"],
      childSeatsItems: ["0", "1", "2", "3", "4", "5"],
      confirmation: "",
      requiredRules: [v => !!v || "This field is required"],
      nowDate: new Date().toISOString().slice(0, 10) + 2,
      dates: [],
      modal: false,
      arrayEvents: [],
    }),
  
   
 
    methods: {

        async afterComplete(upload) {
            var imageName = uuid.v1();
            this.isLoading = true;
            try {
                //save image
                let file = upload;
                var metadata = {
                contentType: "image/png"
                };
                var storageRef = firebase.storage().ref();
                var imageRef = storageRef.child(`images/${imageName}.png`);
                await imageRef.put(file, metadata);
                var downloadURL = await imageRef.getDownloadURL();
                this.images.push({ src: downloadURL });
            } catch (error) {
                console.log(error);
            }
            this.$refs.imgDropZone.removeFile(upload);
         },
         deleteImage(img,index){
             console.log(index);
      let image = firebase.storage().refFromURL(img);
      this.images.splice(index,1);
      image.delete().then(function() {
        console.log('image deleted');
      }).catch(function() {
        // Uh-oh, an error occurred!
        console.log('an error occurred');
      });
    },
        reserveDate(dates){

           
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
                 this.arrayEvents.push(arr[d]);
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
            this.arrayEvents = this.arrayEvents.filter(word => word != arr[d]);
        }
        },
       

      quit() {
       
        this.$router.push("/");
      },
      
    },
    computed: {
      dateRangeText () {
        return this.dates.join(' ~ ')
      },
    },
  };
 
  
  </script>
  
  <style scoped>
  .cardBorderColor {
    border-left: 1px solid #FBC02D;
  border-top: 1px solid #FBC02D;
  border-right: 1px solid #FBC02D;
  border-bottom: 1px solid #FBC02D;
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
.img-wrapp{
  position: relative;
}
.img-wrapp span.delete-img{
    position: absolute;
    top: -14px;
    left: -2px;
}
.img-wrapp span.delete-img:hover{
    cursor: pointer;
}

  </style>
<template >
    <div class="messaging">
        <div class="inbox_msg">
          <div class="inbox_people">
            <div class="headind_srch">
              <div class="recent_heading">
                <h4>Recent</h4>
              </div>
            </div>
            <div class="inbox_chat scroll">
            <v-list dense class="chat_list">
              <v-list-item-group color="primary"   >
                <v-list-item
                v-for="user in users"  :key="user.username"   @click="showConversation(user.username)" 
                >
                <div class="chat_people"  >
                  <p></p>
                  <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                  <div class="chat_ib">
                  <v-list-item-content >
                    <v-list-item-title v-text="user.name + ' ' + user.surname" ></v-list-item-title>
                  </v-list-item-content>
                  <p></p>
                  </div>
                </div>
                </v-list-item>
                <v-list-item
                v-for="(company,idx) in companies"  :key="idx"  @click="showConversation(company.username)" 
                >
                <div class="chat_people"  >
                  <p></p>
                  <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                  <div class="chat_ib">
                  <v-list-item-content >
                    <v-list-item-title v-text="company.name" ></v-list-item-title>
                  </v-list-item-content>
                  <p></p>
                  </div>
                </div>
                </v-list-item>
              </v-list-item-group>
            </v-list>
            </div>
          </div>
          <div class="mesgs">
            <div class="msg_history">
              <div v-for="message in messagesShow"  v-bind:key="message.id">

                  <div :class="[message.author== $store.state.user.username?'sent_msg':'received_msg']">
                  <div class="received_withd_msg">
                    <p>{{message.message}}</p>
                    <span class="time_date"> {{message.author}}, {{(String(message.createdAt.toDate())).split(":")[0]}}:{{(String(message.createdAt.toDate())).split(":")[1]}}</span></div>
                  </div>
              </div>
            </div>
            <div class="type_msg" v-if="this.username!=''">
              <div class="input_msg_write">
                <input @keyup.enter="saveMessage()" v-model="message" type="text" class="write_msg" placeholder="Type a message" />
              </div>
            </div>
          </div>
        </div>
      </div>
</template>

<script>
import { db} from "@/firebase";
import axios from "axios";
export default {
    data(){
        return{
            message:null,
            messages:[],
            users: [],
            allUsers:[],
            messagesShow:[],
            user:{},
            username: "",
            allPurchases: [],
            allCompanies: [],
            companies: [],
            company: {},
        }
    },
    methods:{
      showConversation(username){
        this.messagesShow=[];
        this.username=username;
        db.collection('chat').orderBy('createdAt').onSnapshot((querySnapshot)=>{
            let allMessages=[];
            this.messagesShow=[];
            querySnapshot.forEach(doc=>{
            allMessages.push(doc.data())
            })
            this.messages=allMessages;
            for(const mes in this.messages){
            if(this.messages[mes].username==this.username && this.messages[mes].author==this.$store.state.user.username || this.messages[mes].author==this.username && this.messages[mes].username==this.$store.state.user.username){
             this.messagesShow.push(this.messages[mes]);
              } 
             }
           setTimeout(()=>{
              this.scrollToBottom();
           },500);

          })
      },

      getUsers(){
      axios
        .get("/user-service/user")
        .then(response => {  
              
              this.allUsers = response.data;
             for(const u in this.allUsers){
               for(const p in this.allPurchases){
                if(!(this.users.includes(this.allUsers[u])) && this.$store.state.user.username!=this.allUsers[u].username && (this.allUsers[u].username==this.allPurchases[p].owner || this.allUsers[u].username==this.allPurchases[p].client)){
                  this.users.push(this.allUsers[u]);
                }
               }
             }
            }) 
        .catch(error => {
            console.log(error)
        })
    },
      scrollToBottom(){
        let box = document.querySelector('.msg_history');
        box.scrollTop=box.scrollHeight;
      },
        saveMessage(){
            //save to firestore
            db.collection('chat').add({
                username: this.username,
                message: this.message,
                author:  this.$store.state.user.username,
                createdAt: new Date(),             
            }).then(()=>{
              this.scrollToBottom();
            })

            this.message=null;
        },
        getPurchases(){
          axios
        .get("/rent-service/purchase/"+  this.$store.state.user.username)
        .then(response => {  
              this.allPurchases = response.data;
            }) 
        .catch(error => {
            console.log(error)
        })
        },
        getCompanies(){
          axios
        .get("/user-service/company")
        .then(response => {  
              this.allCompanies = response.data;
              if(this.$store.state.user.role!='COMPANY')
              for(const c in this.allCompanies){
                for(const p in this.allPurchases){
                  if(!(this.companies.includes(this.allCompanies[c])) && this.$store.state.user.username!=this.allCompanies[c].username && this.allCompanies[c].username==this.allPurchases[p].owner){
                    this.companies.push(this.allCompanies[c]);
                  }
                }
             }
            }) 
        .catch(error => {
            console.log(error)
        })
        }

    },
    created(){
      this.showConversation(this.username);
        },
    mounted(){
      this.getUsers();
      this.getPurchases();
      this.getCompanies();
  }
};

</script>

<style scoped="">
.container{
    max-width:900px;
}
.inbox_people {
	background: #fff;
	float: left;
	overflow: hidden;
	width: 30%;
	border-right: 1px solid #ddd;
}
.inbox_msg {
	border: 1px solid #ddd;
	clear: both;
	overflow: hidden;
}
.top_spac {
	margin: 20px 0 0;
}
.recent_heading {
	float: left;
	width: 40%;
}
.headind_srch {
	padding: 10px 29px 10px 20px;
	overflow: hidden;
	border-bottom: 1px solid #c4c4c4;
}
.recent_heading h4 {
	color: #FBC02D;
    font-size: 16px;
    margin: auto;
    line-height: 29px;
}
.chat_ib p {
    font-size: 12px;
    color: #989898;
    margin: auto;
    display: inline-block;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.chat_img {
	float: left;
	width: 11%;
}
.chat_img img {
	width: 100%
}
.chat_ib {
	float: left;
	padding: 0 0 0 15px;
	width: 88%;
}
.chat_people {
	overflow: hidden;
	clear: both;
}
.chat_list {
	border-bottom: 1px solid #ddd;
	margin: 0;
	padding: 18px 16px 10px;
}
.inbox_chat {
	height: 550px;
	overflow-y: scroll;
}
.incoming_msg_img {
	display: inline-block;
	width: 6%;
}
.incoming_msg_img img {
	width: 100%;
}
.received_msg {
	display: inline-block;
	padding: 0 0 0 10px;
	vertical-align: top;
	width: 51%;
}
.received_withd_msg p {
	background: #ebebeb none repeat scroll 0 0;
	border-radius: 0 15px 15px 15px;
	color: #646464;
	font-size: 14px;
	margin: 0;
	padding: 5px 10px 5px 12px;
	width: 100%;
}
.time_date {
	color: #747474;
	display: block;
	font-size: 12px;
	margin: 8px 0 0;
}
.received_withd_msg {
	width: 57%;
}
.mesgs{
	float: left;
	padding: 30px 15px 0 25px;
	width:70%;
}
.sent_msg p {
	background:#FBC02D none repeat scroll 0 0;
	border-radius: 12px 15px 15px 0;
	font-size: 14px;
	margin: 0;
	color: #fff;
	padding: 5px 10px 5px 12px;
	width: 100%;
}
.outgoing_msg {
	overflow: hidden;
	margin: 26px 0 26px;
}
.sent_msg {
  float: right;
	width: 51%;
	padding: 0 0 0 10px;
	vertical-align: top;
}
.input_msg_write input {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	color: #4c4c4c;
	font-size: 15px;
	min-height: 48px;
	width: 100%;
	outline:none;
}
.type_msg {
	border-top: 1px solid #c4c4c4;
	position: relative;
}
.messaging {
	padding: 0 0 50px 0;
  width:85%;
  margin-left: 50px ;
}
.msg_history {
	height: 516px;
	overflow-y: auto;
}
</style>
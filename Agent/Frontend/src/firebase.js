import firebase from '@firebase/app'
import 'firebase/firestore'
import 'firebase/firebase-auth'
import 'firebase/storage'

var firebaseConfig = {
    apiKey: "AIzaSyCnAxaLFstsUl0gxsyO-AnUP9iBkpGrb4w",
    authDomain: "xml-ws-rentacar.firebaseapp.com",
    databaseURL: "https://xml-ws-rentacar.firebaseio.com",
    projectId: "xml-ws-rentacar",
    storageBucket: "xml-ws-rentacar.appspot.com",
    messagingSenderId: "568066042577",
    appId: "1:568066042577:web:fd81087b019cf2f10b73f0",
    measurementId: "G-XCRQG3CRL7"
  };
  
  const fb = firebase.initializeApp(firebaseConfig);

  const db = firebase.firestore();

  
  export {fb, db}
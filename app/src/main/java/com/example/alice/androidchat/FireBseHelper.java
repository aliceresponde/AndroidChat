package com.example.alice.androidchat;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by alice on 6/8/16.
 * Centralized  Firebase Logyc
 */

public class FireBseHelper {

    //referencia a nuestro repp
    private Firebase dataReferemce;
    private final static String SEPARATOR = "______";
    private final static String USERS_PATH = "users";
    private final static String CONTACTS_PATH = "contacts";
    private final static String CHATS_PATH = "chats";
    private final static String FIREBASE_URL = "https://androidchat-9c9bd.firebaseio.com/";


    //singleton
    private static class SingletoHolder {
        private static final FireBseHelper INSTANCE = new FireBseHelper();
    }


    public static FireBseHelper getInstance() {
        return SingletoHolder.INSTANCE;
    }

    FireBseHelper() {
        this.dataReferemce = new Firebase(FIREBASE_URL);
    }

    public Firebase getDataReferemce() {
        return dataReferemce;
    }

    /**
     * Obtener  email de usuario autenticado
     * @return
     */
    public String getAuthUserEmail() {
        AuthData authData = dataReferemce.getAuth();
        String email = null;
        if (authData != null) {
            Map<String, Object> providerData = authData.getProviderData();
            email = providerData.get("email").toString();
        }
        return email;
    }

    public Firebase getUserReferences(String email) {
        Firebase userReference = null;
        if (email != null) {
            //firebase no acepta el caracter '.'
            String emailKey = email.replace(".", "_");
            userReference = dataReferemce.getRoot()
                    .child(USERS_PATH).child(emailKey);
        }
        return userReference;
    }

    public Firebase getMyUserReference() {
        return getUserReferences(getAuthUserEmail());
    }

    /**
     * Obtener los contactos asociados a un email
     * @param email
     * @return
     */
    public  Firebase getContactsReference(String email){
        return getUserReferences(email).child(CONTACTS_PATH);
    }

    public Firebase getMyContactsReference() {
        return getContactsReference(getAuthUserEmail());
    }

    /**
     * optener la referencia a un contacto a partir del correo del usuario y del contacto
     * @param mainEmail
     * @param childEmail
     * @return
     */
    public Firebase getOneContactReference(String mainEmail, String childEmail){
        String childKey = childEmail.replace(".","_");
        return getUserReferences(mainEmail).child(CONTACTS_PATH).child(childKey);
    }

    public Firebase getChatReference(String receiver){
        String keySender = getAuthUserEmail().replace(".","_");
        String keyReceiver = receiver.replace(".","_");
        String keyChat = keySender + SEPARATOR + keyReceiver;

        //orden alfabetico
        if (keySender.compareTo(keyReceiver) > 0){
            keyChat = keyReceiver + SEPARATOR + keySender ;
        }

        return dataReferemce.getRoot().child(CHATS_PATH).child(keyChat);
    }

    public void changeUserConnectionStatud(boolean online){
        if ( getMyUserReference() != null){
            Map<String, Object> updates  = new HashMap<String, Object>();
            updates.put("online", online);

            getMyUserReference().updateChildren(updates);
            notifyContactsOfConnectionChange(online);
        }
    }

    public void signOff(){
        //logout
        notifyContactsOfConnectionChange(false ,true);
    }


    public void notifyContactsOfConnectionChange(boolean online) {
         notifyContactsOfConnectionChange(online, false);
    }

    public void notifyContactsOfConnectionChange(final boolean online , final boolean signoff) {
        final String myEmail  = getAuthUserEmail();
        getMyContactsReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()){
                    String email =  child.getKey();
                    Firebase reference = getOneContactReference(email, myEmail);
                    reference.setValue(online);
                }

                if (signoff){
                    dataReferemce.unauth();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}



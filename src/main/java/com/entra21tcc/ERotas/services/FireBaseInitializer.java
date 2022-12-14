package com.entra21tcc.ERotas.services;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FireBaseInitializer {

  @PostConstruct
  private void initDB() throws IOException {
    InputStream serviceAccount = this.getClass().getClassLoader()
        .getResourceAsStream("./serviceAccount.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://projeto-entra21-default-rtdb.firebaseio.com")
        .build();

    if (FirebaseApp.getApps().isEmpty()) {
      FirebaseApp.initializeApp();

    }
    FirebaseApp.initializeApp(options);
  }

  public Firestore getFirebase() {
    return FirestoreClient.getFirestore();
  }
}

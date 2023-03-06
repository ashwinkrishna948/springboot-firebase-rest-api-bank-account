package com.project.firebase.account.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseConfig 
{
   @PostConstruct
   public void FirebaseConfigConnection() throws IOException {
        File file = ResourceUtils.getFile("classpath:config/springboot-customer-project-firebase-adminsdk-gvfg5-63ef0a27e7.json");
        FileInputStream serviceAccount =new FileInputStream(file);

        FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

        FirebaseApp.initializeApp(options);

   }    
}

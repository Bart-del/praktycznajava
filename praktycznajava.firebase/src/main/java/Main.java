import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.annotation.Nullable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        doAction();
    }

    public static void doAction() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("src/main/java/praktycznajava-firebase-adminsdk-pxzxc-b6979839d0.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://praktycznajava.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options)
        ;


        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data = new HashMap<>();

        data.put("nazwa", "Warszawa");
        data.put("wojewodztwo", "Mazowieckie");
        data.put("kraj", "Polska");

        ApiFuture<WriteResult> future =
                db.collection("miasta")
                        .document("WRS").set(data);

        DocumentReference docRef = db.collection("miasta").document("WRS");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirestoreException e) {
                if (e != null) {
                    System.err.println("Listen failed: " + e);
                    return;
                }
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    System.out.println("Current data: " + documentSnapshot.getData());
                } else {
                    System.out.print("Current data: null");
                }
            }
        });

    }

}

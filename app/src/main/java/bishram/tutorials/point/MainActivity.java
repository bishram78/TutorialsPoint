package bishram.tutorials.point;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Just to check whether the firebase is working
        // Get the reference of the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Get the reference of the Firebase database
        DatabaseReference mRef = database.getReference("message");
        mRef.setValue("How are you doing?");
    }
}

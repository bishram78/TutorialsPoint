package bishram.tutorials.point;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFetch = findViewById(R.id.btn_save);
        final TextView textViewResponse = findViewById(R.id.txt_response);

        // Just to check whether the firebase is working
        // Get the reference of the Firebase database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        /*
        WRITE TO YOUR FIREBASE DATABASE
        // Get the reference of the Firebase database
        DatabaseReference mRef = database.getReference("message");
        mRef.setValue("How are you doing?");
        */

        /*
        READ FROM THE FIREBASE DATABASE*/
        // Get the reference of the Firebase database
        final DatabaseReference mRef = database.getReference("message");

        // Add ValueEventListener for reading the database from firebase
        buttonFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        textViewResponse.setText(value);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}

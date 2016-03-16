package io.olympicfans.olympicgamesrio2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Firebase mFireBaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final TextView startEndDateView = (TextView) findViewById(R.id.textView_startEndDate);
        mFireBaseRef = new Firebase("https://popping-torch-7055.firebaseio.com/");
        mFireBaseRef.child("startEndDate").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String startEndDate = (String) dataSnapshot.getValue();
                startEndDateView.setText((startEndDate));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}

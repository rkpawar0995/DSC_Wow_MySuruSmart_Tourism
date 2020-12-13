package xyz.rkplap.dschack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<FoodData> myFoodList;


    ProgressDialog progressDialog;
    MyAdapter myAdapter;


    Button placebtn;

    private BottomNavigationView bottomNavigationView;
    RecyclerView mainCategoryRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.explore:
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;

                case R.id.save:
                    Toast.makeText(MainActivity.this, "Save Activity ", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MainActivity.this, SaveActivity.class);
                    startActivity(intent1);
                    return true;

                case R.id.trip:
                    Toast.makeText(MainActivity.this, "Trips Activity", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent2);
                    return true;

                case R.id.profile:
                    Toast.makeText(MainActivity.this, "Profile Activity", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent3);

                case R.id.inbox:
                    Toast.makeText(MainActivity.this, "Inbox Activity", Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(MainActivity.this, InboxActivity.class);
                    startActivity(intent4);
                    return true;

            }
            return false;
        });

        placebtn = findViewById(R.id.places);

        placebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(MainActivity.this,PlacesActivity.class);
                startActivity(p);
            }
        });

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data....");

        myFoodList = new ArrayList<>();
        myAdapter  = new MyAdapter(MainActivity.this,myFoodList);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("data");
        progressDialog.show();

        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myFoodList.clear();

                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {

                    FoodData foodData = itemSnapshot.getValue(FoodData.class);
                    foodData.setKey(itemSnapshot.getKey());
                    myFoodList.add(foodData);

                }

                myAdapter.notifyDataSetChanged();
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    
}
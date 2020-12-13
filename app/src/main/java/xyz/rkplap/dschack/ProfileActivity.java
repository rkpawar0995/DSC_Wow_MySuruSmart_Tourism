package xyz.rkplap.dschack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import xyz.rkplap.dschack.ProfileItem.AccountInformation;
import xyz.rkplap.dschack.ProfileItem.Cyborgs;
import xyz.rkplap.dschack.ProfileItem.Feedback;
import xyz.rkplap.dschack.ProfileItem.Help;
import xyz.rkplap.dschack.ProfileItem.PravSetting;
import xyz.rkplap.dschack.ProfileItem.Tc;
import xyz.rkplap.dschack.ProfileItem.Travel;

public class ProfileActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t6,t7,t8,t9,t10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        t1 = findViewById(R.id.Per_info);
        t2 = findViewById(R.id.Notification);
        t3 = findViewById(R.id.Travel);
        t4 = findViewById(R.id.Cyborgs);
        t6 = findViewById(R.id.Help);
        t7 = findViewById(R.id.Feedback);
        t8 = findViewById(R.id.T_C);
        t9 = findViewById(R.id.Prav_setting);
        t10 = findViewById(R.id.Log_out);


        t1.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, AccountInformation.class);
            startActivity(intent);
        });
//        t2.setOnClickListener(view -> {
//            Intent intent = new Intent(ProfileActivity.this, InboxActivity.class);
//            startActivity(intent);
//        });
        t3.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, Travel.class);
            startActivity(intent);
        });
        t4.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, Cyborgs.class);
            startActivity(intent);
        });


        t6.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, Help.class);
            startActivity(intent);
        });
        t7.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, Feedback.class);
            startActivity(intent);
        });
        t8.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, Tc.class);
            startActivity(intent);
        });
        t9.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, PravSetting.class);
            startActivity(intent);
        });
        t10.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });



    }
}
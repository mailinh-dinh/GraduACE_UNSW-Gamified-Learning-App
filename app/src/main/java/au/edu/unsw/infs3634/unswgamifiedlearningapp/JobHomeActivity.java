package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class JobHomeActivity extends AppCompatActivity implements JobAdapter.ClickListener {
    public ArrayList<Job> mJobs = Job.getJobs();
    public RecyclerView mRecyclerView;
    public JobAdapter mAdapter;
    Button ibMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobhome);

        //Instantiate RecyclerView
        mRecyclerView = findViewById(R.id.jobRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new JobAdapter(this, mJobs, this);
        mRecyclerView.setAdapter(mAdapter);
        ibMenu = findViewById(R.id.ibMenu);

        ibMenuClicked();
    }

    public void onClick(int position) {
        String msg = mJobs.get(position).getId();
        Intent intent = new Intent(this, JobDetailActivity.class);
        intent.putExtra("transferMsg", msg);
        startActivity(intent);
    }

    //When menu hamburger button is clicked, launch method
    private void ibMenuClicked() {
        ibMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenuScreen();
            }
        });
    }
    //Displays menu screen from xml file and attaches functionalities to each property
    private void showMenuScreen() {
        //Instantiate new bottom sheet dialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(JobHomeActivity.this);
        //Inflate the view so that users are able to view it
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.menu, (LinearLayout)findViewById(R.id.llMenu));
        Button btnClose = bottomSheetView.findViewById(R.id.btnClose);
        Button btnHome = bottomSheetView.findViewById(R.id.btnHome);
        Button btnPersonalityQuizzes = bottomSheetView.findViewById(R.id.btnPersonalityQuizzes);
        Button btnMockAssessments = bottomSheetView.findViewById(R.id.btnMockAssessments);
        Button btnJobSuggestions = bottomSheetView.findViewById(R.id.btnJobSuggestions);
        Button btnResourceVideos = bottomSheetView.findViewById(R.id.btnResourceVideos);

        //When close button is clicked, the menu is hidden
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

        //When button is clicked, it rediverts users to desired destination
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobHomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        //When button is clicked, it rediverts users to desired destination
        btnPersonalityQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobHomeActivity.this, PersonalityHomeActivity.class);
                startActivity(intent);
            }
        });

        //When button is clicked, it rediverts users to desired destination
        btnMockAssessments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobHomeActivity.this, MockAssessHomeActivity.class);
                startActivity(intent);
            }
        });

        //When button is clicked, it rediverts users to desired destination
        btnJobSuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobHomeActivity.this, JobHomeActivity.class);
                startActivity(intent);
            }
        });

        //When button is clicked, it rediverts users to desired destination
        btnResourceVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobHomeActivity.this, ResourceHomeActivity.class);
                startActivity(intent);
            }
        });

        //Cancels bottom sheet dialog when user clicks another part of the screen
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}




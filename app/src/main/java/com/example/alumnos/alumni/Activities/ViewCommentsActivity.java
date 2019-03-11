package com.example.alumnos.alumni.Activities;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.alumnos.alumni.Adapters.CommentListAdapter;
import com.example.alumnos.alumni.Api.GlobalRequests;
import com.example.alumnos.alumni.Models.Comments;
import com.example.alumnos.alumni.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewCommentsActivity extends AppCompatActivity {

    CommentListAdapter commentListAdapter;

    public static String nameComments;

    public static EditText comment;
    public static String textComment;

    public Button addComment;


    CircleImageView circleImageView;

    public static ArrayList<Comments> commentsArrayList = new ArrayList<Comments>();

    public static ListView listView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_comments);


        comment = findViewById(R.id.editTextComment);

        addComment = findViewById(R.id.addComment);

        addComment.setOnClickListener(listenerComment);

        listView = (ListView) findViewById(R.id.listView);

        SharedPreferences sp = getSharedPreferences("userPrefs", 0);

        nameComments = sp.getString("name", "");


        GlobalRequests globalRequests = new GlobalRequests();
        globalRequests.setCommentsListener(new GlobalRequests.CommentsListener() {
            @Override
            public void onGetCommentsFinish() {

                commentListAdapter = new CommentListAdapter(getApplicationContext(), R.layout.listcomments_item, commentsArrayList);

                listView.setAdapter(commentListAdapter);


            }
        });
        globalRequests.getlistOfComments();

        }
        public static void keepCommentText()
        {
            textComment = comment.getText ().toString ();
        }

        private View.OnClickListener listenerComment = new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                GlobalRequests globalRequests = new GlobalRequests();
                globalRequests.createComment();
                finish();
                startActivity(getIntent());
            }
        };


    }


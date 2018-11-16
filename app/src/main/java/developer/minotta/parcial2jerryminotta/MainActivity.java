package developer.minotta.parcial2jerryminotta;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RatingBar rbar_avengers, rbar_bohemian, rbar_increibles, rbar_deadpool;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference referencia;
    ArrayList<String> puntajesAvengers;


    TextView tv_puntajeAvengers, tv_puntajeBohemian, tv_puntajeIncreibles, tv_puntajeDeadpool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rbar_avengers = findViewById(R.id.rbar_infinity);
        rbar_bohemian = findViewById(R.id.rbar_bohemian);
        rbar_increibles = findViewById(R.id.rbar_increibles);
        rbar_deadpool = findViewById(R.id.rbar_deadpool);

        firebaseDatabase = FirebaseDatabase.getInstance();
        referencia = firebaseDatabase.getReference();

        tv_puntajeAvengers = findViewById(R.id.tv_puntajeAvengers);
        tv_puntajeBohemian = findViewById(R.id.tv_puntajeBohemian);
        tv_puntajeIncreibles = findViewById(R.id.tv_puntajeIncreibles);
        tv_puntajeDeadpool = findViewById(R.id.tv_puntajeDeadpool);

        referencia.child("movies");

        puntajesAvengers = new ArrayList<>();





rbar_avengers.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        //Toast.makeText(MainActivity.this, ""+v, Toast.LENGTH_LONG).show();

        String puntaje = "" + (int)v;
        referencia.child("movies").child("avengers").push().setValue(puntaje);

       // tv_puntajeAvengers.setText(puntaje);
    }
});




        rbar_bohemian.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                //Toast.makeText(MainActivity.this, ""+v, Toast.LENGTH_LONG).show();

                String puntaje = "" + (int)v;
                referencia.child("movies").child("bohemian").push().setValue(puntaje);

              //  tv_puntajeBohemian.setText(puntaje);
            }
        });


        rbar_increibles.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                //Toast.makeText(MainActivity.this, ""+v, Toast.LENGTH_LONG).show();

                String puntaje = "" + (int)v;
                referencia.child("movies").child("increibles").push().setValue(puntaje);

               // tv_puntajeIncreibles.setText(puntaje);
            }
        });


        rbar_deadpool.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                //Toast.makeText(MainActivity.this, ""+v, Toast.LENGTH_LONG).show();

                String puntaje = "" + (int)v;
                referencia.child("movies").child("deadpool").push().setValue(puntaje);

                //tv_puntajeDeadpool.setText(puntaje);
            }
        });




        referencia.child("movies").child("avengers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int puntaje = 0;
                int totalpuntaje=0;
                int totalVotos=0;
                float promedio= 0;

                for (DataSnapshot data: dataSnapshot.getChildren()){
                    puntaje = Integer.parseInt(data.getValue(String.class));

                    totalpuntaje+=puntaje;

                }

                totalVotos= (int) dataSnapshot.getChildrenCount();

                if(totalVotos!=0)promedio= totalpuntaje/totalVotos;

                tv_puntajeAvengers.setText(""+(float)totalpuntaje/totalVotos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        referencia.child("movies").child("bohemian").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int puntaje = 0;
                int totalpuntaje=0;
                int totalVotos=0;
                float promedio= 0;

                for (DataSnapshot data: dataSnapshot.getChildren()){
                    puntaje = Integer.parseInt(data.getValue(String.class));

                    totalpuntaje+=puntaje;

                }

                totalVotos= (int) dataSnapshot.getChildrenCount();

                if(totalVotos!=0)promedio= totalpuntaje/totalVotos;

                tv_puntajeBohemian.setText(""+(float)totalpuntaje/totalVotos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        referencia.child("movies").child("deadpool").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int puntaje = 0;
                int totalpuntaje=0;
                int totalVotos=0;
                float promedio= 0;

                for (DataSnapshot data: dataSnapshot.getChildren()){
                    puntaje = Integer.parseInt(data.getValue(String.class));

                    totalpuntaje+=puntaje;

                }

                totalVotos= (int) dataSnapshot.getChildrenCount();

                if(totalVotos!=0)promedio= totalpuntaje/totalVotos;

                tv_puntajeDeadpool.setText(""+(float)totalpuntaje/totalVotos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        referencia.child("movies").child("increibles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int puntaje = 0;
                int totalpuntaje=0;
                int totalVotos=0;
                float promedio= 0;

                for (DataSnapshot data: dataSnapshot.getChildren()){
                    puntaje = Integer.parseInt(data.getValue(String.class));

                    totalpuntaje+=puntaje;

                }

                totalVotos= (int) dataSnapshot.getChildrenCount();

                if(totalVotos!=0)promedio= totalpuntaje/totalVotos;

                tv_puntajeIncreibles.setText(""+(float)totalpuntaje/totalVotos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

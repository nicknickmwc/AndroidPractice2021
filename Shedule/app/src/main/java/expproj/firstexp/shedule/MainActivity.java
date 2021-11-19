package expproj.firstexp.shedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText lesson1,lesson2,lesson3,lesson4,lesson5;
    private TextView timeShed1,timeShed2,timeShed3,timeShed4,timeShed5;
    private AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2;
    private Button buttonChange;
    String s1="Понедельник";
    String s2="Нечетная";
    private DatabaseReference query1;
    private DatabaseReference query2;
    private DatabaseReference query3;
    private DatabaseReference query4;
    private DatabaseReference query5;
    private DatabaseReference query6;
    private DatabaseReference query7;
    private DatabaseReference query8;
    private DatabaseReference query9;
    private DatabaseReference query10;
    private String[] daysOfWeek = {"Понедельник","Вторник","Среда","Четверг","Пятница"};
    private String[] typesOfWeek = {"Четная","Нечетная"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //getDataFromDB();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item, daysOfWeek);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.dropdown_item2, typesOfWeek);

        autoCompleteTextView1.setAdapter(arrayAdapter);
        autoCompleteTextView2.setAdapter(arrayAdapter2);

        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //lesson1.setText(autoCompleteTextView1.getText().toString());
                s1 = autoCompleteTextView1.getText().toString();
                //query1 = FirebaseDatabase.getInstance().getReference(s);
                //lesson1.setText(s);
                if ((s1.charAt(1)==1086)&&(s2.charAt(0)==1053)) {
                    getDataFromDB1();
                }
                if ((s1.charAt(1)==1090)&&(s2.charAt(0)==1053)) {
                    getDataFromDB2();
                }
                if ((s1.charAt(1)==1088)&&(s2.charAt(0)==1053)) {
                    getDataFromDB3();
                }
                if ((s1.charAt(1)==1077)&&(s2.charAt(0)==1053)) {
                    getDataFromDB4();
                }
                if ((s1.charAt(1)==1103)&&(s2.charAt(0)==1053)) {
                    getDataFromDB5();
                }
                if ((s1.charAt(1)==1086)&&(s2.charAt(0)==1063)) {
                    getDataFromDB6();
                }
                if ((s1.charAt(1)==1090)&&(s2.charAt(0)==1063)) {
                    getDataFromDB7();
                }
                if ((s1.charAt(1)==1088)&&(s2.charAt(0)==1063)) {
                    getDataFromDB8();
                }
                if ((s1.charAt(1)==1077)&&(s2.charAt(0)==1063)) {
                    getDataFromDB9();
                }
                if ((s1.charAt(1)==1103)&&(s2.charAt(0)==1063)) {
                    getDataFromDB10();
                }

            }
        });
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //lesson1.setText(autoCompleteTextView2.getText().toString());
                s2 = autoCompleteTextView2.getText().toString();
                //lesson4.setText(Integer.toString(s.charAt(0)));
                if ((s1.charAt(1)==1086)&&(s2.charAt(0)==1053)) {
                    getDataFromDB1();
                }
                if ((s1.charAt(1)==1090)&&(s2.charAt(0)==1053)) {
                    getDataFromDB2();
                }
                if ((s1.charAt(1)==1088)&&(s2.charAt(0)==1053)) {
                    getDataFromDB3();
                }
                if ((s1.charAt(1)==1077)&&(s2.charAt(0)==1053)) {
                    getDataFromDB4();
                }
                if ((s1.charAt(1)==1103)&&(s2.charAt(0)==1053)) {
                    getDataFromDB5();
                }
                if ((s1.charAt(1)==1086)&&(s2.charAt(0)==1063)) {
                    getDataFromDB6();
                }
                if ((s1.charAt(1)==1090)&&(s2.charAt(0)==1063)) {
                    getDataFromDB7();
                }
                if ((s1.charAt(1)==1088)&&(s2.charAt(0)==1063)) {
                    getDataFromDB8();
                }
                if ((s1.charAt(1)==1077)&&(s2.charAt(0)==1063)) {
                    getDataFromDB9();
                }
                if ((s1.charAt(1)==1103)&&(s2.charAt(0)==1063)) {
                    getDataFromDB10();
                }
            }
        });
        //lesson2.setText(s);


        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.activity_main_change);
                String less1="";
                String less2="РКПО";
                String less3="ОС";
                String less4="СП";
                String less5="";
                Days monday = new Days(less1,less2,less3,less4,less5);
                query1.setValue(monday);
            }
        });
    }

    private void getDataFromDB1() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query1.addValueEventListener(vListener);
    }
    private void getDataFromDB2() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query2.addValueEventListener(vListener);
    }
    private void getDataFromDB3() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query3.addValueEventListener(vListener);
    }
    private void getDataFromDB4() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query4.addValueEventListener(vListener);
    }
    private void getDataFromDB5() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query5.addValueEventListener(vListener);
    }
    private void getDataFromDB6() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query6.addValueEventListener(vListener);
    }
    private void getDataFromDB7() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query7.addValueEventListener(vListener);
    }
    private void getDataFromDB8() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query8.addValueEventListener(vListener);
    }
    private void getDataFromDB9() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query9.addValueEventListener(vListener);
    }
    private void getDataFromDB10() {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Days days = snapshot.getValue(Days.class);
                lesson1.setText(days.less1.toString());
                lesson2.setText(days.less2.toString());
                lesson3.setText(days.less3.toString());
                lesson4.setText(days.less4.toString());
                lesson5.setText(days.less5.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        };
        query10.addValueEventListener(vListener);
    }


    private void init() {
        timeShed1 = findViewById(R.id.timeShed1);
        timeShed2 = findViewById(R.id.timeShed2);
        timeShed3 = findViewById(R.id.timeShed3);
        timeShed4 = findViewById(R.id.timeShed4);
        timeShed5 = findViewById(R.id.timeShed5);
        lesson1 = findViewById(R.id.lesson1);
        lesson2 = findViewById(R.id.lesson2);
        lesson3 = findViewById(R.id.lesson3);
        lesson4 = findViewById(R.id.lesson4);
        lesson5 = findViewById(R.id.lesson5);
        buttonChange = findViewById(R.id.buttonChange);
        autoCompleteTextView1 = findViewById(R.id.autoCompleteTextView1);
        autoCompleteTextView2 = findViewById(R.id.autoCompleteTextView2);
        query1 = FirebaseDatabase.getInstance().getReference("Monday");
        query2 = FirebaseDatabase.getInstance().getReference("Tuesday");
        query3 = FirebaseDatabase.getInstance().getReference("Wednesday");
        query4 = FirebaseDatabase.getInstance().getReference("Thursday");
        query5 = FirebaseDatabase.getInstance().getReference("Friday");
        query6 = FirebaseDatabase.getInstance().getReference("MondayCh");
        query7 = FirebaseDatabase.getInstance().getReference("TuesdayCh");
        query8 = FirebaseDatabase.getInstance().getReference("WednesdayCh");
        query9 = FirebaseDatabase.getInstance().getReference("ThursdayCh");
        query10 = FirebaseDatabase.getInstance().getReference("FridayCh");

    }


}
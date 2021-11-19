package expproj.firstexp.shedule2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
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
    private DatabaseReference query1,query2,query3,query4,query5,query6,query7,query8,query9,query10;
    private String[] daysOfWeek = {"Понедельник","Вторник","Среда","Четверг","Пятница"};
    private String[] typesOfWeek = {"Четная","Нечетная"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //Адаптер для выпадающего меню InputTextView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item, daysOfWeek);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.dropdown_item2, typesOfWeek);
        autoCompleteTextView1.setAdapter(arrayAdapter);
        autoCompleteTextView2.setAdapter(arrayAdapter2);

        //Слушатель нажатия на один из элементов меню autoCompleteTextView1
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                s1 = autoCompleteTextView1.getText().toString();
                initDayOfWeekByCharAt(s1,s2);
            }
        });

        //Слушатель нажатия на один из элементов меню autoCompleteTextView1
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                s2 = autoCompleteTextView2.getText().toString();
                initDayOfWeekByCharAt(s1,s2);
            }
        });


        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setContentView(R.layout.activity_main_change);
//                String less1="";
//                String less2="РКПО";
//                String less3="ОС";
//                String less4="СП";
//                String less5="";
//                Days monday = new Days(less1,less2,less3,less4,less5);
//                query1.setValue(monday);
            }
        });
    }

    //  Инициализируем выбранный день недели по второй букве выбранной строки
    //  и тип недели по первой
    public void initDayOfWeekByCharAt (String s1, String s2) {
        if ((s1.charAt(1)==1086)&&(s2.charAt(0)==1053)) {
            getDataFromDB(query1);
        }
        if ((s1.charAt(1)==1090)&&(s2.charAt(0)==1053)) {
            getDataFromDB(query2);
        }
        if ((s1.charAt(1)==1088)&&(s2.charAt(0)==1053)) {
            getDataFromDB(query3);
        }
        if ((s1.charAt(1)==1077)&&(s2.charAt(0)==1053)) {
            getDataFromDB(query4);
        }
        if ((s1.charAt(1)==1103)&&(s2.charAt(0)==1053)) {
            getDataFromDB(query5);
        }
        if ((s1.charAt(1)==1086)&&(s2.charAt(0)==1063)) {
            getDataFromDB(query6);
        }
        if ((s1.charAt(1)==1090)&&(s2.charAt(0)==1063)) {
            getDataFromDB(query7);
        }
        if ((s1.charAt(1)==1088)&&(s2.charAt(0)==1063)) {
            getDataFromDB(query8);
        }
        if ((s1.charAt(1)==1077)&&(s2.charAt(0)==1063)) {
            getDataFromDB(query9);
        }
        if ((s1.charAt(1)==1103)&&(s2.charAt(0)==1063)) {
            getDataFromDB(query10);
        }
    }

    //  Вытаскиаем из БД нужный объект
    private void getDataFromDB(DatabaseReference query) {
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
        query.addValueEventListener(vListener);
    }

    //Инициализация
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
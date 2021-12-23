package expproj.firstexp.shedule2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText lesson1,lesson2,lesson3,lesson4,lesson5;
    private TextView timeShed1,timeShed2,timeShed3,timeShed4,timeShed5;
    private AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2;
    private Button buttonChange;
    String s1; // День недели
    String s2; // Тип недели
    String setOrGet = "get"; //Первоначальное состояние get
    private DatabaseReference query1,query2,query3,query4,query5,query6,query7,query8,query9,query10,query11,query12,query13,query14;
    private String[] daysOfWeek = {"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
    private String[] typesOfWeek = {"Верхняя","Нижняя"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // Анимация кнопки
        Animation buttonAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);

        // Экземпляр даты для использования с SimpleDateFormat
        Date d = new Date();

        // Определяем номер недели в году
        SimpleDateFormat numOfWeek = new SimpleDateFormat("w");
        String numOfWeekStr = numOfWeek.format(d);
        int numOfWeekInt = Integer.parseInt(numOfWeekStr);

        // Определяем номер дня недели
        SimpleDateFormat numOfDay = new SimpleDateFormat("u");
        String numOfDayStr = numOfDay.format(d);
        int numOfDayInt = Integer.parseInt(numOfDayStr);

        // Определяем текущую неделю и день недели. Устанавливаем для наших "спиннеров" (autoCompleteTextView
        // текущие значения до установления в них arrayAdapter
        s1 = daysOfWeek[numOfDayInt-1];
        s2 = typesOfWeek[chet(numOfWeekInt)];
        autoCompleteTextView1.setText(s1);
        autoCompleteTextView2.setText(s2);


        //Адаптер для выпадающего меню InputTextView
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item, daysOfWeek);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.dropdown_item2, typesOfWeek);
        // Дни недели
        autoCompleteTextView1.setAdapter(arrayAdapter);
        // Тип недели
        autoCompleteTextView2.setAdapter(arrayAdapter2);

        // Получаем расписание на сегодняшний день
        initDayOfWeekByCharAtGet(s1,s2);


        //Слушатель нажатия на один из элементов меню autoCompleteTextView1
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                s1 = autoCompleteTextView1.getText().toString();
                initDayOfWeekByCharAtGet(s1,s2);
                //lesson1.setText(volOfWeeks);
            }
        });

        //Слушатель нажатия на один из элементов меню autoCompleteTextView2
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                s2 = autoCompleteTextView2.getText().toString();
                initDayOfWeekByCharAtGet(s1,s2);
            }
        });

        buttonChange.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    view.startAnimation(buttonAnimation);
                }
                else if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    if (setOrGet=="get") {
                        setOrGet="set";
                        buttonChange.setText("Сохранить");
                        setOnOffEditText("on");
                    }
                    // Наоборот
                    else if(setOrGet=="set"){
                        setOrGet="get";
                        buttonChange.setText("Редактировать");
                        initDayOfWeekByCharAtSet(s1,s2);
                        setOnOffEditText("off");
                    }
                }
                return true;
            }
        });
    }

    // Четность
    int chet(int i){
        if (i%2==0) return 1;
        else return 0;
    }

    //  Инициализируем выбранный день недели по определенной букве и достаем из БД
    public void initDayOfWeekByCharAtGet (String s1, String s2) {
            if ((s1.charAt(2)==1085)&&(s2.charAt(0)==1042)) {
                getDataFromDB(query1);
            }
            if (initDay(s1,s2,1090,1042)) {
                getDataFromDB(query2);
            }
            if (initDay(s1,s2,1088,1042)) {
                getDataFromDB(query3);
            }
            if (initDay(s1,s2,1077,1042)) {
                getDataFromDB(query4);
            }
            if (initDay(s1,s2,1103,1042)) {
                getDataFromDB(query5);
            }
            if ((s1.charAt(2)==1085)&&(s2.charAt(0)==1053)) {
                getDataFromDB(query6);
            }
            if (initDay(s1,s2,1090,1053)) {
                getDataFromDB(query7);
            }
            if (initDay(s1,s2,1088,1053)) {
                getDataFromDB(query8);
            }
            if (initDay(s1,s2,1077,1053)) {
                getDataFromDB(query9);
            }
            if (initDay(s1,s2,1103,1053)) {
                getDataFromDB(query10);
            }
            if (initDay(s1,s2,1091,1042)) {
            getDataFromDB(query11);
            }
            if (initDay(s1,s2,1091,1053)) {
            getDataFromDB(query12);
            }
            if ((s1.charAt(2)==1089)&&(s2.charAt(0)==1042)) {
            getDataFromDB(query13);
            }
            if ((s1.charAt(2)==1089)&&(s2.charAt(0)==1053)) {
            getDataFromDB(query14);
        }
    }

    //  Инициализируем выбранный день недели по определенной букве и отправляем в БД
    public void initDayOfWeekByCharAtSet(String s1,String s2) {
        Days days = new Days(lesson1.getText().toString(),lesson2.getText().toString(),
                lesson3.getText().toString(),lesson4.getText().toString(),lesson5.getText().toString());
        if ((s1.charAt(2)==1085)&&(s2.charAt(0)==1042)) {
            query1.setValue(days);
        }
        if (initDay(s1,s2,1090,1042)) {
            query2.setValue(days);
        }
        if (initDay(s1,s2,1088,1042)) {
            query3.setValue(days);
        }
        if (initDay(s1,s2,1077,1042)) {
            query4.setValue(days);
        }
        if (initDay(s1,s2,1103,1042)) {
            query5.setValue(days);
        }
        if ((s1.charAt(2)==1085)&&(s2.charAt(0)==1053)) {
            query6.setValue(days);
        }
        if (initDay(s1,s2,1090,1053)) {
            query7.setValue(days);
        }
        if (initDay(s1,s2,1088,1053)) {
            query8.setValue(days);
        }
        if (initDay(s1,s2,1077,1053)) {
            query9.setValue(days);
        }
        if (initDay(s1,s2,1103,1053)) {
            query10.setValue(days);
        }
        if (initDay(s1,s2,1091,1042)) {
            query11.setValue(days);
        }
        if (initDay(s1,s2,1091,1053)) {
            query12.setValue(days);
        }
        if ((s1.charAt(0)==1089)&&(s2.charAt(0)==1042)) {
            query13.setValue(days);
        }
        if ((s1.charAt(0)==1089)&&(s2.charAt(0)==1053)) {
            query14.setValue(days);
        }
    }

    // Определение буквы для большинства дней недели
    boolean initDay(String s1, String s2, int i1, int i2){
        return (s1.charAt(1)==i1)&&(s2.charAt(0)==i2);
    }

    // Включаем или выключаем EditText
    void setOnOffEditText(String s){
        if (s=="on") {
            lesson1.setEnabled(true);
            lesson2.setEnabled(true);
            lesson3.setEnabled(true);
            lesson4.setEnabled(true);
            lesson5.setEnabled(true);
        }
        else if (s=="off") {
            lesson1.setEnabled(false);
            lesson2.setEnabled(false);
            lesson3.setEnabled(false);
            lesson4.setEnabled(false);
            lesson5.setEnabled(false);
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
        query11 = FirebaseDatabase.getInstance().getReference("Saturday");
        query12 = FirebaseDatabase.getInstance().getReference("SaturdayCh");
        query13 = FirebaseDatabase.getInstance().getReference("Sunday");
        query14 = FirebaseDatabase.getInstance().getReference("SundayCh");

    }


}
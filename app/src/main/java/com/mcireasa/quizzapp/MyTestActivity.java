package com.mcireasa.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mcireasa.quizzapp.Adapters.MyTestsAdapter;
import com.mcireasa.quizzapp.Adapters.TestAdapter;
import com.mcireasa.quizzapp.Adapters.TestRaport;
import com.mcireasa.quizzapp.Model.MyTest;
import com.mcireasa.quizzapp.Model.Test;
import com.mcireasa.quizzapp.Model.User;
import com.mcireasa.quizzapp.database.DatabaseRepository;

import java.util.ArrayList;
import java.util.List;

public class MyTestActivity extends AppCompatActivity {


    private ListView list;
    TextView nume, scor;
    User user;

    DatabaseRepository databaseRepository=new DatabaseRepository(this);

    List<MyTest> myTestsList = new ArrayList<>();
    List<MyTest> myTests = new ArrayList<>();
    List<Test>  tests = new ArrayList<>();
    List<TestRaport> testRaports = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BlackText);

        setContentView(R.layout.raport_stud);

        nume = findViewById(R.id.nume_test_stud);
        scor = findViewById(R.id.score);

        list = findViewById(R.id.listview_tests_stud);

        databaseRepository.open();

        myTestsList = databaseRepository.getMyTests();

        user= (User) getIntent().getSerializableExtra("User");

        for(int i=0;i<myTestsList.size();i++)
            if(myTestsList.get(i).getId_user()==user.getId())
                myTests.add(myTestsList.get(i));

        tests = databaseRepository.getTests();

        for(int i=0;i<tests.size();i++)
            for(int j=0;j<myTests.size();j++)
                if(tests.get(i).getId() == myTests.get(j).getId_test())
                {
                    TestRaport testRaport = new TestRaport();
                    testRaport.setNume(tests.get(i).getText());
                    testRaport.setScore(myTests.get(i).getScore());

                    testRaports.add(testRaport);
                }




        MyTestsAdapter adapter = new MyTestsAdapter(getApplicationContext(),
                R.layout.lv_my_tests, testRaports, getLayoutInflater());
        list.setAdapter(adapter);



    }
}

package com.example.displaystudents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_stu;
    private RecyclerView recycler_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_stu = findViewById(R.id.recycler_students);
        recycler_sub = findViewById(R.id.recycler_subjects);

        DisplayStudents();
        DisplaySubjects();

        // Layout for RecyclerView
        recycler_sub.setHasFixedSize(true);
        recycler_sub.setLayoutManager(new LinearLayoutManager(this)); //Left to Right.

        recycler_stu.setHasFixedSize(true);
        recycler_stu.setLayoutManager(new LinearLayoutManager(this)); //Left to Right.
    }

    private void DisplayStudents(){
        String url = "http://192.168.0.2/DStudents/StudentsWithMatchingData.php";

        RequestQueue q = Volley.newRequestQueue(MainActivity.this);

        StringRequest r = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject oh = new JSONObject(response);

                            JSONArray studentsarray = oh.getJSONArray("Students");

                            int size = studentsarray.length();

                            String[] A1 = new String[size];
                            String[] A2 = new String[size];
                            String[] A3 = new String[size];
                            String[] A4 = new String[size];
                            String[] A5 = new String[size];
                            String[] A6 = new String[size];
                            String[] A7 = new String[size];
                            String[] A8 = new String[size];

                            for(int i=0; i<size; i++) {

                                JSONObject ob = studentsarray.getJSONObject(i);

                                A1[i] = ob.getString("StudentID");
                                A2[i] = ob.getString("StudentName");
                                A3[i] = ob.getString("Course");
                                A4[i] = ob.getString("YearLevel");
                                A5[i] = ob.getString("EnrolmentID");
                                A6[i] = ob.getString("OfferingNo");
                                A7[i] = ob.getString("Semester");
                                A8[i] = ob.getString("AcademicYear");

                                GetStudents(size,A1,A2,A3,A4,A5,A6,A7,A8);
                            }
                        }
                        catch(Exception e){
                            Toast.makeText(MainActivity.this, "Exeception Error Response! \n\n " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Volley Error Response! \n\n" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        q.add(r);
    }

    private void DisplaySubjects(){
        String url = "http://192.168.0.2/DStudents/SubjectsWithMatchingData.php";

        RequestQueue q = Volley.newRequestQueue(MainActivity.this);

        StringRequest r = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject oh = new JSONObject(response);

                            JSONArray subjectsarray = oh.getJSONArray("Subjects");

                            int size = subjectsarray.length();

                            String[] A1 = new String[size];
                            String[] A2 = new String[size];
                            String[] A3 = new String[size];
                            String[] A4 = new String[size];
                            String[] A5 = new String[size];
                            String[] A6 = new String[size];
                            String[] A7 = new String[size];
                            String[] A8 = new String[size];
                            String[] A9 = new String[size];

                            for(int i=0; i<size; i++) {

                                JSONObject ob = subjectsarray.getJSONObject(i);

                                A1[i] = ob.getString("OfferingNo");
                                A2[i] = ob.getString("SubjCode");
                                A3[i] = ob.getString("Schedule");
                                A4[i] = ob.getString("Room");
                                A5[i] = ob.getString("TeacherID");
                                A6[i] = ob.getString("EnrolmentID");
                                A7[i] = ob.getString("StudentID");
                                A8[i] = ob.getString("Semester");
                                A9[i] = ob.getString("AcademicYear");

                                GetSubjects(size,A1,A2,A3,A4,A5,A6,A7,A8,A9);
                            }
                        }
                        catch(Exception e){
                            Toast.makeText(MainActivity.this, "Exception Error Response ! \n\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Volley Error Response! \n\n" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        q.add(r);
    }

    private void GetSubjects(int Count, String[]offerno, String[]subcode, String[]sched,String[]room, String[]teachid, String[]enrolmentid, String[]studentid, String[]semes, String[] academic){
        String[] OFFERArr = new String[Count];
        String[] SUBArr = new String[Count];
        String[] SCHEDArr = new String[Count];
        String[] ROOMArr = new String[Count];
        String[] TEACHArr = new String[Count];
        String[] ENROLArr = new String[Count];
        String[] STUIDArr = new String[Count];
        String[] SEMESArr = new String[Count];
        String[] ACADArr = new String[Count];

        int size = OFFERArr.length;

        for(int i=0;i<size;i++){
            OFFERArr[i] = offerno[i];
            SUBArr[i] = subcode[i];
            SCHEDArr[i] = sched[i];
            ROOMArr[i] = room[i];
            TEACHArr[i] = teachid[i];
            ENROLArr[i] = enrolmentid[i];
            STUIDArr[i] = studentid[i];
            SEMESArr[i] = semes[i];
            ACADArr[i] = academic[i];
        }

        SubjectsAdapter ada = new SubjectsAdapter(this,OFFERArr,SUBArr,SCHEDArr,ROOMArr,TEACHArr, ENROLArr, STUIDArr, SEMESArr,ACADArr);
        recycler_sub.setAdapter(ada);
    }

    private void GetStudents(int Count, String[] studentsid, String[] studentname, String[] course, String[] year, String[]enrolid, String[] offerno, String[] semes, String[] acad){
        String[] STUArr = new String[Count];
        String[] NAMEArr = new String[Count];
        String[] COURArr = new String[Count];
        String[] YEARArr = new String[Count];
        String[] ENROLArr = new String[Count];
        String[] OFFERArr = new String[Count];
        String[] SEMESArr = new String[Count];
        String[] ACADArr = new String[Count];

        int size = STUArr.length;

        for(int i=0;i<size;i++){
            STUArr[i] = studentsid[i];
            NAMEArr[i] = studentname[i];
            COURArr[i] = course[i];
            YEARArr[i] = year[i];
            ENROLArr[i] = enrolid[i];
            OFFERArr[i] = offerno[i];
            SEMESArr[i] = semes[i];
            ACADArr[i] = acad[i];
        }

        StudentsAdapter ada = new StudentsAdapter(this,STUArr,NAMEArr,COURArr,YEARArr,ENROLArr, OFFERArr, SEMESArr, ACADArr);
        recycler_stu.setAdapter(ada);
    }
}
package com.example.displaystudents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {

    Context context;
    String[] STUDENTID;
    String[] STUDENTNAME;
    String[] COURSE;
    String[] YEAR;
    String[] ENROLID;
    String[] OFFERNO;
    String[] SEMES;
    String[] ACAD;

    public StudentsAdapter(Context context, String[] STUDENTID, String[] STUDENTNAME, String[] COURSE, String[] YEAR, String[] ENROLID, String[] OFFERNO, String[] SEMES, String[] ACAD) {
        this.context = context;
        this.STUDENTID = STUDENTID;
        this.STUDENTNAME = STUDENTNAME;
        this.COURSE = COURSE;
        this.YEAR = YEAR;
        this.ENROLID = ENROLID;
        this.OFFERNO = OFFERNO;
        this.SEMES = SEMES;
        this.ACAD = ACAD;
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder {

        TextView inStudentId, inStudentName, inCourse, inYear, inEnrolID, inOfferNo, inSemes, inAcad;
        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);
            inStudentId = itemView.findViewById(R.id.In_StudentID);
            inStudentName = itemView.findViewById(R.id.In_StudentName);
            inCourse = itemView.findViewById(R.id.In_Course);
            inYear = itemView.findViewById(R.id.In_YearLevel);
            inEnrolID = itemView.findViewById(R.id.In_EnrolmentID);
            inOfferNo = itemView.findViewById(R.id.In_OfferingNo);
            inSemes = itemView.findViewById(R.id.In_Semester);
            inAcad = itemView.findViewById(R.id.In_AcademicYear);
        }
    }
    @Override
    public int getItemCount() {
        return STUDENTID.length;
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_students,parent, false);
        return new StudentsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        holder.inStudentId.setText(STUDENTID[position]);
        holder.inStudentName.setText(STUDENTNAME[position]);
        holder.inCourse.setText(COURSE[position]);
        holder.inYear.setText(YEAR[position]);
        holder.inEnrolID.setText(ENROLID[position]);
        holder.inOfferNo.setText(OFFERNO[position]);
        holder.inSemes.setText(SEMES[position]);
        holder.inAcad.setText(ACAD[position]);
    }
}

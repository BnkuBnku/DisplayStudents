package com.example.displaystudents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder> {

    Context context;
    String[] OFFERNO;
    String[] SUBCODE;
    String[] SCHED;
    String[] ROOM;
    String[] TEACHID;
    String[] ENROLID;
    String[] STUID;
    String[] SEMES;
    String[] ACAD;

    public SubjectsAdapter(Context context, String[] OFFERNO, String[] SUBCODE, String[] SCHED, String[] ROOM, String[] TEACHID, String[] ENROLID, String[] STUID, String[] SEMES, String[] ACAD) {
        this.context = context;
        this.OFFERNO = OFFERNO;
        this.SUBCODE = SUBCODE;
        this.SCHED = SCHED;
        this.ROOM = ROOM;
        this.TEACHID = TEACHID;
        this.ENROLID = ENROLID;
        this.STUID = STUID;
        this.SEMES = SEMES;
        this.ACAD = ACAD;
    }

    public class SubjectsViewHolder extends RecyclerView.ViewHolder {
        TextView inofferno, insubcode, insched, inroom, inteachid, inenrollid, instudid, insemes, incad;

        public SubjectsViewHolder(@NonNull View itemView) {
            super(itemView);
            inofferno = itemView.findViewById(R.id.In_SubOfferingNo);
            insubcode = itemView.findViewById(R.id.In_SubSubjCode);
            insched = itemView.findViewById(R.id.In_SubSchedule);
            inroom = itemView.findViewById(R.id.In_SubRoom);
            inteachid = itemView.findViewById(R.id.In_SubTeacherID);
            inenrollid = itemView.findViewById(R.id.In_SubEnrolmentID);
            instudid = itemView.findViewById(R.id.In_SubStudentID);
            insemes = itemView.findViewById(R.id.In_SubSemester);
            incad = itemView.findViewById(R.id.In_SubAcademicYear);
        }
    }

    @Override
    public int getItemCount() {
        return OFFERNO.length;
    }

    @NonNull
    @Override
    public SubjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_subjects,parent, false);
        return new SubjectsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectsViewHolder holder, int position) {
        holder.inofferno.setText(OFFERNO[position]);
        holder.insubcode.setText(SUBCODE[position]);
        holder.insched.setText(SCHED[position]);
        holder.inroom.setText(ROOM[position]);
        holder.inteachid.setText(TEACHID[position]);
        holder.inenrollid.setText(ENROLID[position]);
        holder.instudid.setText(STUID[position]);
        holder.insemes.setText(SEMES[position]);
        holder.incad.setText(ACAD[position]);
    }
}

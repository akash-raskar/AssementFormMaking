package com.example.assesment_form_making;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    String Gender = "", Status = "", Religion = "", Cast = "", ID = "", Refrence = "", Occupation = "";
    SQLiteDatabase db;
    DatePickerDialog date;
    static String dob_val;
    static StringBuffer buffer;
    Button Insert, Delete, Update, View;
    EditText edt1, edt2, edt3, edt4, edt5, edt6, edt7, edt8, edt9, edt10,
            edt11, edt12, edt13, edt14, edt15, edt16, edt17, edt18, edt19, edt20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);   //Full Name
        edt2 = findViewById(R.id.edt2);   //Father
        edt3 = findViewById(R.id.edt3);   //Mother
        edt4 = findViewById(R.id.edt4);   //DOB
        edt5 = findViewById(R.id.edt5);   //Mobile
        edt6 = findViewById(R.id.edt6);   //Alternet Mobile
        edt7 = findViewById(R.id.edt7);   //Email

        //Address
        edt8 = findViewById(R.id.edt8);   //House No.
        edt9 = findViewById(R.id.edt9);   //Landmark
        edt10 = findViewById(R.id.edt10); //Town
        edt11 = findViewById(R.id.edt11); //Tahsil
        edt12 = findViewById(R.id.edt12); //District
        edt13 = findViewById(R.id.edt13); //State
        edt14 = findViewById(R.id.edt14); //Pincode

        //Refer To other
        edt15 = findViewById(R.id.edt15); //1)Name
        edt16 = findViewById(R.id.edt16); //Mobile No
        edt17 = findViewById(R.id.edt17); //2)Name
        edt18 = findViewById(R.id.edt18); //Mobile No
        edt19 = findViewById(R.id.edt19); //3)Name
        edt20 = findViewById(R.id.edt20); //Mobile No


        //Database Store Buttons
        Insert = findViewById(R.id.Insert);
        Update = findViewById(R.id.Update);
        Delete = findViewById(R.id.Delete);
        View = findViewById(R.id.ViewAll);
        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);

        db = openOrCreateDatabase("AssesmentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "assesment" +
                "(fullname VARCHAR," +
                "father VARCHAR," +
                "mother VARCHAR," +
                "dob VARCHAR," +
                "mobile VARCHAR," +
                "alternet VARCHAR," +
                "email VARCHAR," +
                "gender VARCHAR," +
                "house VARCHAR," +
                "land VARCHAR," +
                "town VARCHAR," +
                "tahsil VARCHAR," +
                "dist VARCHAR," +
                "state VARCHAR," +
                "pin VARCHAR," +
                "status VARCHAR," +
                "idproof VARCHAR," +
                "religion VARCHAR," +
                "castcate VARCHAR," +
                "name1 VARCHAR," +
                "occupation VARCHAR," +
                "refrence VARCHAR," +
                "mobile1 VARCHAR," +
                "name2 VARCHAR," +
                "mobile2 VARCHAR," +
                "name3 VARCHAR," +
                "mobile3 VARCHAR);");
    }


    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {


            case R.id.Insert: {
                // Checking for empty fields
                if (edt1.getText().toString().trim().length() == 0 ||
                        edt2.getText().toString().trim().length() == 0 ||
                        edt3.getText().toString().trim().length() == 0 ||
                        edt4.getText().toString().trim().length() == 0 ||
                        edt5.getText().toString().trim().length() == 0 ||
                        edt6.getText().toString().trim().length() == 0 ||
                        edt7.getText().toString().trim().length() == 0 ||
                        edt8.getText().toString().trim().length() == 0 ||
                        edt9.getText().toString().trim().length() == 0 ||
                        edt10.getText().toString().trim().length() == 0 ||
                        edt11.getText().toString().trim().length() == 0 ||
                        edt12.getText().toString().trim().length() == 0 ||
                        edt13.getText().toString().trim().length() == 0 ||
                        edt14.getText().toString().trim().length() == 0 ||
                        edt15.getText().toString().trim().length() == 0 ||
                        edt16.getText().toString().trim().length() == 0 ||
                        edt17.getText().toString().trim().length() == 0 ||
                        edt18.getText().toString().trim().length() == 0 ||
                        edt19.getText().toString().trim().length() == 0 ||
                        edt20.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter all values");
                    return;
                }


                //Isert Data
                db.execSQL("INSERT INTO assesment VALUES('"
                        + edt1.getText() + "','"        //FULL NAME
                        + edt2.getText() + "','"        //FATHER NAME
                        + edt3.getText() + "','"        //MOTHER NAME
                        + edt4.getText() + "','"        //DOB
                        + edt5.getText() + "','"        //MOBILE
                        + edt6.getText() + "','"        //ALTERNET MOBILE
                        + edt7.getText() + "','"        //EMAIL
                        + Gender + "','"                //GENDER
                        + edt8.getText() + "','"        //HOUSE
                        + edt9.getText() + "','"        //LANDMARK
                        + edt10.getText() + "','"       //TOWN
                        + edt11.getText() + "','"       //TAHSIL
                        + edt12.getText() + "','"       //DISTRICT
                        + edt13.getText() + "','"       //STATE
                        + edt14.getText() + "','"       //PIN CODE
                        + Status + "','"                //MARITAL STATUS
                        + ID + "','"                    //ID PROOF
                        + Religion + "','"              // RELIGION
                        + Cast + "','"                  //CAST
                        + Occupation + "','"            //OCCUPATION
                        + Refrence + "','"              //REFERENCE
                        + edt15.getText() + "','"       //1)NAME
                        + edt16.getText() + "','"       //1)MOBILE
                        + edt17.getText() + "','"       //2)NAME
                        + edt18.getText() + "','"       //2)MOBILE
                        + edt19.getText() + "','"       //3)NAME
                        + edt20.getText() + "');");     //3)MOBILE

                showMessage("Success", "Record added");
                clearText();
            }
            break;


            //VIEW ALL RECORDS
            case R.id.ViewAll: {
                Cursor c4 = db.rawQuery("SELECT * FROM assesment", null);
                if (c4.getCount() == 0) {
                    showMessage("Error", "No records found");
                    return;
                }
                buffer = new StringBuffer();
                while (c4.moveToNext()) {
                    buffer.append(Html.fromHtml("<b>" + "FULL NAME :" + "</b>") + c4.getString(0) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "FATHER NAME :" + "</b>") + c4.getString(1) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "MOTHER NAME :" + "</b>") + c4.getString(2) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "DATE OF BIRTH :" + "</b>") + c4.getString(3) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "MOBILE NO :" + "</b>") + c4.getString(4) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "ALTERNET MOBILE NO :" + "</b>") + c4.getString(5) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "EMAIL ID :" + "</b>") + c4.getString(6) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "GENDER :" + "</b>") + c4.getString(7) + "\n");

                    //ADDRESS
                    buffer.append(Html.fromHtml("<b>" + "ADDRESS :" + "</b>") + c4.getString(8) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "," + "</b>") + c4.getString(9) + "");
                    buffer.append(Html.fromHtml("<b>" + "," + "</b>") + c4.getString(10) + "");
                    buffer.append(Html.fromHtml("<b>" + "," + "</b>") + c4.getString(11) + "");
                    buffer.append(Html.fromHtml("<b>" + "," + "</b>") + c4.getString(12) + "");
                    buffer.append(Html.fromHtml("<b>" + " ," + "</b>") + c4.getString(13) + "");
                    buffer.append(Html.fromHtml("<b>" + "PIN/ZIP :" + "</b>") + c4.getString(14) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "MARITAL STATUS :" + "</b>") + c4.getString(15) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "SELECTED ID PROOF :" + "</b>") + c4.getString(16) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "RELIGION :" + "</b>") + c4.getString(17) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "CAST CATEGORY :" + "</b>") + c4.getString(18) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "OCCUPATION :" + "</b>") + c4.getString(19) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "YOUR REFRENCE :" + "</b>") + c4.getString(20) + "\n");

                    //REFER TO OTHER
                    buffer.append(Html.fromHtml("<b>" + "REFER TO OTHER :" + "</b>") + c4.getString(21) + "\n");
                    buffer.append(Html.fromHtml("<b>" + "1)" + "</b>") + c4.getString(21) + "");
                    buffer.append(Html.fromHtml("<b>" + "( " + "</b>") + c4.getString(22) + ")\n");
                    buffer.append(Html.fromHtml("<b>" + "2)" + "</b>") + c4.getString(23) + "");
                    buffer.append(Html.fromHtml("<b>" + "( " + "</b>") + c4.getString(24) + ")\n");
                    buffer.append(Html.fromHtml("<b>" + "3)" + "</b>") + c4.getString(25) + "");
                    buffer.append(Html.fromHtml("<b>" + "( " + "</b>") + c4.getString(26) + ")\n");

                }

            }

            Intent intent = new Intent(MainActivity.this, com.example.assesment_form_making.ViewAll.class);
            startActivity(intent);
            //showMessage("Student Details", buffer.toString());
            break;
        }


    }


    private void clearText() {
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt1.requestFocus();
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void selectdob(android.view.View view) {
        final Calendar c = Calendar.getInstance();
        int myear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        date = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dob_val = dayOfMonth + "/" + (month + 1) + "/" + year;
                edt4.setText(dob_val);
            }
        }, myear, mMonth, mDay);
        date.show();
    }

    //Button Event
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.male:
                if (checked) {
                    Gender = "Male";
                }
                break;
            case R.id.female:
                if (checked) {
                    Gender = "Female";
                }
                break;
            case R.id.other:
                if (checked) {
                    Gender = "Other";
                }
                break;
        }
    }

    public void onRadioButtonClicked1(View view) {
        boolean checked1 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.married:
                if (checked1) {
                    Status = "Married";
                }
                break;
            case R.id.single:
                if (checked1) {
                    Status = "Single";
                }
                break;
            case R.id.divorced:
                if (checked1) {
                    Status = "Divorced";
                }
                break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        boolean checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.hindu:
                if (checked2) {
                    Religion = "Hindu";
                }
                break;
            case R.id.muslim:
                if (checked2) {
                    Religion = "Muslim";
                }
                break;
            case R.id.sikh:
                if (checked2) {
                    Religion = "Sikh";
                }
                break;
            case R.id.christian:
                if (checked2) {
                    Religion = "Christian";
                }
                break;
            case R.id.jain:
                if (checked2) {
                    Religion = "Jain";
                }
                break;
            case R.id.buddh:
                if (checked2) {
                    Religion = "Buddhiest";
                }
                break;
            case R.id.other3:
                if (checked2) {
                    Religion = "Other";
                }
                break;
        }
    }

    public void onRadioButtonClicked3(View view) {
        boolean checked3 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.open:
                if (checked3) {
                    Cast = "General";
                }
                break;
            case R.id.obc:
                if (checked3) {
                    Cast = "OBC";
                }
                break;
            case R.id.sc:
                if (checked3) {
                    Cast = "SC";
                }
                break;
            case R.id.st:
                if (checked3) {
                    Cast = "ST";
                }
                break;
            case R.id.other4:
                if (checked3) {
                    Cast = "Other";
                }
                break;
        }
    }


    //Check Box Event
    public void onCheckBox(View view) {
        boolean checked4 = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.aadhar:
                if (checked4) {
                    ID = "Aadhar Card";
                }

            case R.id.voter:
                if (checked4) {
                    ID = "Voter ID";
                }

            case R.id.driving:
                if (checked4) {
                    ID = "Driving License";
                }

            case R.id.bpl:
                if (checked4) {
                    ID = "BPL Card";
                }

            case R.id.ration:
                if (checked4) {
                    ID = "Ration Card";
                }

            case R.id.pan:
                if (checked4) {
                    ID = "PAN Card";
                }

            case R.id.passport:
                if (checked4) {
                    ID = "Passport";
                }

            case R.id.narega:
                if (checked4) {
                    ID = "Narega Card";
                }

            case R.id.other1:
                if (checked4) {
                    ID = "Other";
                }

        }
    }

    public void onCheckBox1(View view) {
        boolean checked5 = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.pradhan:
                if (checked5) {
                    Refrence = "Pradhan";
                }

            case R.id.friend:
                if (checked5) {
                    Refrence = "Friend";
                }

            case R.id.community:
                if (checked5) {
                    Refrence = "Community Members";
                }

            case R.id.teachers:
                if (checked5) {
                    Refrence = "Teachers/Principal";
                }

            case R.id.poster:
                if (checked5) {
                    Refrence = "Poster";
                }

            case R.id.net:
                if (checked5) {
                    Refrence = "Internet";
                }

            case R.id.advertise:
                if (checked5) {
                    Refrence = "Advertisement";
                }

            case R.id.other2:
                if (checked5) {
                    Refrence = "Other";
                }

        }
    }

    public void onCheckBox2(View view) {
        boolean checked5 = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.aadhar:
                if (checked5) {
                    Occupation = "Employed-Agriculture";
                }

            case R.id.voter:
                if (checked5) {
                    Occupation = "Employed-Non Agriculture";
                }

            case R.id.driving:
                if (checked5) {
                    Occupation = "Self Employed-Agriculture";
                }

            case R.id.bpl:
                if (checked5) {
                    Occupation = "Self Employed-Non Agriculture";
                }

            case R.id.ration:
                if (checked5) {
                    Occupation = "Unemployed";
                }

            case R.id.pan:
                if (checked5) {
                    Occupation = "Student";
                }

        }
    }

}
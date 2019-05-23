package com.example.sunghyun_dev.seoulspot;

import android.app.DatePickerDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int adultNum = 0;
    int kidNum = 0;
    int totalNum = 0;

    //새여행하기 레이아웃
    LinearLayout main1Layout;
    Button backButton;
    RelativeLayout travelSchedule;
    RelativeLayout peopleNumLayout;
    RelativeLayout searchHotel;
    TextView peopleNum;
    Button makeNewTravel;

    //팝업 레이아웃
    RelativeLayout popupLayout;
    Button xButton;
    ImageButton adultMinus;
    TextView adultNumber;
    ImageButton adultPlus;
    ImageButton kidMinus;
    TextView kidNumber;
    ImageButton kidPlus;
    TextView totalPeople;

    boolean isInputPeople = false;
    boolean isInputSchedule = false;
    boolean isSearch = false;

    //날짜 선택
    private String TAG = "PickerActivity";
    TextView tvTravelSchedule;
    String startDay="";
    String lastDay="";
    TextView tvNext;
    TextView tvSetLastDay;

    //숙소
    EditText edtInputMyHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //main1 레이아웃
        main1Layout = (LinearLayout) findViewById(R.id.main1Layout);
        backButton = (Button) findViewById(R.id.backButton);
        travelSchedule = (RelativeLayout) findViewById(R.id.travelScheduleButton);
        peopleNumLayout = (RelativeLayout) findViewById(R.id.peopleNumberButton);
        peopleNum = (TextView) findViewById(R.id.peopleNum);
        searchHotel = (RelativeLayout) findViewById(R.id.searchHotelButton);
        makeNewTravel = (Button) findViewById(R.id.makeNewTravel);

        //팝업 레이아웃
        popupLayout = (RelativeLayout) findViewById(R.id.popupLayout);
        xButton = (Button) findViewById(R.id.xButton);
        adultMinus = (ImageButton) findViewById(R.id.adultMinusButton);
        adultNumber = (TextView) findViewById(R.id.adultNumber);
        adultPlus = (ImageButton) findViewById(R.id.adultPlusButton);
        kidMinus = (ImageButton) findViewById(R.id.kidMinusButton);
        kidNumber = (TextView) findViewById(R.id.kidNumber);
        kidPlus = (ImageButton) findViewById(R.id.kidPlusButton);
        totalPeople = (TextView) findViewById(R.id.totalPeople);

        //날짜 선택
        tvTravelSchedule=(TextView)findViewById(R.id.tvTravelSchedule);
        tvNext=(TextView)findViewById(R.id.tvNext);
        tvSetLastDay=(TextView)findViewById(R.id.tvSetLastDay);

        //숙소입력
        edtInputMyHotel=(EditText)findViewById(R.id.edtInputMyHotel);

        init();
        noPopup();

        inputHotels();



    }

    //팝업창 X일 때
    public void noPopup() {
        main1Layout.setVisibility(View.VISIBLE);
        popupLayout.setVisibility(View.GONE);

        //<버튼
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //<버튼 클릭 시
            }
        });
        //여행일정버튼
        travelSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여행일정버튼 클릭 시
            }
        });
        //인원수버튼
        peopleNumLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();
            }
        });
        //숙소찾기버튼
        searchHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //숙소찾기버튼 클릭 시
            }
        });
        //새여행등록버튼
        makeNewTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인원수 작성 체크
                if (totalNum == 0) {
                    isInputPeople = true;
                } else {
                    isInputPeople = false;
                }

//                if (isInputSchedule == true && isInputPeople == true && isSearch == true) {
//                    //모두 입력했을 시 새 여행 등록
//                } else {
//                    Toast.makeText(getApplicationContext(), "여행일정, 인원, 숙소를 모두 입력하세요.", Toast.LENGTH_SHORT).show();
//                }
//
                if(!(tvTravelSchedule.getText().toString().equals("여행 일정")) && !(peopleNum.getText().toString().equals("인원수")) && !(edtInputMyHotel.getText().toString().equals("숙소 입력"))){
                    Intent intent=new Intent(getApplicationContext(),SetPlaceActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "여행일정, 인원, 숙소를 모두 입력하세요.", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }


    //팝업창떴을 때
    public void popup() {
        main1Layout.setVisibility(View.VISIBLE);
        popupLayout.setVisibility(View.VISIBLE);

        //팝업창 끄기
        xButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noPopup();
            }
        });

        //인원 입력 완료
        totalPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noPopup();
            }
        });

        //성인인원조절버튼
        adultMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adultNum == 0 || adultNum < 0) {
                    adultNum = 0;
                } else {
                    adultNum--;
                    totalNum--;
                }
                adultNumber.setText(String.valueOf(adultNum));
                totalPeople.setText("총 " + totalNum + "인");
                peopleNum.setText("총 " + totalNum + "인");
            }
        });
        adultPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adultNum++;
                totalNum++;
                adultNumber.setText(String.valueOf(adultNum));
                totalPeople.setText("총 " + totalNum + "인");
                peopleNum.setText("총 " + totalNum + "인");
            }
        });

        //아이인원조절버튼
        kidMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kidNum == 0) {
                    kidNum = 0;
                } else {
                    kidNum--;
                    totalNum--;
                }
                kidNumber.setText(String.valueOf(kidNum));
                totalPeople.setText("총 " + totalNum + "인");
                peopleNum.setText("총 " + totalNum + "인");
            }
        });
        kidPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kidNum++;
                totalNum++;
                kidNumber.setText(String.valueOf(kidNum));
                totalPeople.setText("총 " + totalNum + "인");
                peopleNum.setText("총 " + totalNum + "인");
            }
        });
    }

    private void init() {
        final Calendar calendar = Calendar.getInstance();
        Log.e(TAG, calendar.get(Calendar.YEAR) + "");
        Log.e(TAG, calendar.get(Calendar.MONTH) + 1 + "");
        Log.e(TAG, calendar.get(Calendar.DATE) + "");
        Log.e(TAG, calendar.get(Calendar.HOUR_OF_DAY) + "");
        Log.e(TAG, calendar.get(Calendar.MINUTE) + "");



        //DATE PICKER DIALOG
        tvTravelSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                        String msg = String.format("%d년 %d월 %d일", year, month + 1, date);
                        startDay=msg;
                        tvTravelSchedule.setText(startDay+"");
                        tvNext.setVisibility(View.VISIBLE);
                        tvSetLastDay.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

//                dialog.getDatePicker().setMaxDate(new Date().getTime());    //입력한 날짜 이후로 클릭 안되게 옵션
                dialog.show();




            }
        });

        tvSetLastDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                        String msg = String.format("%d년 %d월 %d일", year, month + 1, date);
                        lastDay=msg;
                        tvSetLastDay.setText(lastDay+"");
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

//                dialog.getDatePicker().setMaxDate(new Date().getTime());    //입력한 날짜 이후로 클릭 안되게 옵션
                dialog.show();
            }
        });


    }

    private void inputHotels(){

        edtInputMyHotel.setImeOptions(EditorInfo.IME_ACTION_DONE);
        edtInputMyHotel.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_DONE){
                    Intent intent=new Intent(getApplicationContext(), SelectHotelsActivity.class);
                    intent.putExtra("hotelName",""+edtInputMyHotel.getText().toString());
                    startActivityForResult(intent,100);
                }

                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(resultCode==RESULT_OK){
            edtInputMyHotel.setText(data.getStringExtra("hotelName")+"");

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}


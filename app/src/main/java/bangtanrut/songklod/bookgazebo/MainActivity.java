package bangtanrut.songklod.bookgazebo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial View
        initialView();

        //Controller
        controller();

    }   // Main Method

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void initialView() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtRegister);
        button = (Button) findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View view) {

        //For TextView
        if (view == textView) {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        }

        //for button
        if (view == button) {

            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            if (userString.equals("") || passwordString.equals("")) {
                // Have Space
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                        getResources().getString(R.string.title_HaveSpace));
            } else {
                //NO space
                checkUserAnPassword();
            }

        }

    }   // onClick

    private void checkUserAnPassword() {

        boolean b = true;
        MyConstant myConstant = new MyConstant();
        String[] columnUserStrings = myConstant.getColumnUserStrings();
        String[] loginStrings = new String[columnUserStrings.length];

        try {

            GetData getData = new GetData(MainActivity.this);
            getData.execute(myConstant.getUrlGetUser());
            String strJSON = getData.get();
            Log.d("23Aprilv1", "JSON ==>" + strJSON);

        } catch (Exception e) {
            Log.d("23Aprilv1", "e checkUser ==>" + e.toString());
        }

    }//checkUserAnPassword

}   // Main Class

package assignment3.rlovelett.pizzaorderform;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton smallPizza;
    RadioButton mediumPizza;
    RadioButton largePizza;
    CheckBox addTop;
    CheckBox addDelivery;
    EditText textViewResult;
    RadioGroup groupButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewResult = (EditText) findViewById((R.id.editTextTotal));
        smallPizza = (RadioButton) findViewById(R.id.radioButtonSmall);
        mediumPizza = (RadioButton) findViewById(R.id.radioButtonMed);
        largePizza = (RadioButton) findViewById(R.id.radioButtonLarge);
        addTop = (CheckBox) findViewById(R.id.checkCheese);
        addDelivery = (CheckBox) findViewById(R.id.checkDel);
        groupButtons = (RadioGroup) findViewById(R.id.radioGroup4);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void ClickButtonTotal(View view) {
        Double cheese = 1.75;
        Double delivery = 2.5;
        Double totalCharge = 0.0;

        if(smallPizza.isChecked()) {
            totalCharge = 7.0;
        }
        else if (mediumPizza.isChecked()) {
            totalCharge = 9.0;
        }
        else if(largePizza.isChecked()) {
            totalCharge = 13.0;
        }

        if (addTop.isChecked()) {
            totalCharge = totalCharge + cheese;
        }
        if(addDelivery.isChecked()){
            totalCharge = totalCharge + delivery;
        }

        textViewResult.setText("Your total is: " + totalCharge);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

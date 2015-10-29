package dam2.act_2_5_di_jose_igualada_calero;

    //JOSE IGUALADA CALERO

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static Button btnArriba, btnAbajo;
    private TextView txtUltimo, txtContador, txtMensaje;
    String ultimo, contador, ult;
    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbajo = (Button) findViewById(R.id.btnAbajo);
        btnArriba = (Button) findViewById(R.id.btnArriba);
        txtUltimo = (TextView) findViewById(R.id.txtUltimo);
        txtContador = (TextView) findViewById(R.id.txtContador);
        txtMensaje = (TextView) findViewById(R.id.txtMensaje);

        ultimo = "El último botón que has pulsado es: ";
        ult = "Ninguno";
        contador = "Has pulsado los botones 0 veces!";
        cont = 0;

        txtUltimo.setText(ultimo + ult);
        txtContador.setText(contador);

        btnArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ult = "Arriba";
                cont = cont + 1;
                contador = "Has pulsado los botones "+ cont +" veces!";

                txtUltimo.setText(ultimo+ ult);
                txtContador.setText(contador);

            }
        });

        btnAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ult= "Abajo";
                cont = cont + 1;
                contador = "Has pulsado los botones "+ cont +" veces!";

                txtUltimo.setText(ultimo+ ult);
                txtContador.setText(contador);

            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("CONT", cont);
        outState.putString("ULT", ult);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        cont = savedInstanceState.getInt("CONT");
        txtContador.setText("Has pulsado los botones "+ cont +" veces!");

        ult = savedInstanceState.getString("ULT");
        txtUltimo.setText(ultimo + ult);
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

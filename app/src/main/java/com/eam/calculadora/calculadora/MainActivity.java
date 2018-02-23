package com.eam.calculadora.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumero1,txtNumero2;
    private Button btnSuma,btnResta,btnMultiplicar,btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtNumero1 = (EditText) findViewById(R.id.txtNumero1);
        this.txtNumero2 = (EditText) findViewById(R.id.txtNumero2);
        this.btnSuma = (Button) findViewById(R.id.btnSuma);
        this.btnResta = (Button) findViewById(R.id.btnResta);
        this.btnMultiplicar = (Button) findViewById(R.id.btnMultiplicacion);
        this.btnDividir = (Button) findViewById(R.id.btnDivision);
        asignarAccionesBtn();
    }

    private int[] capturarNumeros() throws Exception {
        int[] numeros = new int[2];
        numeros[0] = Integer.parseInt(this.txtNumero1.getText().toString());
        numeros[1] = Integer.parseInt(this.txtNumero2.getText().toString());
        return numeros;
    }

    private void asignarAccionesBtn(){
        this.btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("\\+");
            }
        });
        this.btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("-");
            }
        });
        this.btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("*");
            }
        });
        this.btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacion("/");
            }
        });
    }

    private void realizarOperacion(String operador){
        String mensaje;
        try {
            int[] numeros = capturarNumeros();
            double resultado = 0;
            switch (operador) {
                case "\\+":
                    resultado = (double) numeros[0] + numeros[1];
                    break;
                case "-":
                    resultado = (double) numeros[0] - numeros[1];
                    break;
                case "*":
                    resultado = (double) numeros[0] * numeros[1];
                    break;
                case "/":
                    resultado = (double) numeros[0] / numeros[1];
                    break;
            }
            mensaje = "El resultado de la operación es " + resultado;
        }catch (Exception e){
            mensaje = "No se ha ingresado numeros";
        }

        Toast.makeText(this,mensaje, Toast.LENGTH_SHORT).show();
    }
}

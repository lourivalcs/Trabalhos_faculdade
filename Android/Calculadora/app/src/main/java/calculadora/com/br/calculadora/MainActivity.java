package calculadora.com.br.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String valor1 = "";
    private String valor2 = "";
    private String operador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

        String btnValue = ((Button)v).getText().toString();

        TextView txtDig = findViewById(R.id.txtDigitado);

        if(isNum(btnValue) && operador.isEmpty()){
            valor1 += btnValue;
        }else if(isOp(btnValue) && operador.isEmpty() && !valor1.isEmpty()){
            operador = btnValue;
        }else if(isNum(btnValue) && !operador.isEmpty()){
            valor2 += btnValue;
        }else if(btnValue.equals("=") && !valor2.isEmpty()){
            valor1 = calculo(Integer.parseInt(valor1), Integer.parseInt(valor2),operador);
            valor2=""; operador="";
        }else if(btnValue.equals("CE")){
            valor1=""; valor2=""; operador="";
            controlaBotoes(true);
        }

        txtDig.setText(valor1+operador+valor2);
    }

    private String calculo(int v1, int v2, String op){
        try {
            if (op.equals("X"))
                return String.valueOf(v1 * v2);
            else if (op.equals("/"))
                return String.valueOf(v1 / v2);
            else if (op.equals("+"))
                return String.valueOf(v1 + v2);
            else if (op.equals("-"))
                return String.valueOf(v1 - v2);
            else {
                controlaBotoes(false);
                return "Operador aritimético não encontrado";
            }

        }catch(Exception e) {
            controlaBotoes(false);
            return "Erro ao efetual cálculo";
        }
    }

    private boolean isNum(String txt){
        try{
            Integer.parseInt(txt);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    private boolean isOp(String txt){
        return txt.equals("X") || txt.equals("/") || txt.equals("+") || txt.equals("-");
    }

    private void controlaBotoes(boolean habilitar){
        ((Button)findViewById(R.id.btn0)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn1)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn2)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn3)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn4)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn5)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn6)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn7)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn8)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btn9)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btnMulti)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btnDiv)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btnSoma)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btnSub)).setEnabled(habilitar);
        ((Button)findViewById(R.id.btnIgual)).setEnabled(habilitar);
    }
}

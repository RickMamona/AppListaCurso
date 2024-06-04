package devandroid.mamona.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.mamona.applistacurso.R;
import devandroid.mamona.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    String dadosPessoa;
    EditText editNomeCompleto;
    EditText editCpf;
    EditText editDataNascimento;
    EditText editTelefone;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pessoa = new Pessoa();

        dadosPessoa = "Nome Completo: ";
        dadosPessoa += pessoa.getNomeCompleto();
        dadosPessoa +=" CPF: ";
        dadosPessoa += pessoa.getCpf();
        dadosPessoa +=" Data de Nascimento: ";
        dadosPessoa += pessoa.getDataDeNascimento();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        editCpf = findViewById(R.id.editCpf);
        editDataNascimento = findViewById(R.id.editDataNascimento);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNomeCompleto.setText(pessoa.getNomeCompleto());
        editCpf.setText(pessoa.getCpf());
        editDataNascimento.setText(pessoa.getDataDeNascimento());
        editTelefone.setText(pessoa.getTelefoneContato());
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNomeCompleto.setText("");
                editCpf.setText("");
                editDataNascimento.setText("");
                editTelefone.setText("");
            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setNomeCompleto(editNomeCompleto.getText().toString());
                pessoa.setCpf(editCpf.getText().toString());
                pessoa.setDataDeNascimento(editDataNascimento.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo"+pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });



        Log.i("POOAndroid", pessoa.toString());
    }
}
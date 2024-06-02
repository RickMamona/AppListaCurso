package devandroid.mamona.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

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

        pessoa.setNomeCompleto("Rick Silva Mamona");
        pessoa.setCpf("123.456.789-10");
        pessoa.setDataDeNascimento("07/03/1994");
        pessoa.setTelefoneContato("(79)99897-9643");

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


        Log.i("POOAndroid", pessoa.toString());
    }
}
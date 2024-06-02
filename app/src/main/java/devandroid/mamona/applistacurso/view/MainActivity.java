package devandroid.mamona.applistacurso.view;

import android.os.Bundle;

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

        int parada = 0;
    }
}
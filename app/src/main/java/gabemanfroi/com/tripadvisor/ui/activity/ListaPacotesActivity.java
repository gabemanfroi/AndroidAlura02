package gabemanfroi.com.tripadvisor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

import gabemanfroi.com.tripadvisor.R;
import gabemanfroi.com.tripadvisor.dao.PacoteDAO;
import gabemanfroi.com.tripadvisor.model.Pacote;
import gabemanfroi.com.tripadvisor.ui.adapter.ListaDePacotesAdapter;

import static gabemanfroi.com.tripadvisor.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String PACOTE = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        configuraListaDePacotes();
    }

    private void configuraListaDePacotes() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_list_view);
        final List<Pacote> pacotes = new PacoteDAO().lista();

        listaDePacotes.setAdapter(new ListaDePacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener((parent, view, position, id) -> {
            final Pacote pacoteClicado = pacotes.get(position);
            navegaParaResumoPacote(pacoteClicado);
        });
    }

    private void navegaParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, DetalhesPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }

}
package gabemanfroi.com.tripadvisor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gabemanfroi.com.tripadvisor.R;
import gabemanfroi.com.tripadvisor.dao.PacoteDAO;
import gabemanfroi.com.tripadvisor.model.Pacote;
import gabemanfroi.com.tripadvisor.ui.adapter.ListaDePacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        configuraListaDePacotes();
        Intent intent = new Intent(this, DetalhesPacoteActivity.class);
        startActivity(intent);
    }

    private void configuraListaDePacotes() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_list_view);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaDePacotesAdapter(pacotes, this));
    }

}
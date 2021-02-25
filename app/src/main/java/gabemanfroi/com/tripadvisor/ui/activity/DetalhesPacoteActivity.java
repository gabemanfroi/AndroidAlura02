package gabemanfroi.com.tripadvisor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gabemanfroi.com.tripadvisor.R;
import gabemanfroi.com.tripadvisor.model.Pacote;
import gabemanfroi.com.tripadvisor.util.DataUtil;
import gabemanfroi.com.tripadvisor.util.MoedaUtil;
import gabemanfroi.com.tripadvisor.util.ResourceUtil;

import static gabemanfroi.com.tripadvisor.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class DetalhesPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pacote);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido(getIntent());

    }

    private void carregaPacoteRecebido(Intent intent) {

        if (intent.hasExtra(CHAVE_PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            configuraViews(pacote);
            configuraBotaoComprar(pacote);
        }
    }

    private void configuraViews(final Pacote pacote) {

        mostraDestino(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraTotal(pacote);
        mostraPeriodo(pacote);

    }

    private void configuraBotaoComprar(final Pacote pacote) {
        Button botaoComprar = findViewById(R.id.activity_detalhes_pacote_botao_comprar);
        botaoComprar.setOnClickListener(v -> {
            navegaParaPagamento(pacote);
        });
    }

    private void navegaParaPagamento(Pacote pacote) {
        Intent intent = new Intent(DetalhesPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPeriodo(Pacote pacote) {
        TextView periodoTextView = findViewById(R.id.activity_detalhes_pacote_periodo);
        periodoTextView.setText(DataUtil.periodoEmTexto(pacote.getDias()));
    }

    private void mostraTotal(Pacote pacote) {
        TextView totalTextView = findViewById(R.id.activity_detalhes_pacote_total);
        totalTextView.setText(MoedaUtil.formataParaBrasileiro(pacote.getPreco()));
    }

    private void mostraDias(Pacote pacote) {
        TextView diasTextView = findViewById(R.id.activity_detalhes_pacote_dias);
        diasTextView.setText(pacote.getDias() + (pacote.getDias() > 1 ? " dias" : "dia"));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagemImageView = findViewById(R.id.activity_detalhes_pacote_background_image);
        imagemImageView.setImageDrawable(ResourceUtil.devolveDrawable(this, pacote.getImagem()));
    }

    private void mostraDestino(Pacote pacote) {
        TextView destinoTextView = findViewById(R.id.activity_detalhes_pacote_destino);
        destinoTextView.setText(pacote.getDestino());
    }
}
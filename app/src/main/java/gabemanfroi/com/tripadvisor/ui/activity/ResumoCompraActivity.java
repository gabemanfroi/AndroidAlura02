package gabemanfroi.com.tripadvisor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gabemanfroi.com.tripadvisor.R;
import gabemanfroi.com.tripadvisor.model.Pacote;
import gabemanfroi.com.tripadvisor.util.DataUtil;
import gabemanfroi.com.tripadvisor.util.MoedaUtil;
import gabemanfroi.com.tripadvisor.util.ResourceUtil;

import static gabemanfroi.com.tripadvisor.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR = "Resumo da Compra";
    private Pacote pacote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APPBAR);

        configuracaoInicial();

    }

    private void configuracaoInicial() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraDestino(pacote);
            mostraPeriodo(pacote);
            mostraTotal(pacote);
            mostraImagem(pacote);
        }
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagemImageView = findViewById(R.id.activity_resumo_compra_imagem_pacote);
        imagemImageView.setImageDrawable(ResourceUtil.devolveDrawable(this, pacote.getImagem()));
    }

    private void mostraTotal(Pacote pacote) {
        TextView totalTextView = findViewById(R.id.activity_resumo_compra_total);
        totalTextView.setText(MoedaUtil.formataParaBrasileiro(pacote.getPreco()));
    }

    private void mostraPeriodo(Pacote pacote) {
        TextView periodoTextView = findViewById(R.id.activity_resumo_compra_periodo);
        periodoTextView.setText(DataUtil.periodoEmTexto(pacote.getDias()));
    }

    private void mostraDestino(Pacote pacote) {
        TextView destinoTextView = findViewById(R.id.activity_resumo_compra_destino);
        destinoTextView.setText(pacote.getDestino());
    }


}
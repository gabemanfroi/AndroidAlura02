package gabemanfroi.com.tripadvisor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import gabemanfroi.com.tripadvisor.R;
import gabemanfroi.com.tripadvisor.model.Pacote;
import gabemanfroi.com.tripadvisor.util.MoedaUtil;

import static gabemanfroi.com.tripadvisor.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String APP_TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(APP_TITLE);

        configuracaoInicial();
    }

    private void configuracaoInicial() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraTotal(pacote);
            configuraBotaoFinalizaCompra(pacote);
        }


    }

    private void configuraBotaoFinalizaCompra(final Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.activity_pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(v -> {

            Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
            intent.putExtra(CHAVE_PACOTE, pacote);
            startActivity(intent);

        });
    }

    private void mostraTotal(Pacote pacote) {
        TextView totalPagamento = findViewById(R.id.activity_pagamento_total);
        totalPagamento.setText(MoedaUtil.formataParaBrasileiro(pacote.getPreco()));
    }
}
package gabemanfroi.com.tripadvisor.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import gabemanfroi.com.tripadvisor.R;
import gabemanfroi.com.tripadvisor.model.Pacote;
import gabemanfroi.com.tripadvisor.util.MoedaUtil;
import gabemanfroi.com.tripadvisor.util.ResourceUtil;

public class DetalhesPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pacote);
        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("249.99"));

        setTitle("Resumo do Pacote");

        TextView destino = findViewById(R.id.activity_detalhes_pacote_destino);
        destino.setText(pacote.getLocal());

        ImageView imagem = findViewById(R.id.activity_detalhes_pacote_background_image);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);

        TextView dias = findViewById(R.id.activity_detalhes_pacote_dias);
        dias.setText(pacote.getDias() + (pacote.getDias() > 1 ? " dias" : "dia"));

        TextView total = findViewById(R.id.activity_detalhes_pacote_total);
        total.setText(MoedaUtil.formataParaBrasileiro(pacote.getPreco()));

        TextView periodo = findViewById(R.id.activity_detalhes_pacote_periodo);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacote.getDias());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = simpleDateFormat.format(dataIda.getTime());
        String dataFormatadaVolta = simpleDateFormat.format(dataVolta.getTime());

        String dataFormatadaViagem =
                dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);

        periodo.setText(dataFormatadaViagem);

    }
}
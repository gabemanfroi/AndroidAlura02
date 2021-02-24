package gabemanfroi.com.tripadvisor.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gabemanfroi.com.tripadvisor.R;
import gabemanfroi.com.tripadvisor.util.ResourceUtil;
import gabemanfroi.com.tripadvisor.model.Pacote;
import gabemanfroi.com.tripadvisor.util.MoedaUtil;

public class ListaDePacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaDePacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(view, pacote);
        mostraImagem(view, pacote);
        mostraDias(view, pacote);
        mostraPreco(view, pacote);

        return view;
    }

    private void mostraPreco(View view, Pacote pacote) {
        TextView preco = view.findViewById(R.id.item_pacote_preco);
        preco.setText(MoedaUtil.formataParaBrasileiro(pacote.getPreco()));
    }

    private void mostraDias(View view, Pacote pacote) {
        TextView dias = view.findViewById(R.id.item_pacote_dias);
        dias.setText(pacote.getDias() + (pacote.getDias() > 1 ? " dias" : " dia"));
    }

    private void mostraImagem(View view, Pacote pacote) {
        ImageView backgroundImage = view.findViewById(R.id.item_pacote_background_image);
        Drawable drawableImagemPacote = ResourceUtil
                .devolveDrawable(context, pacote.getImagem());
        backgroundImage.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View view, Pacote pacote) {
        TextView destino = view.findViewById(R.id.item_pacote_nome_destino);
        destino.setText(pacote.getLocal());
    }
}

package gabemanfroi.com.tripadvisor.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import gabemanfroi.com.tripadvisor.model.Pacote;

public class ResourceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableEmTexto){
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE,
                context.getPackageName());

        return resources.getDrawable(idDoDrawable);
    }



}

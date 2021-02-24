package gabemanfroi.com.tripadvisor.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";

    public static String formataParaBrasileiro(BigDecimal valor) {
        return DecimalFormat
                .getCurrencyInstance(new Locale(PORTUGUES, BRASIL))
                .format(valor);
    }


}

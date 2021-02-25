package gabemanfroi.com.tripadvisor.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = simpleDateFormat.format(dataIda.getTime());
        String dataFormatadaVolta = simpleDateFormat.format(dataVolta.getTime());

        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }

}

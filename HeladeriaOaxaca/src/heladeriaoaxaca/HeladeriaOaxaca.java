package heladeriaoaxaca;

import Vista.FrmLogin;
import Vista.FrmVenta;
import Vista.FrmMenuGerente;
import Vista.FrmMercadoPago;
import Vista.FrmPagoTarjeta;
import Vista.FrmProductos;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import javax.swing.UIManager;

public class HeladeriaOaxaca {

    public static void main(String[] args) {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           FlatCarbonIJTheme.setup();

        } catch (Exception ex) {
            System.err.println("Error al inicializar LaF");
        }

        FrmLogin frm = new FrmLogin();
        //FrmPagoTarjeta frm=new FrmPagoTarjeta();
        //FrmMercadoPago frm=new FrmMercadoPago();
        frm.setVisible(true);
    }

}

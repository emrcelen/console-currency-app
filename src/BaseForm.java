import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseForm extends JFrame {
    private JPanel FirstJPanel;
    private JLabel dövizUygulamasıLabel;
    private JLabel JSONGüncellenmeLabel;
    private JButton veriyiGüncelleButton;
    private JLabel veriÇekiliyorLabel;
    private JButton dolarAlışButton;
    private JButton dolarSatışButton;


    public BaseForm(){
        add(FirstJPanel);
        setSize(600,400); // Formumuzun Boyutlarını Ayarlıyoruz.
        setTitle("Döviz Uygulaması v0.01 -> Emre Çelen");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Çıkış iconuna basınca bellekten formu siliyor.

        // Değişkenlerimiz Tanımlayalım:
        String guncellemeTarihi;
        // Form Başlatıldığı Zaman Verilerimizi Çekmesi İçin:
        JSONReader jsonReader = new JSONReader();
        jsonReader.showMe("USD");
        guncellemeTarihi = JSONReader.jSONGuncelleme;
        veriÇekiliyorLabel.setText(guncellemeTarihi); // Güncelleme verisin çektikten sonra label text değiştirtiyoruz.

        // Butona tıklanınca action ataması gerçekleştiriyoruz.
        veriyiGüncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONWrite jsonWrite = new JSONWrite();
                veriÇekiliyorLabel.setText(guncellemeTarihi);
                JOptionPane.showMessageDialog(null,"JSON Verisi Başarıyla Veri Güncellendi.","İşlem Başarılı",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        dolarSatışButton.setText(JSONReader.dovizSatis);
        dolarAlışButton.setText(JSONReader.dovizAlis);
    }
}

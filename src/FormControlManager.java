import javax.swing.*;

public class FormControlManager {   //  Form yapımızı kontrol edeceğimiz sınıf.
    public static void main(String[] args) {
        // Form yapımızı işletim sistemindeki elementlere uygun hale getirmek için UIManger tanımlaması yapıyoruz.
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException e){
            System.out.println("-> Hata Aldım: "+e);
        }
        catch (InstantiationException e){
            System.out.println("-> Hata Aldım: "+e);
        }
        catch (IllegalAccessException e){
            System.out.println("-> Hata Aldım: "+e);
        }
        catch (UnsupportedLookAndFeelException e){
            System.out.println("-> Hata Aldım: "+e);
        }

        // Form yapımızın çalıştırılması için bir thread içerisinde inşaat ediyoruz.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BaseForm baseForm = new BaseForm();
                baseForm.setVisible(true);
            }
        });

    }
}

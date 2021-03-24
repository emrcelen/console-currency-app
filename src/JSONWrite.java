import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class JSONWrite {
    static int saatBasi = 0; // Görev Metodu için tanımladık.
    public void baslat(){
        // JSON Dosyasındaki Verileri İnternet Sitesinden Çekerek "Veri.JSON" dosyasına yazdıracağız.
        try{
            URL url = new URL("https://finans.truncgil.com/v3/today.json"); // Veriyi Alacağımız URL Giriyoruz.
            HttpURLConnection hr = (HttpURLConnection) url.openConnection();
            //System.out.println(hr.getResponseCode()); //Bağlantı Cevap Numarasını öğreniyoruz.
            if(hr.getResponseCode() == 200){ // Eğerki bağlantı cevap numaramız bize lazım olan 200 ile aynı olduğu zaman işlemi gerçekleştiriyoruz.
                InputStream im = hr.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(im));
                File file = new File("C:/Users/winem/Desktop/Projeler/firstDovizKuru/src/main/java/dovizVeri.JSON");
                //FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/winem/Desktop/Projeler/firstDovizKuru/src/main/java/dovizVeri.JSON");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                String veri = (String) bufferedReader.readLine();
                while (veri!=null){
                    bufferedWriter.write(veri); // Okunan Veriyi Yazdırıyoruz.
                    bufferedWriter.newLine(); // Bir Aşağı Satıra Geçmesini İstiyoruz.
                    bufferedWriter.flush(); // Okunan verileri dosyada görmemiz için aktarım işlemini sağlıyor.
                    veri = bufferedReader.readLine(); // Yeni Veri Okutuyoruz.
                }
                // İşlemler Bitince Okuma ve Yazma İşlemlerini Kapatıyorum.
                bufferedWriter.close();
                bufferedReader.close();
                im.close();

            }
        }
        catch (Exception e){
            System.out.println("JSONWrite Sınıfı Exception Hatası.\n"+e);
        }
    }
    JSONWrite(){
        baslat(); // Main sınıfına tanımlama yaptıktan sonra ilk başta dosya oluşmasını istiyorum.
    }
    // JSON Bilgisinin 1 Saat boyunca güncellenmesini istiyoruz.
    public  void alertTimer(){
        Timer alertTimer = new Timer();
        TimerTask alertTask = new TimerTask() {
            @Override
            public void run() {
                if(saatBasi < 4) {
                        System.out.println(ConsoleManager.RED + "-> Program 15 Dakkikadır Aktif." + ConsoleManager.RESET);
                        System.out.println(ConsoleManager.BLUE + "-> JSON Bilgileri Genelde 15 Dakkikada Bir Yenilenir." + ConsoleManager.RESET);
                        System.out.println(ConsoleManager.YELLOW + "-> Bu Yüzden JSON Bilgileri Güncellenmek İçin Program Yeniden Başlatıldı.\n" + ConsoleManager.RESET + BaseMenuCreateManager.menuAyrac);
                        baslat();
                    saatBasi++;
                }
                else {
                    System.out.println(ConsoleManager.RED + "-> Program 60 Dakkikadır Aktif. Program Kapatıldı Tekrar Çalıştırın.\n" + ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
                    alertTimer.cancel();
                    System.exit(0);
                }

            }
        };
        alertTimer.schedule(alertTask,900000,900000); // Program başladıktan sonra 15dk sonra ilk görev başladıktan sonra her 15 dk da bir tekrar edecek.
    }
}


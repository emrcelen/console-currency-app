import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BaseMenuCreateManager {
    static String menuAyrac = ConsoleManager.CYAN+new String(new char[25]).replace("\0","-")+ConsoleManager.RESET;
    SimpleDateFormat zamanSekil = new SimpleDateFormat("d/M/y H:m:s");
    GregorianCalendar tarihVerisi = new GregorianCalendar();
    Object guncelZaman = zamanSekil.format(tarihVerisi.getTime());
    Scanner scanner = new Scanner(System.in);
    // Hoşgeldiniz ve Ön Bilgi Ekranı.
    void welcome(){
        System.out.println(menuAyrac);
        System.out.println(ConsoleManager.YELLOW+"< Döviz Console Uygulaması >\n"+ConsoleManager.RESET+menuAyrac);
        System.out.println(ConsoleManager.RED+"-> Uygulama Yapımcısı: "+ConsoleManager.RESET+ConsoleManager.GREEN+"Emre Çelen"+ConsoleManager.RESET);
        System.out.println(ConsoleManager.RED+"-> Uygulama Saati: "+ConsoleManager.RESET+ConsoleManager.GREEN+ guncelZaman+ConsoleManager.RESET);
        System.out.println(menuAyrac);
    }
    // Menü Seçenekleri:
    void startMenu(){
        String select;
        String ayrac = ConsoleManager.BLACK+"-"+ConsoleManager.RESET;
        String numaralar[] = {"[1] ","[2] ","[3] ","[4] "};

        System.out.println(ConsoleManager.RED+numaralar[0]+ConsoleManager.RESET+ayrac+ConsoleManager.BLUE+" Döviz Birimlerini Göster\n"+ConsoleManager.RESET
                +ConsoleManager.RED+numaralar[1]+ConsoleManager.RESET+ayrac+ConsoleManager.BLUE+" Döviz Sorgulaması Gerçekleştir\n"+ConsoleManager.RESET
                +ConsoleManager.RED+numaralar[2]+ConsoleManager.RESET+ayrac+ConsoleManager.BLUE+" JSON Bilgilerini Güncelle\n"+ConsoleManager.RESET
                +ConsoleManager.RED+numaralar[3]+ConsoleManager.RESET+ayrac+ConsoleManager.BLUE+" Programı Kapat"+ConsoleManager.RESET);
        System.out.println(menuAyrac);
        System.out.print(ConsoleManager.RED+"-> Hangi İşlemi Gerçekleştirmek İstiyorsunuz: "+ConsoleManager.RESET);
        select = scanner.nextLine();
        System.out.println(menuAyrac);
        selectMenu(select);
    }
    // Seçilen Menüye Yönlendirme:
    void selectMenu(String select){
        CurrencyUnitsManager currencyUnitsManager = new CurrencyUnitsManager();
        if(select.equalsIgnoreCase("bir")||select.equals("1") || select.equalsIgnoreCase("Döviz Birimlerini Göster")){
            currencyUnitsManager.currencyRead();
            currencyUnitsManager.currencyInfoMenu();
            currencyUnitsManager.currencyInfoBox();
            restartMenu();
        }
        else if(select.equalsIgnoreCase("iki")||select.equals("2") || select.equalsIgnoreCase("Döviz Sorgulaması Gerçekleştir")){
            currencyUnitsManager.currencyInfoMenu();
            currencyUnitsManager.currencyInfoBox();
            restartMenu();
        }
        else if(select.equalsIgnoreCase("üç")||select.equals("3") || select.equalsIgnoreCase("JSON Bilgilerini Güncelle")){
            JSONWrite jsonWrite = new JSONWrite();
            System.out.println(ConsoleManager.GREEN+"-> JSON Bilgileri Manuel Bir Şekilde Güncellendi.\n"+ConsoleManager.RESET+menuAyrac);
            restartMenu();
        }
        else if(select.equalsIgnoreCase("dört")||select.equals("4") || select.equalsIgnoreCase("Programı Kapat")){
            System.out.println(ConsoleManager.YELLOW+"-> Program Sonlandırıldı.\n"+ConsoleManager.RESET+menuAyrac);
            System.exit(0);
        }
        else {
            System.out.println(ConsoleManager.YELLOW+"-> Tanımsız Bir Değer Girdiniz. Program Sonlandırıldı.\n"+ConsoleManager.RESET+menuAyrac);
        }
    }
    void restartMenu(){
        String karar;
        System.out.print(ConsoleManager.YELLOW+"-> Ana menüye tekrar dönmek için"+ConsoleManager.RESET+ConsoleManager.GREEN+" [Y]"+ConsoleManager.RESET
                +ConsoleManager.YELLOW+", programı kapatmak için"+ConsoleManager.RESET
                +ConsoleManager.RED+" [N]"+ConsoleManager.RESET+ ConsoleManager.YELLOW+" tuşuna basın."+ConsoleManager.RESET);
        System.out.print(ConsoleManager.RED+"\n-> Kararınız: "+ConsoleManager.RESET);
        karar = scanner.nextLine();
        System.out.println(menuAyrac);
        if(karar.equalsIgnoreCase("y")){
            ConsoleManager.clear();
            startMenu();
        }
        else if(karar.equalsIgnoreCase("n")){
            System.out.println(ConsoleManager.RED+"-> Program Sonlandırıldı."+ConsoleManager.RESET);
            System.out.println(menuAyrac);
            System.exit(0);
        }
        else{
            System.out.println(ConsoleManager.RED+"-> Tanımsız Bir Değer Girdiniz."+ConsoleManager.RESET);
            System.out.println(menuAyrac);
            System.exit(0);
        }
    }
}

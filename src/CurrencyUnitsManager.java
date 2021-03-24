import java.util.Scanner;

// Çekeceğimiz Dövizlerin JSON isimlerini aklımızda tutmak için enum tanımlaması gerçekleştirdik.
enum currencyUnits{
    USD("Amerikan Doları"),
    EUR("Euro"),
    GBP("Sterlin"),
    CHF("İsviçre Frangı"),
    CAD("Kanada Doları"),
    RUB("Rus Rublesi"),
    KWD("Kuveyt Dinarı");
    private String moneyName;
    currencyUnits(String moneyName){
        this.moneyName = moneyName;
    }
    public String getMoneyName() {
        return moneyName;
    }
}
public class CurrencyUnitsManager {
    // Döviz Birimlerini Yazdıracağımız Metot:
    void currencyRead(){
        int count=1;
        String ayrac = ConsoleManager.BLACK+"-"+ConsoleManager.RESET;
        System.out.println(ConsoleManager.YELLOW+"< Döviz Birimleri >\n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
        for(currencyUnits c:currencyUnits.values()){
            System.out.println(ConsoleManager.RED+"["+count+"] "+ConsoleManager.RESET+ayrac+ConsoleManager.BLUE+" ["+c.name()+"] "+ConsoleManager.RESET+
                    ConsoleManager.YELLOW+c.getMoneyName()+ConsoleManager.RESET);
            count++;
        }
        System.out.println(BaseMenuCreateManager.menuAyrac);
    }
    // Kullanıcıdan Döviz Birim Girişini İsteyeceğimiz Metot:
    String currencyInfo;
    JSONReader jsonReader = new JSONReader();
    void currencyInfoMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(ConsoleManager.RED+"-> Sorgulamak İstediğiniz Para Birimi: "+ConsoleManager.RESET);
        currencyInfo = scanner.nextLine();
        System.out.println(BaseMenuCreateManager.menuAyrac);
    }
    void currencyInfoBox(){
        if(currencyInfo.equalsIgnoreCase("USD") ||currencyInfo.equals("1") || currencyInfo.equalsIgnoreCase("Amerikan Doları")){
            System.out.println(ConsoleManager.BLUE+"< Amerikan Doları Bilgileri > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
            jsonReader.showMe("USD");
            System.out.println(BaseMenuCreateManager.menuAyrac);
        }
        else if(currencyInfo.equalsIgnoreCase("Eur") ||currencyInfo.equals("2") || currencyInfo.equalsIgnoreCase("Euro")){
            System.out.println(ConsoleManager.BLUE+"< Euro Bilgileri > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
            jsonReader.showMe("EUR");
            System.out.println(BaseMenuCreateManager.menuAyrac);
        }
        else if(currencyInfo.equalsIgnoreCase("GBP") ||currencyInfo.equals("3") || currencyInfo.equalsIgnoreCase("Sterlin")){
            System.out.println(ConsoleManager.BLUE+"< Sterlin Bilgileri > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
            jsonReader.showMe("GBP");
            System.out.println(BaseMenuCreateManager.menuAyrac);
        }
        else if(currencyInfo.equalsIgnoreCase("CHF") ||currencyInfo.equals("4") || currencyInfo.equalsIgnoreCase("İsviçre Frangı")){
            System.out.println(ConsoleManager.BLUE+"< İsviçre Frank Bilgileri > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
            jsonReader.showMe("CHF");
            System.out.println(BaseMenuCreateManager.menuAyrac);
        }
        else if(currencyInfo.equalsIgnoreCase("CAD") ||currencyInfo.equals("5") || currencyInfo.equalsIgnoreCase("Kanada Doları")){
            System.out.println(ConsoleManager.BLUE+"< Kanada Doları Bilgileri > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
            jsonReader.showMe("CAD");
            System.out.println(BaseMenuCreateManager.menuAyrac);
        }
        else if(currencyInfo.equalsIgnoreCase("RUB") ||currencyInfo.equals("6") || currencyInfo.equalsIgnoreCase("Rus Rublesi")){
            System.out.println(ConsoleManager.BLUE+"< Rus Rublesi Bilgileri > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
            jsonReader.showMe("RUB");
            System.out.println(BaseMenuCreateManager.menuAyrac);
        }
        else if(currencyInfo.equalsIgnoreCase("KWD") ||currencyInfo.equals("7") || currencyInfo.equalsIgnoreCase("Kuveyt Dinarı")){
            System.out.println(ConsoleManager.BLUE+"< Kuveyt Dinarı Bilgileri > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
            jsonReader.showMe("KWD");
            System.out.println(BaseMenuCreateManager.menuAyrac);
        }
        else {
            System.out.println(ConsoleManager.RED+"< Hatalı Giriş Yaptınız > \n"+ConsoleManager.RESET+BaseMenuCreateManager.menuAyrac);
        }
    }

}

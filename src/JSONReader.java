import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    static String dovizAlis = null;
    static String dovizSatis = null;
    static String degisimMiktari = null;
    static String jSONGuncelleme = null;


    public void showMe(String hangiVeri) {
        // JSON Tanımlaması :
        JSONParser jsonParser = new JSONParser();

        // Dosya Okuma:
        try {
            FileReader fileReader = new FileReader("C:/Users/winem/Desktop/Projeler/firstDovizKuru/src/main/java/dovizVeri.JSON");
            Object obje = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obje;
            jSONGuncelleme = (String) jsonObject.get("Update_Date");
            // JSON Tablosunu Array olarak açma işlemi:
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(jsonObject.get(hangiVeri));
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject currency = (JSONObject) jsonArray.get(i);
                dovizAlis = (String) currency.get("Buying");
                dovizSatis = (String) currency.get("Selling");
                degisimMiktari = (String) currency.get("Change");

            }
            System.out.println(ConsoleManager.GREEN + "-> JSON Güncelleme Zamanı: " + ConsoleManager.RESET + jSONGuncelleme); // JSON Güncelleme Zamanını Yazdırtırıyoruz.
            System.out.println(ConsoleManager.RED + "-> Alış Miktarı: " + ConsoleManager.RESET + dovizAlis +
                    ConsoleManager.CYAN + "\n-> Satış Miktarı: " + ConsoleManager.RESET + dovizSatis +
                    ConsoleManager.YELLOW + "\n-> Degişim Miktarı: " + ConsoleManager.RESET + degisimMiktari);

            // İşlemlerin Kapatılması:
            fileReader.close();
        } catch (IOException e) {
            System.out.println("IOException Hatası !\n" + e);
        } catch (ParseException e) {
            System.out.println("ParseException Hatası !\n" + e);
        }
    }
}

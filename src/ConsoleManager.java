public class ConsoleManager {
    // Konsol Renkli Yazı Yazmak İçin Gerekli Tanımlamalar:
    public static final String RESET = "\033[0m";  // Text Reset
    // [1;xxm" kısmındaki 1'i değiştirerek altı çizgili, normal gibi çeşitli değişiklikler yapabilirsiniz.
    public static final String BLACK = "\033[1;30m";   // Siyah
    public static final String RED = "\033[1;31m";     // Kırmızı
    public static final String GREEN = "\033[1;32m";   // Yeşil
    public static final String YELLOW = "\033[1;33m";  // Sarı
    public static final String BLUE = "\033[1;34m";    // Mavi
    public static final String PURPLE = "\033[1;35m";  // Mor
    public static final String CYAN = "\033[1;36m";    // Turkuaz
    public static final String WHITE = "\033[1;37m";   // Beyaz

    // Konsol Temizleyici Metot Tanımlamamız:
    static void clear() {
       /* try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch (Exception e){
            System.out.println("Konsol Temizlenirken Hata İle Karşılaştım.\n"+e);
        }*/ // Linux Kullanımında Açabilirsiniz.

        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
        BaseMenuCreateManager baseMenuCreateManager = new BaseMenuCreateManager();
        baseMenuCreateManager.welcome();
    }
}

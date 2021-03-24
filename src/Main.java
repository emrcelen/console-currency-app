public class Main {
    public static void main(String[] args) {
        JSONWrite jsonWrite = new JSONWrite();
        jsonWrite.alertTimer();
        BaseMenuCreateManager baseMenuCreateManager = new BaseMenuCreateManager();
        baseMenuCreateManager.welcome();
        baseMenuCreateManager.startMenu();
    }
}

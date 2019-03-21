import Model.MainModel;
import View.MainScreen;

public class Main {

    public static void main(String []args) {
        MainModel model = new MainModel();
        new MainScreen(model);
    }
}

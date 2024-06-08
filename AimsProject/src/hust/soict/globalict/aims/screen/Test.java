package hust.soict.globalict.test.screen.customer.store;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.customer.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestViewStoreScreen extends Application{
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/StoreView.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        CompactDisc cd = new CompactDisc(1, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(3, "Aladin", "Animation", "Guy Ritchie", 128, 25f);
        Book book1 = new Book(4, "Harry Potter", "novel", 20f);
        Book book2 = new Book(5, "The Alchemist", "self-help", 18.86f);

        store.addMedia(cd);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);

        launch(args);
    }
}
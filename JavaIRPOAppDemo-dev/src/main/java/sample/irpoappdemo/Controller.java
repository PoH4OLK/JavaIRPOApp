package sample.irpoappdemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.irpoappdemo.Calculate.calculating;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> LsMin;

    @FXML
    private ComboBox<String> CbEquation;

    @FXML
    private ListView<?> ListBxResult;

    @FXML
    private ProgressBar ProgBarResult;

    @FXML
    private TextField TxtT1;

    @FXML
    private TextField TxtT2;

    @FXML
    private TextField TxtDt;

    @FXML
    private TextField TxtZ;

    @FXML
    public  void onClickExit() {
        System.exit(0);
    }

    @FXML
    public void onClickResult() {
        String t1String = TxtT1.getText();
        String t2String = TxtT2.getText();
        String dtString = TxtDt.getText();
        String zString = TxtZ.getText();

        if(dtString.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение dt");
            error.showAndWait();
        }
        else if (t1String.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение t1");
            error.showAndWait();
        }
        else if (t2String.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение t2");
            error.showAndWait();
        }
        else if (zString.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение z");
            error.showAndWait();
        }
        else {
            int t1 = Integer.parseInt(t1String);
            int t2 = Integer.parseInt(t2String);
            int dt = Integer.parseInt(dtString);
            int z = Integer.parseInt(zString);

            calculating((float)t1, (float)t2, (float)dt, z,
                    ListBxResult, ProgBarResult, CbEquation);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] items = {"Первое уравнение", "Второе уравнение", "Третье уравнение", "Четвертое уравнение", "Пятое уравнение"};
        CbEquation.getItems().addAll(items);
    }
}
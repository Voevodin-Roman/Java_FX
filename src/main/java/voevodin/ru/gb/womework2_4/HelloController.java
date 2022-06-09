package voevodin.ru.gb.womework2_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ComboBox<String> mySmile;
    public TextField opponentAnswer;
    public ComboBox opponentSmile;
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField myAnswer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mySmile.getItems().setAll(":-)", "8-))", "$-)", ";-)", ":-*");
    }


    public void clickCheckButton(ActionEvent actionEvent) {
        final String answer = myAnswer.getText();
        final String smile = mySmile.getSelectionModel().getSelectedItem();
        String text;
        if (answer.isBlank()){
            return;
        }

        if (smile == "null"){
            text = String.format("Моё сообщение: \n %s", answer);
        }else {
            text = String.format("Моё сообщение: \n %s,  %s",  answer, smile );
        }
        historyArea.appendText(text + "\n");
        myAnswer.clear();
        myAnswer.requestFocus();
    }

    private boolean ifWwant() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Вы действительно хотите закрыть программу",
                new ButtonType("Ok", ButtonBar.ButtonData.YES),
                new ButtonType("No", ButtonBar.ButtonData.NO));
        alert.setTitle("Уже уходите?");
        ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;


    }

    public void clickNewChat() {
        historyArea.clear();
    }

    public void clickExit() {
        if (ifWwant()) {
            System.exit(0);
        }
    }



}
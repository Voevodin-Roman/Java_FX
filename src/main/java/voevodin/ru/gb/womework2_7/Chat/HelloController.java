package voevodin.ru.gb.womework2_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<String> mySmile;
    @FXML
    private TextField opponentAnswer;
    @FXML
    private ComboBox<String> opponentSmile;
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField myAnswer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mySmile.getItems().setAll(":-)", "8-))", "$-)", ";-)", ":-*");
    }


    public void myClickCheckButton(ActionEvent actionEvent) {
        final String answer = myAnswer.getText();
        final String smile = mySmile.getSelectionModel().getSelectedItem();
        if (answer.isBlank()){
            return;
        }
        String message = clickMessageOutput(answer, smile);
        historyArea.appendText( "Моё сообщение\n" + message + "\n");
        myAnswer.clear();
        myAnswer.requestFocus();

    }

    public void opponentClickCheckButton(ActionEvent actionEvent) {
        final String answer = opponentAnswer.getText();
        final String smile = (String) opponentSmile.getSelectionModel().getSelectedItem();
        if (answer.isBlank()){
            return;
        }
        historyArea.appendText("Сообщение собеседника\n" + clickMessageOutput(answer, smile) + "\n");
        opponentAnswer.clear();
        opponentAnswer.requestFocus();

    }

    private String clickMessageOutput(String answer, String smile){
        String text;
        if (smile == null){
            text = answer;
        }else {
            text = answer + "  " + smile;
        }
        return text;
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
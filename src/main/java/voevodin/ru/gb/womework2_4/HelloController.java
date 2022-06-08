package voevodin.ru.gb.womework2_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ComboBox<String> mySmile;
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField myAnswer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mySmile.getItems().setAll(":-)", "8-))", "$-)", ";-)", ":-*");
    }

    private Chat game;
    private int step;

    public HelloController() {
        this.game = new Chat();
    }





    public void clickCheckButton(ActionEvent actionEvent) {
        final String answer = myAnswer.getText();
        final String smile = mySmile.getSelectionModel().getSelectedItem();
        if (answer.isBlank()){
            return;
        }
        Chat.BulsAndCowsCount bulsAndCowsCount = game.calculateBullsAndCows(answer);
        String text = String.format("Моё сообщение: \n %s,  %s",  answer, smile );
        historyArea.appendText(text + "\n");
        myAnswer.clear();
        myAnswer.requestFocus();
        if (bulsAndCowsCount.getBulls() == 4){
            if (ifWwant()) {
                clickNewChat();
            }else {
                System.exit(0);
            }
        }
    }

    private boolean ifWwant() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Dssbuhsi\n" + "Number " + game.getQuessNum() + "add?",
                new ButtonType("Ok", ButtonBar.ButtonData.YES),
                new ButtonType("No", ButtonBar.ButtonData.NO));
        alert.setTitle("Уже уходите?");
        ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;


    }

    public void clickNewChat() {
        step = 0;
        historyArea.clear();
        this.game = new Chat();

    }

    public void clickExit() {
        System.exit(0);
    }



}
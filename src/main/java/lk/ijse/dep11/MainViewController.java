package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;

public class MainViewController {
    public Spinner<Integer> txtAmount;
    public Button btnDeposit;
    public Button btnWithdraw;
    public Button btnPrint;
    public Label lblBalance;
    public AnchorPane root;

    double accountBalance;

    public MainViewController() {
    }


    public void initialize() {
        btnDeposit.setDisable(true);
        btnWithdraw.setDisable(true);
        txtAmount.setEditable(true);

        txtAmount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100000,0,100));
        txtAmount.valueProperty().addListener(e->{
            btnDeposit.setDisable(txtAmount.getValue() <= 0 );
            btnWithdraw.setDisable(btnDeposit.isDisable());
        });
    }
    public void btnDepositOnAction(ActionEvent actionEvent) {
        accountBalance += txtAmount.getValue();
        lblBalance.setText(String.format("Balance : Rs. %,.2f",accountBalance));
        System.out.println(txtAmount.getValue() + " deposited successfully");
        txtAmount.getValueFactory().setValue(0);
    }

    public void btnWithdrawOnAction(ActionEvent actionEvent) {
        double balanceAfterWithdraw = accountBalance - txtAmount.getValue();
        if(balanceAfterWithdraw < 0){
            System.out.println("Insufficient account balance");
            return;
        }
        accountBalance = balanceAfterWithdraw;
        lblBalance.setText(String.format("Balance : Rs. %,.2f",accountBalance));
        System.out.println(txtAmount.getValue() + " Withdraw successfully");
        txtAmount.getValueFactory().setValue(0);
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
    }
}

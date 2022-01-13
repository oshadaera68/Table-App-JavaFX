/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import view.tm.CustomerTM;

import java.util.Optional;

public class TableViewFormController {
    public JFXTextField txtCusId;
    public JFXTextField txtCusName;
    public JFXTextField txtCusAddress;
    public JFXTextField txtSalary;
    public TextField txtSearch;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOption;
    public JFXButton btnSave;


    public void initialize() {
        loadAllCustomers();
        colId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("cusAddress"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("button"));

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });

    }

    private void setData(CustomerTM tm) {
        btnSave.setText("Update Customer");
        txtCusId.setText(tm.getCusId());
        txtCusName.setText(tm.getCusName());
        txtCusAddress.setText(tm.getCusAddress());
        txtSalary.setText(String.valueOf(tm.getSalary()));
    }

    private void loadAllCustomers() {
        ObservableList<CustomerTM> list = FXCollections.observableArrayList();
        for (Customer c : Database.customerTable) {
            Button button = new Button("Delete");
            CustomerTM customerTM = new CustomerTM(c.getId(), c.getName(), c.getAddress(), c.getSalary(), button);
            list.add(customerTM);

            button.setOnAction((e) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure the delete this data?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)) {
                    Database.customerTable.remove(c);
                    list.remove(customerTM);
                }
            });
        }
        tblCustomer.setItems(list);
    }

    public void newCustomerOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Customer");
        txtCusId.clear();
        txtCusName.clear();
        txtCusAddress.clear();
        txtSalary.clear();
    }

    public void saveCustomerOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Customer")){
            Customer customer = new Customer(
                    txtCusId.getText(), txtCusName.getText(), txtCusAddress.getText(), Double.parseDouble(txtSalary.getText())
            );
            Database.customerTable.add(customer);
            loadAllCustomers();
        }else{

        }
    }
}
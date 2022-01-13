/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package controller;

import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import view.tm.CustomerTM;

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


    public void initialize(){
        loadAllCustomers();
        colId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("cusName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("cusAddress"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("button"));
    }

    private void loadAllCustomers() {
        ObservableList<CustomerTM> list = FXCollections.observableArrayList();
        for (Customer c: Database.customerTable) {
            Button button = new Button("Delete");
            CustomerTM customerTM = new CustomerTM(c.getId(), c.getName(),c.getAddress(),c.getSalary(),button);
            list.add(customerTM);
        }
        tblCustomer.setItems(list);
    }

    public void newCustomerOnAction(ActionEvent actionEvent) {
    }
}

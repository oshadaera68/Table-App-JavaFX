/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package view.tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private double salary;
    private Button button;

    public CustomerTM() {
    }

    public CustomerTM(String cusId, String cusName, String cusAddress, double salary, Button button) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.salary = salary;
        this.button = button;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}

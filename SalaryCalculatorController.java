/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class SalaryCalculatorController implements Initializable {

    @FXML private RadioButton hourlyWage;
    @FXML private RadioButton yearlySalary;
    
    @FXML private TextField enter;
    @FXML private TextField result;
    
    public void hourlyButton(ActionEvent event) throws Exception {
        yearlySalary.setSelected(false);
        
        enter.setPromptText("Yearly Salary");
        enter.setDisable(false);
        enter.clear();
        result.clear();
        
    }
    
    public void yearlyButton(ActionEvent event) throws Exception {
        hourlyWage.setSelected(false);
        
        enter.setPromptText("Hourly Wage");
        enter.setDisable(false);
        enter.clear();
        result.clear();
        
    }
    
    public void calculateResult(ActionEvent event) throws Exception {
        
        if(!hourlyWage.isSelected() && !yearlySalary.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Select 'Hourly Wage' or 'Yearly Salary'");
            alert.showAndWait();
        }
        
        else {
            if(hourlyWage.isSelected()) {
                double salary = Double.parseDouble(enter.getText());
                
                int weeksInYear = 52;
                
                int standardWorkWeek = 40;
                
                double a = salary / weeksInYear;
               
                double b = a / standardWorkWeek;
                
                result.setText(Double.toString(b));
            }
            
            else if(yearlySalary.isSelected()) {
                double wage = Double.parseDouble(enter.getText());
                
                int standardWorkWeek = 40;
                int weeksInYear = 52;
                
                double a = wage * standardWorkWeek;
                double b = a * weeksInYear;
                
                result.setText(Double.toString(b));
            }
        }   
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

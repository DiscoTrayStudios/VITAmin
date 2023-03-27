package VITAmin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class HelloController {

    @FXML
    private BorderPane filterMenu;

    @FXML
    private BorderPane resultsView;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField clientID;

    @FXML
    private TextArea resultArea;

    @FXML
    private Button openFilter;

    @FXML
    private Button filterButton;

    @FXML
    private Button backToHomeButton;

    @FXML
    private TextField name;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField l4ss;

    @FXML
    private ChoiceBox taxYear;

    @FXML
    private TextField zip;

    @FXML
    private TextField state;

    @FXML
    private TextField federalReturn;

    @FXML
    private TextField totalRefund;

    @FXML
    private TextField eitc;

    @FXML
    private TextField ctc;

    @FXML
    private TableView resultsTable;

    @FXML
    private TableColumn<DataObject, String> clientIDColumn;

    @FXML
    private TableColumn<DataObject, String> firstNameColumn;

    @FXML
    private TableColumn<DataObject, String> lastNameColumn;

    @FXML
    private TableColumn<DataObject, String> doBColumn;

    @FXML
    private TableColumn<DataObject, String> last4ssColumn;

    @FXML
    private TableColumn<DataObject, Integer> taxYearColumn;

    @FXML
    private TableColumn<DataObject, String> zipColumn;


    @FXML
    private TableColumn<DataObject, String> stateColumn;

    @FXML
    private TableColumn<DataObject, Boolean> federalReturnColumn;

    @FXML
    private TableColumn<DataObject, Double> totalRefundColumn;

    @FXML
    private TableColumn<DataObject, Double> eitcColumn;

    @FXML
    private TableColumn<DataObject, Double> ctcColumn;

    @FXML
    private void initialize () throws SQLException, ClassNotFoundException {
        clientIDColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        doBColumn.setCellValueFactory(cellData -> cellData.getValue().doBProperty());
        last4ssColumn.setCellValueFactory(cellData -> cellData.getValue().l4SSNProperty());

        ObservableList<String> ty = FXCollections.observableArrayList();
        ObservableList<DataObject> taxYears = DataBase.searchTaxYears("");
        for(DataObject d : taxYears){
            ty.add(Integer.toString(d.getTaxYear()));
        }
        taxYear.setItems(ty);
    }

    public void switchToUpload(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UploadScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void searchClient(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{
        try{
            Client client = DataBase.searchClient(clientID.getText());
            populateAndShowClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting client information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void searchClients(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{
        try{
            String condition = "";
            boolean[] cols = {!name.getText().isEmpty(), dob.getValue() != null, !l4ss.getText().isEmpty()};
            int numCols = 0;
            for(boolean b : cols){
                if(b){numCols++;}
            }
            if(numCols > 0){
                condition += "WHERE ";
            }
            if(cols[0]){
                numCols--;
                String fn = name.getText().split("\\s+")[0];
                String ln = name.getText().split("\\s+")[1];
                condition += "FirstName = " + fn + " AND LastName = " + ln;
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[1]){
                numCols--;
                condition += "DoB = " + dob.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[2]){
                numCols--;
                condition += "Last4SS = " + l4ss.getText();
                //if(numCols > 0){condition += " AND ";}
            }
            ObservableList<DataObject> clientData = DataBase.searchClients(condition);
            populateClients(clientData);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting client information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void populateClient(Client client) throws ClassNotFoundException{
        ObservableList<Client> clientData = FXCollections.observableArrayList();
        clientData.add(client);
        System.out.println(clientData.size());
        resultsTable.setItems(clientData);
    }

    @FXML
    private void setClientInfoToTextArea(Client client){
        resultArea.setText("First Name: " + client.getFirstName() + "\n" + "Last Name: " + client.getLastName());
    }

    @FXML
    private void populateAndShowClient(Client client) throws ClassNotFoundException{
        if(client != null){
            populateClient(client);
            setClientInfoToTextArea(client);
        }else{
            resultArea.setText("This client does not exist!\n");
        }
    }

    @FXML
    private void populateData(ObservableList<DataObject> dataObjects) throws ClassNotFoundException{
        resultsTable.setItems(dataObjects);
    }

    @FXML
    private void populateClients(ObservableList<DataObject> clientData) throws ClassNotFoundException{
        resultsTable.setItems(clientData);
    }
    @FXML
    private void populateDemographics(ObservableList<Demographic> demographicData) throws ClassNotFoundException{
        resultsTable.setItems(demographicData);
    }
    @FXML
    private void populateReturnData(ObservableList<ReturnData> returnDataData)throws ClassNotFoundException{
        resultsTable.setItems(returnDataData);
    }
    @FXML
    private void populateYears(ObservableList<TaxYear> TaxYearData){
        resultsTable.setItems(TaxYearData);
    }

    @FXML
    private void openFilterMenu(){
        resultsView.setVisible(false);
        //resultsView.setDisable(true);
        filterMenu.setVisible(true);
        //filterMenu.setDisable(false);
        backToHomeButton.setVisible(false);
    }

    /**
     *The method run to filter the conditions on the filter screen; i.e. the filter button method
     * @param actionEvent
     * @throws ClassNotFoundException
     * @throws SQLException
     *
     */
    @FXML
    private void filter(ActionEvent actionEvent) throws ClassNotFoundException, SQLException{
        //hides the filter screen and shows the results screen
        resultsView.setVisible(true);
        filterMenu.setVisible(false);
        backToHomeButton.setVisible(true);
        try{
            //condition is the condition, if any, that will be used in the WHERE clause of the SQL statement
            String condition = "";

            //The cols array stores which boxes are checked; i.e. the columns that will be visible and the values that need to be checked
            boolean[] cols = {!name.isDisable(), !dob.isDisable(), !l4ss.isDisable(), !taxYear.isDisable(), !zip.isDisable(), !state.isDisable(), !federalReturn.isDisable(), !totalRefund.isDisable(), !eitc.isDisable(), !ctc.isDisable()};
            //The conds array stores which filters have values set that need to be included in the SQL condition
            boolean[] conds = {!name.getText().isEmpty(), dob.getValue() != null, !l4ss.getText().isEmpty(), taxYear.getValue() != null, !zip.getText().isEmpty(), !state.getText().isEmpty(), !federalReturn.getText().isEmpty(), !totalRefund.getText().isEmpty(), !eitc.getText().isEmpty(), !ctc.getText().isEmpty()};

            //The following section of code checks which tables need to be included in the SQL statement
            boolean clientFilter = false;
            boolean demographicFilter = false;
            boolean returnDataFilter = false;
            boolean taxYearFilter = false;
            //numCols variable keeps track of how many conditions will be in the SQL WHERE clause
            int numCols = 0;
            for(int i = 0; i < conds.length; i++){
                //if a filter is enabled and has a value, it will be included in the SQL condition
                if(cols[i] && conds[i]){numCols++;}
                //the first three items in the cols and conds arrays have to do with the client filter
                if(i < 3 && cols[i]){
                    clientFilter = true;
                }
                //the fourth item is tax year
                else if(i == 3 && cols[i]){
                    taxYearFilter = true;
                }
                //the fifth through seventh items are filters for the Demographic table
                else if(i > 3 && i < 8 && cols[i]){
                    demographicFilter = true;
                }
                //the rest of the items relate to the ReturnData table
                else if(i >= 8 && cols[i]){
                    returnDataFilter = true;
                }
            }

            //if there aren't any filters to check, there is no need for a WHERE clause in the SQL statement
            if(numCols > 0){
                condition += " WHERE ";
            }
            //if filter is enabled and has a value, the value is included in the condition
            if(cols[0] && conds[0]){
                //the numCols variable is decremented each time a condition is added
                numCols--;
                String fn = name.getText().split("\\s+")[0];
                String ln = name.getText().split("\\s+")[1];
                //the values of the filter are added to the condition
                condition += "FirstName = '" + fn + "' AND LastName = '" + ln + "'";
                //if there is a filter to add to the condition after this one, AND needs to be added to the condition
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[1] && conds[1]){
                numCols--;
                condition += "DoB = '" + dob.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "'";
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[2] && conds[2]){
                numCols--;
                condition += "Last4SS = '" + l4ss.getText() + "'";
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[3] && conds[3]){
                numCols--;
                if(demographicFilter){
                    condition += "Demographic.";
                }else if(returnDataFilter){
                    condition += "ReturnData.";
                }else if(clientFilter){
                    condition += "Demographic.";
                }
                condition += "TAXYEAR = " + taxYear.getValue().toString();
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[4] && conds[4]){
                numCols--;
                condition += "Zip = " + zip.getText();
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[5] && conds[5]){
                numCols--;
                condition += "State = '" + state.getText() + "'";
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[6] && conds[6]){
                numCols--;
                condition += "FEDERAL = " + federalReturn.getText();
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[7] && conds[7]){
                numCols--;
                condition += "REFUND = " + totalRefund.getText();
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[8] && conds[8]){
                numCols--;
                condition += "EIC = " + eitc.getText();
                if(numCols > 0){condition += " AND ";}
            }
            if(cols[9] && conds[9]){
                numCols--;
                condition += "CHILDTAXCREDIT = " + ctc.getText();
                if(numCols > 0){condition += " AND ";}
            }
            System.out.println(condition);

            //Different methods will be called for the different combinations of tables that need to be joined
            if(demographicFilter && returnDataFilter && clientFilter){
                ObservableList<DataObject> clientDemographicReturnDataData = DataBase.searchDemographicsAndReturnDataAndClients(condition);
                populateData(clientDemographicReturnDataData);
            }else if(demographicFilter && returnDataFilter){
                ObservableList<DataObject> demographicReturnDataData = DataBase.searchDemographicsAndReturnData(condition);
                populateData(demographicReturnDataData);
            }else if(demographicFilter && clientFilter){
                ObservableList<DataObject> demographicClientData = DataBase.searchDemographicsAndClients(condition);
                populateData(demographicClientData);
            }else if(demographicFilter){
                ObservableList<DataObject> demographicData = DataBase.searchDemographics(condition);
                populateData(demographicData);
            }else if(returnDataFilter && clientFilter){
                ObservableList<DataObject> returnDataClientData = DataBase.searchReturnDataAndClients(condition);
                populateData(returnDataClientData);
            }else if(returnDataFilter){
                ObservableList<DataObject> returnDataData = DataBase.searchReturnData(condition);
                populateData(returnDataData);
            }else if(taxYearFilter && clientFilter){
                ObservableList<DataObject> taxYearClientData = DataBase.searchDemographicsAndReturnDataAndClients(condition);
                populateData(taxYearClientData);
            }else if(taxYearFilter){
                ObservableList<DataObject> taxYearData = DataBase.searchTaxYears(condition);
                populateData(taxYearData);
            }else {
                ObservableList<DataObject> clientData = DataBase.searchClients(condition);
                populateClients(clientData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting client information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void export(){
        try {
            String home = System.getProperty("user.home");
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            String timestamp = formatter.format(ts);
            String filename = home + "\\Downloads\\data_export" + timestamp + ".csv";
            File file = new File(filename);
            FileWriter fw = new FileWriter(file);
            String data = "";
            ObservableList<TableColumn> columns = resultsTable.getColumns();
            for (int i = 0; i < columns.size(); i++) {
                if (columns.get(i).isVisible()) {
                    data += columns.get(i).getText() + ",";

                }
            }
            data = data.substring(0, data.length() - 1);
            data += "\n";
            for (Object row : resultsTable.getItems()) {
                for (int i = 0; i < columns.size(); i++) {
                    if (columns.get(i).getCellObservableValue(row) != null) {
                        data += columns.get(i).getCellObservableValue(row).getValue().toString() + ",";
                        System.out.println(columns.get(i).getCellObservableValue(row).getValue().toString());
                    }
                }
                data = data.substring(0, data.length() - 1);
                data += "\n";
            }
            fw.write(data);
            fw.close();
        }catch(IOException e){
            System.out.println("error!");
            e.printStackTrace();
        }
    }

    //The following "BoxAction" methods are the methods ran when one of the checkboxes is clicked in the filter screen
    @FXML
    private void nameBoxAction(){
        name.setDisable(!name.isDisable());
        firstNameColumn.setVisible(!firstNameColumn.isVisible());
        lastNameColumn.setVisible(!lastNameColumn.isVisible());
        if(firstNameColumn.isVisible()){
            firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
            lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        }else{
            firstNameColumn.setCellValueFactory(null);
            lastNameColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void dobBoxAction(){
        dob.setDisable(!dob.isDisable());
        doBColumn.setVisible(!doBColumn.isVisible());
        if(doBColumn.isVisible()){
            doBColumn.setCellValueFactory(cellData -> cellData.getValue().doBProperty());
        }else{
            doBColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void l4ssBoxAction(){
        l4ss.setDisable(!l4ss.isDisable());
        last4ssColumn.setVisible(!last4ssColumn.isVisible());
        if(last4ssColumn.isVisible()){
            last4ssColumn.setCellValueFactory(cellData -> cellData.getValue().l4SSNProperty());
        }else{
            last4ssColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void taxYearBoxAction(){
        taxYear.setDisable(!taxYear.isDisable());
        taxYearColumn.setVisible(!taxYearColumn.isVisible());
        if(taxYearColumn.isVisible()) {
            taxYearColumn.setCellValueFactory(cellData -> cellData.getValue().taxYearProperty().asObject());
        }else{
            taxYearColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void zipBoxAction(){
        zip.setDisable(!zip.isDisable());
        zipColumn.setVisible(!zipColumn.isVisible());
        if(zipColumn.isVisible()){
            zipColumn.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
        }else{
            zipColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void stateBoxAction(){
        state.setDisable(!state.isDisable());
        stateColumn.setVisible(!stateColumn.isVisible());
        if(stateColumn.isVisible()){
            stateColumn.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        }else{
            stateColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void federalReturnBoxAction(){
        federalReturn.setDisable(!federalReturn.isDisable());
        federalReturnColumn.setVisible(!federalReturnColumn.isVisible());
        if(federalReturnColumn.isVisible()){
            federalReturnColumn.setCellValueFactory(cellData -> cellData.getValue().federalProperty());
        }else{
            federalReturnColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void totalRefundBoxAction(){
        totalRefund.setDisable(!totalRefund.isDisable());
        totalRefundColumn.setVisible(!totalRefundColumn.isVisible());
        if(totalRefundColumn.isVisible()){
            totalRefundColumn.setCellValueFactory(cellData-> cellData.getValue().refundProperty().asObject());
        }else{
            totalRefundColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void eitcBoxAction(){
        eitc.setDisable(!eitc.isDisable());
        eitcColumn.setVisible(!eitcColumn.isVisible());
        if(eitcColumn.isVisible()){
            eitcColumn.setCellValueFactory(cellData -> cellData.getValue().eicProperty().asObject());
        }else{
            eitcColumn.setCellValueFactory(null);
        }
    }
    @FXML
    private void ctcBoxAction(){
        ctc.setDisable(!ctc.isDisable());
        ctcColumn.setVisible(!ctcColumn.isVisible());
        if(ctcColumn.isVisible()){
            ctcColumn.setCellValueFactory(cellData -> cellData.getValue().childTaxCreditProperty().asObject());
        }else{
            ctcColumn.setCellValueFactory(null);
        }
    }

}
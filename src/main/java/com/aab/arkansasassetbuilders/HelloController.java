package com.aab.arkansasassetbuilders;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class HelloController {

    @FXML
    private BorderPane filterMenu;

    @FXML
    private BorderPane resultsView;

    @FXML
    private Button openFilter;

    @FXML
    private Button filterButton;

    @FXML
    private Button backToHomeButton;

    @FXML
    private TextField id;

    @FXML
    private ChoiceBox taxYear;

    @FXML
    private ChoiceBox taxYear2;

    @FXML
    private CheckBox federal;

    @FXML
    private TextField sidn;

    @FXML
    private TextField l4SSN;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private DatePicker doB;

    @FXML
    private DatePicker doB2;

    @FXML
    private TextField city;

    @FXML
    private TextField state;

    @FXML
    private TextField zip;

    @FXML
    private DatePicker acceptedDate;

    @FXML
    private DatePicker acceptedDate2;

    @FXML
    private TextField returnType;

    @FXML
    private TextField filingStatus;

    @FXML
    private TextField totalIrsExemptions;

    @FXML
    private TextField refund;

    @FXML
    private HBox refundBox;

    @FXML
    private TextField totalRefunds;

    @FXML
    private CheckBox paperState;

    @FXML
    private CheckBox paperFed;

    @FXML
    private CheckBox requestingDd;

    @FXML
    private TextField primarySecondary60Plus;

    @FXML
    private TextField agi;

    @FXML
    private DatePicker createdDate;

    @FXML
    private DatePicker createdDate2;

    @FXML
    private TextField addctc;

    @FXML
    private TextField poundSavingsBonds;

    @FXML
    private TextField savingsBonds;

    @FXML
    private TextField eic;

    @FXML
    private TextField childTaxCredit;

    @FXML
    private TextField educationTaxCredit;

    @FXML
    private TextField elderlyCredit;

    @FXML
    private TextField totalRespPayment;

    @FXML
    private TextField totalAdvptcRepayment;

    @FXML
    private TextField averageAdvptcPayment;

    @FXML
    private TextField totalPtc;

    @FXML
    private TextField balanceDue;

    @FXML
    private CheckBox itin;

    @FXML
    private CheckBox exemption7;

    @FXML
    private CheckBox fullYearCoverage;

    @FXML
    private CheckBox form8888;

    @FXML
    private CheckBox scheduleA;

    @FXML
    private CheckBox scheduleB;

    @FXML
    private CheckBox scheduleC;

    @FXML
    private CheckBox scheduleCEz;

    @FXML
    private CheckBox scheduleD;

    @FXML
    private CheckBox scheduleE;

    @FXML
    private CheckBox scheduleF;

    @FXML
    private CheckBox scheduleH;

    @FXML
    private CheckBox scheduleR;

    @FXML
    private CheckBox scheduleSetP;

    @FXML
    private CheckBox scheduleSesP;

    @FXML
    private TextField agencyId;

    @FXML
    private TextField residency;

    @FXML
    private TextField stateWithholding;

    @FXML
    private TextField stateTaxLiability;

    @FXML
    private TextField efin;

    @FXML
    private TextField aAmountTaxpayerIsPlanningToSave;

    @FXML
    private CheckBox consentToDiscloseTaxReturn;

    @FXML
    private CheckBox consentToDiscloseTaxpayerD;

    @FXML
    private CheckBox consentToUseTaxpayerData;

    @FXML
    private CheckBox consentToDiscloseTaxReturn1;

    @FXML
    private CheckBox consentToDiscloseTaxReturn2;

    @FXML
    private CheckBox consentToDiscloseTaxReturn3;

    @FXML
    private CheckBox consentToDiscloseTaxReturn4;

    @FXML
    private TextField questions1;

    @FXML
    private TextField questions2;

    @FXML
    private TextField questions3;

    @FXML
    private TextField questions4;

    @FXML
    private TextField questions5;

    @FXML
    private TextField questions6;

    @FXML
    private TextField questions7;

    @FXML
    private TextField questions8;

    @FXML
    private TextField questions9;

    @FXML
    private TextField questionA;

    @FXML
    private TextField questionB;

    @FXML
    private TextField questionC;

    @FXML
    private TextField questionD;

    @FXML
    private TextField questionE;

    @FXML
    private TextField questionF;

    @FXML
    private TextField questionG;

    @FXML
    private TextField questionH;

    @FXML
    private TextField questionI;

    @FXML
    private TextField questionJ;

    @FXML
    private TextField questionK;

    @FXML
    private TextField persons5AndUnder;

    @FXML
    private TextField personsAge6To18;

    @FXML
    private TextField personsAge65Plus;

    @FXML
    private TableView resultsTable;

    @FXML
    private TableColumn<DataObject, String> idColumn;

    @FXML
    private TableColumn<DataObject, Integer> taxYearColumn;

    @FXML
    private TableColumn<DataObject, Boolean> federalColumn;

    @FXML
    private TableColumn<DataObject, String> sidnColumn;

    @FXML
    private TableColumn<DataObject, String> l4SSNColumn;

    @FXML
    private TableColumn<DataObject, String> firstNameColumn;

    @FXML
    private TableColumn<DataObject, String> lastNameColumn;

    @FXML
    private TableColumn<DataObject, String> doBColumn;

    @FXML
    private TableColumn<DataObject, String> cityColumn;

    @FXML
    private TableColumn<DataObject, String> stateColumn;

    @FXML
    private TableColumn<DataObject, String> zipColumn;

    @FXML
    private TableColumn<DataObject, String> acceptedDateColumn;

    @FXML
    private TableColumn<DataObject, String> returnTypeColumn;

    @FXML
    private TableColumn<DataObject, String> filingStatusColumn;

    @FXML
    private TableColumn<DataObject, Double> totalIrsExemptionsColumn;

    @FXML
    private TableColumn<DataObject, Double> refundColumn;

    @FXML
    private TableColumn<DataObject, Boolean> paperStateColumn;

    @FXML
    private TableColumn<DataObject, Boolean> paperFedColumn;

    @FXML
    private TableColumn<DataObject, Boolean> requestingDdColumn;

    @FXML
    private TableColumn<DataObject, Double> primarySecondary60PlusColumn;

    @FXML
    private TableColumn<DataObject, Double> agiColumn;

    @FXML
    private TableColumn<DataObject, String> createdDateColumn;

    @FXML
    private TableColumn<DataObject, Double> addctcColumn;

    @FXML
    private TableColumn<DataObject, String> poundSavingsBondsColumn;

    @FXML
    private TableColumn<DataObject, String> savingsBondsColumn;

    @FXML
    private TableColumn<DataObject, Double> eicColumn;

    @FXML
    private TableColumn<DataObject, Double> childTaxCreditColumn;

    @FXML
    private TableColumn<DataObject, Double> educationTaxCreditColumn;

    @FXML
    private TableColumn<DataObject, Double> elderlyCreditColumn;

    @FXML
    private TableColumn<DataObject, Double> totalRespPaymentColumn;

    @FXML
    private TableColumn<DataObject, Double> totalAdvptcRepaymentColumn;

    @FXML
    private TableColumn<DataObject, Double> averageAdvptcPaymentColumn;

    @FXML
    private TableColumn<DataObject, Double> totalPtcColumn;

    @FXML
    private TableColumn<DataObject, Double> balanceDueColumn;

    @FXML
    private TableColumn<DataObject, Boolean> itinColumn;

    @FXML
    private TableColumn<DataObject, Boolean> exemption7Column;

    @FXML
    private TableColumn<DataObject, Boolean> fullYearCoverageColumn;

    @FXML
    private TableColumn<DataObject, Boolean> form8888Column;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleAColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleBColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleCColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleCEzColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleDColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleEColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleFColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleHColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleRColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleSetPColumn;

    @FXML
    private TableColumn<DataObject, Boolean> scheduleSesPColumn;

    @FXML
    private TableColumn<DataObject, String> agencyIdColumn;

    @FXML
    private TableColumn<DataObject, String> residencyColumn;

    @FXML
    private TableColumn<DataObject, Double> stateWithholdingColumn;

    @FXML
    private TableColumn<DataObject, Double> stateTaxLiabilityColumn;

    @FXML
    private TableColumn<DataObject, String> efinColumn;

    @FXML
    private TableColumn<DataObject, Double> aAmountTaxpayerIsPlanningToSaveColumn;

    @FXML
    private TableColumn<DataObject, Boolean> consentToDiscloseTaxReturnColumn;

    @FXML
    private TableColumn<DataObject, Boolean> consentToDiscloseTaxpayerDColumn;

    @FXML
    private TableColumn<DataObject, Boolean> consentToUseTaxpayerDataColumn;

    @FXML
    private TableColumn<DataObject, Boolean> consentToDiscloseTaxReturn1Column;

    @FXML
    private TableColumn<DataObject, Boolean> consentToDiscloseTaxReturn2Column;

    @FXML
    private TableColumn<DataObject, Boolean> consentToDiscloseTaxReturn3Column;

    @FXML
    private TableColumn<DataObject, Boolean> consentToDiscloseTaxReturn4Column;

    @FXML
    private TableColumn<DataObject, String> questions1Column;

    @FXML
    private TableColumn<DataObject, String> questions2Column;

    @FXML
    private TableColumn<DataObject, String> questions3Column;

    @FXML
    private TableColumn<DataObject, String> questions4Column;

    @FXML
    private TableColumn<DataObject, String> questions5Column;

    @FXML
    private TableColumn<DataObject, String> questions6Column;

    @FXML
    private TableColumn<DataObject, String> questions7Column;

    @FXML
    private TableColumn<DataObject, String> questions8Column;

    @FXML
    private TableColumn<DataObject, String> questions9Column;

    @FXML
    private TableColumn<DataObject, String> questionAColumn;

    @FXML
    private TableColumn<DataObject, String> questionBColumn;

    @FXML
    private TableColumn<DataObject, String> questionCColumn;

    @FXML
    private TableColumn<DataObject, String> questionDColumn;

    @FXML
    private TableColumn<DataObject, String> questionEColumn;

    @FXML
    private TableColumn<DataObject, String> questionFColumn;

    @FXML
    private TableColumn<DataObject, String> questionGColumn;

    @FXML
    private TableColumn<DataObject, String> questionHColumn;

    @FXML
    private TableColumn<DataObject, String> questionIColumn;

    @FXML
    private TableColumn<DataObject, String> questionJColumn;

    @FXML
    private TableColumn<DataObject, String> questionKColumn;

    @FXML
    private TableColumn<DataObject, Double> persons5AndUnderColumn;

    @FXML
    private TableColumn<DataObject, Double> personsAge6To18Column;

    @FXML
    private TableColumn<DataObject, Double> personsAge65PlusColumn;

    @FXML
    private VBox filterBox;

    @FXML
    private TextField totalRecords;

    private HashMap<String, String> columnMap;

    @FXML
    private void initialize () throws SQLException, ClassNotFoundException {
        openFilterMenu();
        totalRecords.setEditable(false);
        DataBase.initializeDB();
        ObservableList<String> ty = FXCollections.observableArrayList();
        ArrayList<String>included = new ArrayList<>();
        included.add("TAXYEAR");
        ObservableList<DataObject> taxYears = DataBase.search("",included);
        for(DataObject d : taxYears){
            ty.add(Integer.toString(d.getTaxYear()));
        }
        taxYear.setItems(ty);
        taxYear2.setItems(ty);

        parseExceptionHelper(doB);

        columnMap = new HashMap<>();
        columnMap.put("id","CLIENT");
        columnMap.put("taxYear","TAXYEAR");
        columnMap.put("federal","RETURNDATA");
        columnMap.put("sidn","CLIENT");
        columnMap.put("l4SSN","CLIENT");
        columnMap.put("firstName","CLIENT");
        columnMap.put("lastName","CLIENT");
        columnMap.put("doB","CLIENT");
        columnMap.put("city","DEMOGRAPHIC");
        columnMap.put("state","DEMOGRAPHIC");
        columnMap.put("zip","DEMOGRAPHIC");
        columnMap.put("acceptedDate","RETURNDATA");
        columnMap.put("returnType","RETURNDATA");
        columnMap.put("filingStatus","RETURNDATA");
        columnMap.put("totalIrsExemptions","RETURNDATA");
        columnMap.put("refund","RETURNDATA");
        columnMap.put("paperState","RETURNDATA");
        columnMap.put("paperFed","RETURNDATA");
        columnMap.put("requestingDd","RETURNDATA");
        columnMap.put("primarySecondary60Plus","DEMOGRAPHIC");
        columnMap.put("agi","RETURNDATA");
        columnMap.put("createdDate","RETURNDATA");
        columnMap.put("addctc","RETURNDATA");
        columnMap.put("poundSavingsBonds","RETURNDATA");
        columnMap.put("savingsBonds","RETURNDATA");
        columnMap.put("eic","RETURNDATA");
        columnMap.put("childTaxCredit","RETURNDATA");
        columnMap.put("educationTaxCredit","RETURNDATA");
        columnMap.put("elderlyCredit","RETURNDATA");
        columnMap.put("totalRespPayment","RETURNDATA");
        columnMap.put("totalAdvptcRepayment","RETURNDATA");
        columnMap.put("averageAdvptcPayment","RETURNDATA");
        columnMap.put("totalPtc","RETURNDATA");
        columnMap.put("balanceDue","RETURNDATA");
        columnMap.put("itin","RETURNDATA");
        columnMap.put("exemption7","RETURNDATA");
        columnMap.put("fullYearCoverage","RETURNDATA");
        columnMap.put("form8888","RETURNDATA");
        columnMap.put("scheduleA","RETURNDATA");
        columnMap.put("scheduleB","RETURNDATA");
        columnMap.put("scheduleC","RETURNDATA");
        columnMap.put("scheduleCEz","RETURNDATA");
        columnMap.put("scheduleD","RETURNDATA");
        columnMap.put("scheduleE","RETURNDATA");
        columnMap.put("scheduleF","RETURNDATA");
        columnMap.put("scheduleH","RETURNDATA");
        columnMap.put("scheduleR","RETURNDATA");
        columnMap.put("scheduleSetP","RETURNDATA");
        columnMap.put("scheduleSesP","RETURNDATA");
        columnMap.put("agencyId","RETURNDATA");
        columnMap.put("residency","DEMOGRAPHIC");
        columnMap.put("stateWithholding","RETURNDATA");
        columnMap.put("stateTaxLiability","RETURNDATA");
        columnMap.put("efin","CLIENT");
        columnMap.put("aAmountTaxpayerIsPlanningToSave","RETURNDATA");
        columnMap.put("consentToDiscloseTaxReturn","QUESTION");
        columnMap.put("consentToDiscloseTaxpayerD","QUESTION");
        columnMap.put("consentToUseTaxpayerData","QUESTION");
        columnMap.put("consentToDiscloseTaxReturn1","QUESTION");
        columnMap.put("consentToDiscloseTaxReturn2","QUESTION");
        columnMap.put("consentToDiscloseTaxReturn3","QUESTION");
        columnMap.put("consentToDiscloseTaxReturn4","QUESTION");
        columnMap.put("questions1","QUESTION");
        columnMap.put("questions2","QUESTION");
        columnMap.put("questions3","QUESTION");
        columnMap.put("questions4","QUESTION");
        columnMap.put("questions5","QUESTION");
        columnMap.put("questions6","QUESTION");
        columnMap.put("questions7","QUESTION");
        columnMap.put("questions8","QUESTION");
        columnMap.put("questions9","QUESTION");
        columnMap.put("questionA","QUESTION");
        columnMap.put("questionB","QUESTION");
        columnMap.put("questionC","QUESTION");
        columnMap.put("questionD","QUESTION");
        columnMap.put("questionE","QUESTION");
        columnMap.put("questionF","QUESTION");
        columnMap.put("questionG","QUESTION");
        columnMap.put("questionH","QUESTION");
        columnMap.put("questionI","QUESTION");
        columnMap.put("questionJ","QUESTION");
        columnMap.put("questionK","QUESTION");
        columnMap.put("persons5AndUnder","QUESTION");
        columnMap.put("personsAge6To18","QUESTION");
        columnMap.put("personsAge65Plus","QUESTION");


    }

    public void switchToUpload(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UploadScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }


    @FXML
    private void populateData(ObservableList<DataObject> dataObjects) throws ClassNotFoundException{
        resultsTable.setItems(dataObjects);
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
        try {
            HashMap<String, Boolean> inQuery = new HashMap<>();
            inQuery.put("QUESTION", false);
            inQuery.put("TAXYEAR", false);
            inQuery.put("RETURNDATA", false);
            inQuery.put("DEMOGRAPHIC", false);
            inQuery.put("CLIENT", false);

            ArrayList<String> conditions = new ArrayList<>();
            ArrayList<String> includedColumns = new ArrayList<>();

            for (Node h : filterBox.getChildren()) {
                HBox H = (HBox) h;
                Node c = H.getChildren().get(0);
                if (c.getId() != null && !c.isDisable()) {
                    inQuery.replace(columnMap.get(c.getId()), true);
                    includedColumns.add(columnMap.get(c.getId()) + "." + c.getId());
                    addCondition(c, conditions);
                }

            }

            //List of included tables
            //CLIENT and TAXYEAR must be last in list, so we add them first, add the rest of the tables, and then reverse the list
            ArrayList<String> include = new ArrayList<>();
            if (inQuery.get("TAXYEAR")) {
                include.add("TAXYEAR");
            }
            if (inQuery.get("CLIENT")) {
                include.add("CLIENT");
            }
            for (String s : inQuery.keySet()) {
                if (inQuery.get(s) && !s.equals("TAXYEAR") && !s.equals("CLIENT")) {
                    include.add(s);
                }
            }
            ArrayList<String> included = new ArrayList<>();
            for (int i = include.size() - 1; i >= 0; i--) {
                included.add(include.get(i));
            }
            if (included.size() == 2 && included.contains("CLIENT") && included.contains("TAXYEAR")) {
                included = new ArrayList<>(inQuery.keySet());
            }

            String condition = conditions.size() > 0 ? "WHERE " + String.join(" AND ", conditions) : "";
            if(included.size() == 0){
                included.add("RETURNDATA");
            }
            ObservableList<DataObject> data = DataBase.search(condition, included);
            populateData(data);

            totalRecords.setText(Integer.toString(data.size()));
            if(refundColumn.getCellObservableValue(0) != null) {
                double sum = 0;
                for (int i = 0; i < resultsTable.getItems().size(); i++) {
                    sum += refundColumn.getCellData(i);
                }
                totalRefunds.setText(Double.toString(sum));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void addCondition(Node node, ArrayList<String> conditions) {

        String name = columnMap.get(node.getId()) + "." + node.getId();
        if (node instanceof TextField && !((TextField) node).getText().isEmpty()) {
            conditions.add(name + " = '" + ((TextField) node).getText().strip() + "' ");
        } else if (node instanceof DatePicker && !(((DatePicker) node).getValue() == null)) {
            Node end = node.getParent().getChildrenUnmodifiable().get(2);
            conditions.add("substr(" + name + ",7,4)||'-'||substr(" + name + ",1,2)||'-'||substr(" + name + ",4,2)" + " BETWEEN '" + ((DatePicker) node).getValue() + "'" + " AND '" + ((DatePicker) end).getValue() + "' ");
        } else if (node instanceof ChoiceBox && !(((ChoiceBox) node).getValue() == null)) {
            Node end = node.getParent().getChildrenUnmodifiable().get(2);
            conditions.add(name + " BETWEEN " + ((ChoiceBox) node).getValue() + " AND " + ((ChoiceBox) end).getValue());
        } else if (node instanceof CheckBox) {
            conditions.add(name + " = " + (((CheckBox) node).isSelected() ? "TRUE" : "FALSE"));
        }

    }

    private void parseExceptionHelper(DatePicker datePicker){
        final StringConverter<LocalDate> defaultConverter = datePicker.getConverter();
        datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override public String toString(LocalDate value) {
                return defaultConverter.toString(value);
            }

            @Override public LocalDate fromString(String text) {
                try {
                    return defaultConverter.fromString(text);
                } catch (DateTimeParseException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid date range!");
                    alert.initOwner(datePicker.getScene().getWindow());
                    alert.showAndWait();
                    datePicker.setValue(null);
                    datePicker.getEditor().clear();
                    throw ex;
                }
            }
        });
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
    private void idBoxAction(){
        id.setDisable(!id.isDisable());
        idColumn.setVisible(!idColumn.isVisible());
        if(idColumn.isVisible()){
            idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        }else{
            idColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void taxYearBoxAction(){
        taxYear.setDisable(!taxYear.isDisable());
        taxYear2.setDisable(!taxYear2.isDisable());
        taxYearColumn.setVisible(!taxYearColumn.isVisible());
        if(taxYearColumn.isVisible()){
            taxYearColumn.setCellValueFactory(cellData -> cellData.getValue().taxYearProperty().asObject());
        }else{
            taxYearColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void federalBoxAction(){
        federal.setDisable(!federal.isDisable());
        federalColumn.setVisible(!federalColumn.isVisible());
        if(federalColumn.isVisible()){
            federalColumn.setCellValueFactory(cellData -> cellData.getValue().federalProperty().asObject());
        }else{
            federalColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void sidnBoxAction(){
        sidn.setDisable(!sidn.isDisable());
        sidnColumn.setVisible(!sidnColumn.isVisible());
        if(sidnColumn.isVisible()){
            sidnColumn.setCellValueFactory(cellData -> cellData.getValue().sidnProperty());
        }else{
            sidnColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void l4SSNBoxAction(){
        l4SSN.setDisable(!l4SSN.isDisable());
        l4SSNColumn.setVisible(!l4SSNColumn.isVisible());
        if(l4SSNColumn.isVisible()){
            l4SSNColumn.setCellValueFactory(cellData -> cellData.getValue().l4SSNProperty());
        }else{
            l4SSNColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void firstNameBoxAction(){
        firstName.setDisable(!firstName.isDisable());
        firstNameColumn.setVisible(!firstNameColumn.isVisible());
        if(firstNameColumn.isVisible()){
            firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        }else{
            firstNameColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void lastNameBoxAction(){
        lastName.setDisable(!lastName.isDisable());
        lastNameColumn.setVisible(!lastNameColumn.isVisible());
        if(lastNameColumn.isVisible()){
            lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        }else{
            lastNameColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void doBBoxAction(){
        doB.setDisable(!doB.isDisable());
        doB2.setDisable(!doB2.isDisable());
        doBColumn.setVisible(!doBColumn.isVisible());
        if(doBColumn.isVisible()){
            doBColumn.setCellValueFactory(cellData -> cellData.getValue().doBProperty());
        }else{
            doBColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void cityBoxAction(){
        city.setDisable(!city.isDisable());
        cityColumn.setVisible(!cityColumn.isVisible());
        if(cityColumn.isVisible()){
            cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        }else{
            cityColumn.setCellValueFactory(null);
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
    private void acceptedDateBoxAction(){
        acceptedDate.setDisable(!acceptedDate.isDisable());
        acceptedDate2.setDisable(!acceptedDate2.isDisable());
        acceptedDateColumn.setVisible(!acceptedDateColumn.isVisible());
        if(acceptedDateColumn.isVisible()){
            acceptedDateColumn.setCellValueFactory(cellData -> cellData.getValue().acceptedDateProperty());
        }else{
            acceptedDateColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void returnTypeBoxAction(){
        returnType.setDisable(!returnType.isDisable());
        returnTypeColumn.setVisible(!returnTypeColumn.isVisible());
        if(returnTypeColumn.isVisible()){
            returnTypeColumn.setCellValueFactory(cellData -> cellData.getValue().returnTypeProperty());
        }else{
            returnTypeColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void filingStatusBoxAction(){
        filingStatus.setDisable(!filingStatus.isDisable());
        filingStatusColumn.setVisible(!filingStatusColumn.isVisible());
        if(filingStatusColumn.isVisible()){
            filingStatusColumn.setCellValueFactory(cellData -> cellData.getValue().filingStatusProperty());
        }else{
            filingStatusColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void totalIrsExemptionsBoxAction(){
        totalIrsExemptions.setDisable(!totalIrsExemptions.isDisable());
        totalIrsExemptionsColumn.setVisible(!totalIrsExemptionsColumn.isVisible());
        if(totalIrsExemptionsColumn.isVisible()){
            totalIrsExemptionsColumn.setCellValueFactory(cellData -> cellData.getValue().totalIrsExemptionsProperty().asObject());
        }else{
            totalIrsExemptionsColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void refundBoxAction(){
        refund.setDisable(!refund.isDisable());
        refundBox.setVisible(!refundBox.isVisible());
        refundColumn.setVisible(!refundColumn.isVisible());
        if(refundColumn.isVisible()){
            refundColumn.setCellValueFactory(cellData -> cellData.getValue().refundProperty().asObject());
        }else{
            refundColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void paperStateBoxAction(){
        paperState.setDisable(!paperState.isDisable());
        paperStateColumn.setVisible(!paperStateColumn.isVisible());
        if(paperStateColumn.isVisible()){
            paperStateColumn.setCellValueFactory(cellData -> cellData.getValue().paperStateProperty().asObject());
        }else{
            paperStateColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void paperFedBoxAction(){
        paperFed.setDisable(!paperFed.isDisable());
        paperFedColumn.setVisible(!paperFedColumn.isVisible());
        if(paperFedColumn.isVisible()){
            paperFedColumn.setCellValueFactory(cellData -> cellData.getValue().paperFedProperty().asObject());
        }else{
            paperFedColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void requestingDdBoxAction(){
        requestingDd.setDisable(!requestingDd.isDisable());
        requestingDdColumn.setVisible(!requestingDdColumn.isVisible());
        if(requestingDdColumn.isVisible()){
            requestingDdColumn.setCellValueFactory(cellData -> cellData.getValue().requestingDdProperty().asObject());
        }else{
            requestingDdColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void primarySecondary60PlusBoxAction(){
        primarySecondary60Plus.setDisable(!primarySecondary60Plus.isDisable());
        primarySecondary60PlusColumn.setVisible(!primarySecondary60PlusColumn.isVisible());
        if(primarySecondary60PlusColumn.isVisible()){
            primarySecondary60PlusColumn.setCellValueFactory(cellData -> cellData.getValue().primarySecondary60PlusProperty().asObject());
        }else{
            primarySecondary60PlusColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void agiBoxAction(){
        agi.setDisable(!agi.isDisable());
        agiColumn.setVisible(!agiColumn.isVisible());
        if(agiColumn.isVisible()){
            agiColumn.setCellValueFactory(cellData -> cellData.getValue().agiProperty().asObject());
        }else{
            agiColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void createdDateBoxAction(){
        createdDate.setDisable(!createdDate.isDisable());
        createdDate2.setDisable(!createdDate2.isDisable());
        createdDateColumn.setVisible(!createdDateColumn.isVisible());
        if(createdDateColumn.isVisible()){
            createdDateColumn.setCellValueFactory(cellData -> cellData.getValue().createdDateProperty());
        }else{
            createdDateColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void addctcBoxAction(){
        addctc.setDisable(!addctc.isDisable());
        addctcColumn.setVisible(!addctcColumn.isVisible());
        if(addctcColumn.isVisible()){
            addctcColumn.setCellValueFactory(cellData -> cellData.getValue().addctcProperty().asObject());
        }else{
            addctcColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void poundSavingsBondsBoxAction(){
        poundSavingsBonds.setDisable(!poundSavingsBonds.isDisable());
        poundSavingsBondsColumn.setVisible(!poundSavingsBondsColumn.isVisible());
        if(poundSavingsBondsColumn.isVisible()){
            poundSavingsBondsColumn.setCellValueFactory(cellData -> cellData.getValue().poundSavingsBondsProperty());
        }else{
            poundSavingsBondsColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void savingsBondsBoxAction(){
        savingsBonds.setDisable(!savingsBonds.isDisable());
        savingsBondsColumn.setVisible(!savingsBondsColumn.isVisible());
        if(savingsBondsColumn.isVisible()){
            savingsBondsColumn.setCellValueFactory(cellData -> cellData.getValue().savingsBondsProperty());
        }else{
            savingsBondsColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void eicBoxAction(){
        eic.setDisable(!eic.isDisable());
        eicColumn.setVisible(!eicColumn.isVisible());
        if(eicColumn.isVisible()){
            eicColumn.setCellValueFactory(cellData -> cellData.getValue().eicProperty().asObject());
        }else{
            eicColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void childTaxCreditBoxAction(){
        childTaxCredit.setDisable(!childTaxCredit.isDisable());
        childTaxCreditColumn.setVisible(!childTaxCreditColumn.isVisible());
        if(childTaxCreditColumn.isVisible()){
            childTaxCreditColumn.setCellValueFactory(cellData -> cellData.getValue().childTaxCreditProperty().asObject());
        }else{
            childTaxCreditColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void educationTaxCreditBoxAction(){
        educationTaxCredit.setDisable(!educationTaxCredit.isDisable());
        educationTaxCreditColumn.setVisible(!educationTaxCreditColumn.isVisible());
        if(educationTaxCreditColumn.isVisible()){
            educationTaxCreditColumn.setCellValueFactory(cellData -> cellData.getValue().educationTaxCreditProperty().asObject());
        }else{
            educationTaxCreditColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void elderlyCreditBoxAction(){
        elderlyCredit.setDisable(!elderlyCredit.isDisable());
        elderlyCreditColumn.setVisible(!elderlyCreditColumn.isVisible());
        if(elderlyCreditColumn.isVisible()){
            elderlyCreditColumn.setCellValueFactory(cellData -> cellData.getValue().elderlyCreditProperty().asObject());
        }else{
            elderlyCreditColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void totalRespPaymentBoxAction(){
        totalRespPayment.setDisable(!totalRespPayment.isDisable());
        totalRespPaymentColumn.setVisible(!totalRespPaymentColumn.isVisible());
        if(totalRespPaymentColumn.isVisible()){
            totalRespPaymentColumn.setCellValueFactory(cellData -> cellData.getValue().totalRespPaymentProperty().asObject());
        }else{
            totalRespPaymentColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void totalAdvptcRepaymentBoxAction(){
        totalAdvptcRepayment.setDisable(!totalAdvptcRepayment.isDisable());
        totalAdvptcRepaymentColumn.setVisible(!totalAdvptcRepaymentColumn.isVisible());
        if(totalAdvptcRepaymentColumn.isVisible()){
            totalAdvptcRepaymentColumn.setCellValueFactory(cellData -> cellData.getValue().totalAdvptcRepaymentProperty().asObject());
        }else{
            totalAdvptcRepaymentColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void averageAdvptcPaymentBoxAction(){
        averageAdvptcPayment.setDisable(!averageAdvptcPayment.isDisable());
        averageAdvptcPaymentColumn.setVisible(!averageAdvptcPaymentColumn.isVisible());
        if(averageAdvptcPaymentColumn.isVisible()){
            averageAdvptcPaymentColumn.setCellValueFactory(cellData -> cellData.getValue().averageAdvptcPaymentProperty().asObject());
        }else{
            averageAdvptcPaymentColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void totalPtcBoxAction(){
        totalPtc.setDisable(!totalPtc.isDisable());
        totalPtcColumn.setVisible(!totalPtcColumn.isVisible());
        if(totalPtcColumn.isVisible()){
            totalPtcColumn.setCellValueFactory(cellData -> cellData.getValue().totalPtcProperty().asObject());
        }else{
            totalPtcColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void balanceDueBoxAction(){
        balanceDue.setDisable(!balanceDue.isDisable());
        balanceDueColumn.setVisible(!balanceDueColumn.isVisible());
        if(balanceDueColumn.isVisible()){
            balanceDueColumn.setCellValueFactory(cellData -> cellData.getValue().balanceDueProperty().asObject());
        }else{
            balanceDueColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void itinBoxAction(){
        itin.setDisable(!itin.isDisable());
        itinColumn.setVisible(!itinColumn.isVisible());
        if(itinColumn.isVisible()){
            itinColumn.setCellValueFactory(cellData -> cellData.getValue().itinProperty().asObject());
        }else{
            itinColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void exemption7BoxAction(){
        exemption7.setDisable(!exemption7.isDisable());
        exemption7Column.setVisible(!exemption7Column.isVisible());
        if(exemption7Column.isVisible()){
            exemption7Column.setCellValueFactory(cellData -> cellData.getValue().exemption7Property().asObject());
        }else{
            exemption7Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void fullYearCoverageBoxAction(){
        fullYearCoverage.setDisable(!fullYearCoverage.isDisable());
        fullYearCoverageColumn.setVisible(!fullYearCoverageColumn.isVisible());
        if(fullYearCoverageColumn.isVisible()){
            fullYearCoverageColumn.setCellValueFactory(cellData -> cellData.getValue().fullYearCoverageProperty().asObject());
        }else{
            fullYearCoverageColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void form8888BoxAction(){
        form8888.setDisable(!form8888.isDisable());
        form8888Column.setVisible(!form8888Column.isVisible());
        if(form8888Column.isVisible()){
            form8888Column.setCellValueFactory(cellData -> cellData.getValue().form8888Property().asObject());
        }else{
            form8888Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleABoxAction(){
        scheduleA.setDisable(!scheduleA.isDisable());
        scheduleAColumn.setVisible(!scheduleAColumn.isVisible());
        if(scheduleAColumn.isVisible()){
            scheduleAColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleAProperty().asObject());
        }else{
            scheduleAColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleBBoxAction(){
        scheduleB.setDisable(!scheduleB.isDisable());
        scheduleBColumn.setVisible(!scheduleBColumn.isVisible());
        if(scheduleBColumn.isVisible()){
            scheduleBColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleBProperty().asObject());
        }else{
            scheduleBColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleCBoxAction(){
        scheduleC.setDisable(!scheduleC.isDisable());
        scheduleCColumn.setVisible(!scheduleCColumn.isVisible());
        if(scheduleCColumn.isVisible()){
            scheduleCColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleCProperty().asObject());
        }else{
            scheduleCColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleCEzBoxAction(){
        scheduleCEz.setDisable(!scheduleCEz.isDisable());
        scheduleCEzColumn.setVisible(!scheduleCEzColumn.isVisible());
        if(scheduleCEzColumn.isVisible()){
            scheduleCEzColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleCEzProperty().asObject());
        }else{
            scheduleCEzColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleDBoxAction(){
        scheduleD.setDisable(!scheduleD.isDisable());
        scheduleDColumn.setVisible(!scheduleDColumn.isVisible());
        if(scheduleDColumn.isVisible()){
            scheduleDColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleDProperty().asObject());
        }else{
            scheduleDColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleEBoxAction(){
        scheduleE.setDisable(!scheduleE.isDisable());
        scheduleEColumn.setVisible(!scheduleEColumn.isVisible());
        if(scheduleEColumn.isVisible()){
            scheduleEColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleEProperty().asObject());
        }else{
            scheduleEColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleFBoxAction(){
        scheduleF.setDisable(!scheduleF.isDisable());
        scheduleFColumn.setVisible(!scheduleFColumn.isVisible());
        if(scheduleFColumn.isVisible()){
            scheduleFColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleFProperty().asObject());
        }else{
            scheduleFColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleHBoxAction(){
        scheduleH.setDisable(!scheduleH.isDisable());
        scheduleHColumn.setVisible(!scheduleHColumn.isVisible());
        if(scheduleHColumn.isVisible()){
            scheduleHColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleHProperty().asObject());
        }else{
            scheduleHColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleRBoxAction(){
        scheduleR.setDisable(!scheduleR.isDisable());
        scheduleRColumn.setVisible(!scheduleRColumn.isVisible());
        if(scheduleRColumn.isVisible()){
            scheduleRColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleRProperty().asObject());
        }else{
            scheduleRColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleSetPBoxAction(){
        scheduleSetP.setDisable(!scheduleSetP.isDisable());
        scheduleSetPColumn.setVisible(!scheduleSetPColumn.isVisible());
        if(scheduleSetPColumn.isVisible()){
            scheduleSetPColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleSetPProperty().asObject());
        }else{
            scheduleSetPColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void scheduleSesPBoxAction(){
        scheduleSesP.setDisable(!scheduleSesP.isDisable());
        scheduleSesPColumn.setVisible(!scheduleSesPColumn.isVisible());
        if(scheduleSesPColumn.isVisible()){
            scheduleSesPColumn.setCellValueFactory(cellData -> cellData.getValue().scheduleSesPProperty().asObject());
        }else{
            scheduleSesPColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void agencyIdBoxAction(){
        agencyId.setDisable(!agencyId.isDisable());
        agencyIdColumn.setVisible(!agencyIdColumn.isVisible());
        if(agencyIdColumn.isVisible()){
            agencyIdColumn.setCellValueFactory(cellData -> cellData.getValue().agencyIdProperty());
        }else{
            agencyIdColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void residencyBoxAction(){
        residency.setDisable(!residency.isDisable());
        residencyColumn.setVisible(!residencyColumn.isVisible());
        if(residencyColumn.isVisible()){
            residencyColumn.setCellValueFactory(cellData -> cellData.getValue().residencyProperty());
        }else{
            residencyColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void stateWithholdingBoxAction(){
        stateWithholding.setDisable(!stateWithholding.isDisable());
        stateWithholdingColumn.setVisible(!stateWithholdingColumn.isVisible());
        if(stateWithholdingColumn.isVisible()){
            stateWithholdingColumn.setCellValueFactory(cellData -> cellData.getValue().stateWithholdingProperty().asObject());
        }else{
            stateWithholdingColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void stateTaxLiabilityBoxAction(){
        stateTaxLiability.setDisable(!stateTaxLiability.isDisable());
        stateTaxLiabilityColumn.setVisible(!stateTaxLiabilityColumn.isVisible());
        if(stateTaxLiabilityColumn.isVisible()){
            stateTaxLiabilityColumn.setCellValueFactory(cellData -> cellData.getValue().stateTaxLiabilityProperty().asObject());
        }else{
            stateTaxLiabilityColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void efinBoxAction(){
        efin.setDisable(!efin.isDisable());
        efinColumn.setVisible(!efinColumn.isVisible());
        if(efinColumn.isVisible()){
            efinColumn.setCellValueFactory(cellData -> cellData.getValue().efinProperty());
        }else{
            efinColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void aAmountTaxpayerIsPlanningToSaveBoxAction(){
        aAmountTaxpayerIsPlanningToSave.setDisable(!aAmountTaxpayerIsPlanningToSave.isDisable());
        aAmountTaxpayerIsPlanningToSaveColumn.setVisible(!aAmountTaxpayerIsPlanningToSaveColumn.isVisible());
        if(aAmountTaxpayerIsPlanningToSaveColumn.isVisible()){
            aAmountTaxpayerIsPlanningToSaveColumn.setCellValueFactory(cellData -> cellData.getValue().aAmountTaxpayerIsPlanningToSaveProperty().asObject());
        }else{
            aAmountTaxpayerIsPlanningToSaveColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void consentToDiscloseTaxReturnBoxAction(){
        consentToDiscloseTaxReturn.setDisable(!consentToDiscloseTaxReturn.isDisable());
        consentToDiscloseTaxReturnColumn.setVisible(!consentToDiscloseTaxReturnColumn.isVisible());
        if(consentToDiscloseTaxReturnColumn.isVisible()){
            consentToDiscloseTaxReturnColumn.setCellValueFactory(cellData -> cellData.getValue().consentToDiscloseTaxReturnProperty().asObject());
        }else{
            consentToDiscloseTaxReturnColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void consentToDiscloseTaxpayerDBoxAction(){
        consentToDiscloseTaxpayerD.setDisable(!consentToDiscloseTaxpayerD.isDisable());
        consentToDiscloseTaxpayerDColumn.setVisible(!consentToDiscloseTaxpayerDColumn.isVisible());
        if(consentToDiscloseTaxpayerDColumn.isVisible()){
            consentToDiscloseTaxpayerDColumn.setCellValueFactory(cellData -> cellData.getValue().consentToDiscloseTaxpayerDProperty().asObject());
        }else{
            consentToDiscloseTaxpayerDColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void consentToUseTaxpayerDataBoxAction(){
        consentToUseTaxpayerData.setDisable(!consentToUseTaxpayerData.isDisable());
        consentToUseTaxpayerDataColumn.setVisible(!consentToUseTaxpayerDataColumn.isVisible());
        if(consentToUseTaxpayerDataColumn.isVisible()){
            consentToUseTaxpayerDataColumn.setCellValueFactory(cellData -> cellData.getValue().consentToUseTaxpayerDataProperty().asObject());
        }else{
            consentToUseTaxpayerDataColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void consentToDiscloseTaxReturn1BoxAction(){
        consentToDiscloseTaxReturn1.setDisable(!consentToDiscloseTaxReturn1.isDisable());
        consentToDiscloseTaxReturn1Column.setVisible(!consentToDiscloseTaxReturn1Column.isVisible());
        if(consentToDiscloseTaxReturn1Column.isVisible()){
            consentToDiscloseTaxReturn1Column.setCellValueFactory(cellData -> cellData.getValue().consentToDiscloseTaxReturn1Property().asObject());
        }else{
            consentToDiscloseTaxReturn1Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void consentToDiscloseTaxReturn2BoxAction(){
        consentToDiscloseTaxReturn2.setDisable(!consentToDiscloseTaxReturn2.isDisable());
        consentToDiscloseTaxReturn2Column.setVisible(!consentToDiscloseTaxReturn2Column.isVisible());
        if(consentToDiscloseTaxReturn2Column.isVisible()){
            consentToDiscloseTaxReturn2Column.setCellValueFactory(cellData -> cellData.getValue().consentToDiscloseTaxReturn2Property().asObject());
        }else{
            consentToDiscloseTaxReturn2Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void consentToDiscloseTaxReturn3BoxAction(){
        consentToDiscloseTaxReturn3.setDisable(!consentToDiscloseTaxReturn3.isDisable());
        consentToDiscloseTaxReturn3Column.setVisible(!consentToDiscloseTaxReturn3Column.isVisible());
        if(consentToDiscloseTaxReturn3Column.isVisible()){
            consentToDiscloseTaxReturn3Column.setCellValueFactory(cellData -> cellData.getValue().consentToDiscloseTaxReturn3Property().asObject());
        }else{
            consentToDiscloseTaxReturn3Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void consentToDiscloseTaxReturn4BoxAction(){
        consentToDiscloseTaxReturn4.setDisable(!consentToDiscloseTaxReturn4.isDisable());
        consentToDiscloseTaxReturn4Column.setVisible(!consentToDiscloseTaxReturn4Column.isVisible());
        if(consentToDiscloseTaxReturn4Column.isVisible()){
            consentToDiscloseTaxReturn4Column.setCellValueFactory(cellData -> cellData.getValue().consentToDiscloseTaxReturn4Property().asObject());
        }else{
            consentToDiscloseTaxReturn4Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions1BoxAction(){
        questions1.setDisable(!questions1.isDisable());
        questions1Column.setVisible(!questions1Column.isVisible());
        if(questions1Column.isVisible()){
            questions1Column.setCellValueFactory(cellData -> cellData.getValue().questions1Property());
        }else{
            questions1Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions2BoxAction(){
        questions2.setDisable(!questions2.isDisable());
        questions2Column.setVisible(!questions2Column.isVisible());
        if(questions2Column.isVisible()){
            questions2Column.setCellValueFactory(cellData -> cellData.getValue().questions2Property());
        }else{
            questions2Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions3BoxAction(){
        questions3.setDisable(!questions3.isDisable());
        questions3Column.setVisible(!questions3Column.isVisible());
        if(questions3Column.isVisible()){
            questions3Column.setCellValueFactory(cellData -> cellData.getValue().questions3Property());
        }else{
            questions3Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions4BoxAction(){
        questions4.setDisable(!questions4.isDisable());
        questions4Column.setVisible(!questions4Column.isVisible());
        if(questions4Column.isVisible()){
            questions4Column.setCellValueFactory(cellData -> cellData.getValue().questions4Property());
        }else{
            questions4Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions5BoxAction(){
        questions5.setDisable(!questions5.isDisable());
        questions5Column.setVisible(!questions5Column.isVisible());
        if(questions5Column.isVisible()){
            questions5Column.setCellValueFactory(cellData -> cellData.getValue().questions5Property());
        }else{
            questions5Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions6BoxAction(){
        questions6.setDisable(!questions6.isDisable());
        questions6Column.setVisible(!questions6Column.isVisible());
        if(questions6Column.isVisible()){
            questions6Column.setCellValueFactory(cellData -> cellData.getValue().questions6Property());
        }else{
            questions6Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions7BoxAction(){
        questions7.setDisable(!questions7.isDisable());
        questions7Column.setVisible(!questions7Column.isVisible());
        if(questions7Column.isVisible()){
            questions7Column.setCellValueFactory(cellData -> cellData.getValue().questions7Property());
        }else{
            questions7Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions8BoxAction(){
        questions8.setDisable(!questions8.isDisable());
        questions8Column.setVisible(!questions8Column.isVisible());
        if(questions8Column.isVisible()){
            questions8Column.setCellValueFactory(cellData -> cellData.getValue().questions8Property());
        }else{
            questions8Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questions9BoxAction(){
        questions9.setDisable(!questions9.isDisable());
        questions9Column.setVisible(!questions9Column.isVisible());
        if(questions9Column.isVisible()){
            questions9Column.setCellValueFactory(cellData -> cellData.getValue().questions9Property());
        }else{
            questions9Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionABoxAction(){
        questionA.setDisable(!questionA.isDisable());
        questionAColumn.setVisible(!questionAColumn.isVisible());
        if(questionAColumn.isVisible()){
            questionAColumn.setCellValueFactory(cellData -> cellData.getValue().questionAProperty());
        }else{
            questionAColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionBBoxAction(){
        questionB.setDisable(!questionB.isDisable());
        questionBColumn.setVisible(!questionBColumn.isVisible());
        if(questionBColumn.isVisible()){
            questionBColumn.setCellValueFactory(cellData -> cellData.getValue().questionBProperty());
        }else{
            questionBColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionCBoxAction(){
        questionC.setDisable(!questionC.isDisable());
        questionCColumn.setVisible(!questionCColumn.isVisible());
        if(questionCColumn.isVisible()){
            questionCColumn.setCellValueFactory(cellData -> cellData.getValue().questionCProperty());
        }else{
            questionCColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionDBoxAction(){
        questionD.setDisable(!questionD.isDisable());
        questionDColumn.setVisible(!questionDColumn.isVisible());
        if(questionDColumn.isVisible()){
            questionDColumn.setCellValueFactory(cellData -> cellData.getValue().questionDProperty());
        }else{
            questionDColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionEBoxAction(){
        questionE.setDisable(!questionE.isDisable());
        questionEColumn.setVisible(!questionEColumn.isVisible());
        if(questionEColumn.isVisible()){
            questionEColumn.setCellValueFactory(cellData -> cellData.getValue().questionEProperty());
        }else{
            questionEColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionFBoxAction(){
        questionF.setDisable(!questionF.isDisable());
        questionFColumn.setVisible(!questionFColumn.isVisible());
        if(questionFColumn.isVisible()){
            questionFColumn.setCellValueFactory(cellData -> cellData.getValue().questionFProperty());
        }else{
            questionFColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionGBoxAction(){
        questionG.setDisable(!questionG.isDisable());
        questionGColumn.setVisible(!questionGColumn.isVisible());
        if(questionGColumn.isVisible()){
            questionGColumn.setCellValueFactory(cellData -> cellData.getValue().questionGProperty());
        }else{
            questionGColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionHBoxAction(){
        questionH.setDisable(!questionH.isDisable());
        questionHColumn.setVisible(!questionHColumn.isVisible());
        if(questionHColumn.isVisible()){
            questionHColumn.setCellValueFactory(cellData -> cellData.getValue().questionHProperty());
        }else{
            questionHColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionIBoxAction(){
        questionI.setDisable(!questionI.isDisable());
        questionIColumn.setVisible(!questionIColumn.isVisible());
        if(questionIColumn.isVisible()){
            questionIColumn.setCellValueFactory(cellData -> cellData.getValue().questionIProperty());
        }else{
            questionIColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionJBoxAction(){
        questionJ.setDisable(!questionJ.isDisable());
        questionJColumn.setVisible(!questionJColumn.isVisible());
        if(questionJColumn.isVisible()){
            questionJColumn.setCellValueFactory(cellData -> cellData.getValue().questionJProperty());
        }else{
            questionJColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void questionKBoxAction(){
        questionK.setDisable(!questionK.isDisable());
        questionKColumn.setVisible(!questionKColumn.isVisible());
        if(questionKColumn.isVisible()){
            questionKColumn.setCellValueFactory(cellData -> cellData.getValue().questionKProperty());
        }else{
            questionKColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void persons5AndUnderBoxAction(){
        persons5AndUnder.setDisable(!persons5AndUnder.isDisable());
        persons5AndUnderColumn.setVisible(!persons5AndUnderColumn.isVisible());
        if(persons5AndUnderColumn.isVisible()){
            persons5AndUnderColumn.setCellValueFactory(cellData -> cellData.getValue().persons5AndUnderProperty().asObject());
        }else{
            persons5AndUnderColumn.setCellValueFactory(null);
        }
    }

    @FXML
    private void personsAge6To18BoxAction(){
        personsAge6To18.setDisable(!personsAge6To18.isDisable());
        personsAge6To18Column.setVisible(!personsAge6To18Column.isVisible());
        if(personsAge6To18Column.isVisible()){
            personsAge6To18Column.setCellValueFactory(cellData -> cellData.getValue().personsAge6To18Property().asObject());
        }else{
            personsAge6To18Column.setCellValueFactory(null);
        }
    }

    @FXML
    private void personsAge65PlusBoxAction(){
        personsAge65Plus.setDisable(!personsAge65Plus.isDisable());
        personsAge65PlusColumn.setVisible(!personsAge65PlusColumn.isVisible());
        if(personsAge65PlusColumn.isVisible()){
            personsAge65PlusColumn.setCellValueFactory(cellData -> cellData.getValue().personsAge65PlusProperty().asObject());
        }else{
            personsAge65PlusColumn.setCellValueFactory(null);
        }
    }
}
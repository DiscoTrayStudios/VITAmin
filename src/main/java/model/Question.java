package model;
import javafx.beans.property.*;
public class Question{
	private StringProperty clientId;
	private DoubleProperty taxYear;
	private BooleanProperty consentToDiscloseTaxReturn;
	private BooleanProperty consentToDiscloseTaxpayerD;
	private BooleanProperty consentToUseTaxpayerData;
	private BooleanProperty consentToDiscloseTaxReturn1;
	private BooleanProperty consentToDiscloseTaxReturn2;
	private BooleanProperty consentToDiscloseTaxReturn3;
	private BooleanProperty consentToDiscloseTaxReturn4;
	private StringProperty questions1;
	private StringProperty questions2;
	private StringProperty questions3;
	private StringProperty questions4;
	private StringProperty questions5;
	private StringProperty questions6;
	private StringProperty questions7;
	private StringProperty questions8;
	private StringProperty questions9;
	private StringProperty questionA;
	private StringProperty questionB;
	private StringProperty questionC;
	private StringProperty questionD;
	private StringProperty questionE;
	private StringProperty questionF;
	private StringProperty questionG;
	private StringProperty questionH;
	private StringProperty questionI;
	private StringProperty questionJ;
	private StringProperty questionK;
	private DoubleProperty persons5AndUnder;
	private DoubleProperty personsAge6To18;
	private DoubleProperty personsAge65Plus;
	public Question(){
		this.clientId = new SimpleStringProperty();
		this.taxYear = new SimpleDoubleProperty();
		this.consentToDiscloseTaxReturn = new SimpleBooleanProperty();
		this.consentToDiscloseTaxpayerD = new SimpleBooleanProperty();
		this.consentToUseTaxpayerData = new SimpleBooleanProperty();
		this.consentToDiscloseTaxReturn1 = new SimpleBooleanProperty();
		this.consentToDiscloseTaxReturn2 = new SimpleBooleanProperty();
		this.consentToDiscloseTaxReturn3 = new SimpleBooleanProperty();
		this.consentToDiscloseTaxReturn4 = new SimpleBooleanProperty();
		this.questions1 = new SimpleStringProperty();
		this.questions2 = new SimpleStringProperty();
		this.questions3 = new SimpleStringProperty();
		this.questions4 = new SimpleStringProperty();
		this.questions5 = new SimpleStringProperty();
		this.questions6 = new SimpleStringProperty();
		this.questions7 = new SimpleStringProperty();
		this.questions8 = new SimpleStringProperty();
		this.questions9 = new SimpleStringProperty();
		this.questionA = new SimpleStringProperty();
		this.questionB = new SimpleStringProperty();
		this.questionC = new SimpleStringProperty();
		this.questionD = new SimpleStringProperty();
		this.questionE = new SimpleStringProperty();
		this.questionF = new SimpleStringProperty();
		this.questionG = new SimpleStringProperty();
		this.questionH = new SimpleStringProperty();
		this.questionI = new SimpleStringProperty();
		this.questionJ = new SimpleStringProperty();
		this.questionK = new SimpleStringProperty();
		this.persons5AndUnder = new SimpleDoubleProperty();
		this.personsAge6To18 = new SimpleDoubleProperty();
		this.personsAge65Plus = new SimpleDoubleProperty();
	}
	public String getClientId(){return clientId.get();}

	public void setClientId(String clientId){this.clientId.set(clientId);}

	public StringProperty clientIdProperty(){return clientId;}


	public double getTaxYear(){return taxYear.get();}

	public void setTaxYear(double taxYear){this.taxYear.set(taxYear);}

	public DoubleProperty taxYearProperty(){return taxYear;}


	public boolean getConsentToDiscloseTaxReturn(){return consentToDiscloseTaxReturn.get();}

	public void setConsentToDiscloseTaxReturn(boolean consentToDiscloseTaxReturn){this.consentToDiscloseTaxReturn.set(consentToDiscloseTaxReturn);}

	public BooleanProperty consentToDiscloseTaxReturnProperty(){return consentToDiscloseTaxReturn;}


	public boolean getConsentToDiscloseTaxpayerD(){return consentToDiscloseTaxpayerD.get();}

	public void setConsentToDiscloseTaxpayerD(boolean consentToDiscloseTaxpayerD){this.consentToDiscloseTaxpayerD.set(consentToDiscloseTaxpayerD);}

	public BooleanProperty consentToDiscloseTaxpayerDProperty(){return consentToDiscloseTaxpayerD;}


	public boolean getConsentToUseTaxpayerData(){return consentToUseTaxpayerData.get();}

	public void setConsentToUseTaxpayerData(boolean consentToUseTaxpayerData){this.consentToUseTaxpayerData.set(consentToUseTaxpayerData);}

	public BooleanProperty consentToUseTaxpayerDataProperty(){return consentToUseTaxpayerData;}


	public boolean getConsentToDiscloseTaxReturn1(){return consentToDiscloseTaxReturn1.get();}

	public void setConsentToDiscloseTaxReturn1(boolean consentToDiscloseTaxReturn1){this.consentToDiscloseTaxReturn1.set(consentToDiscloseTaxReturn1);}

	public BooleanProperty consentToDiscloseTaxReturn1Property(){return consentToDiscloseTaxReturn1;}


	public boolean getConsentToDiscloseTaxReturn2(){return consentToDiscloseTaxReturn2.get();}

	public void setConsentToDiscloseTaxReturn2(boolean consentToDiscloseTaxReturn2){this.consentToDiscloseTaxReturn2.set(consentToDiscloseTaxReturn2);}

	public BooleanProperty consentToDiscloseTaxReturn2Property(){return consentToDiscloseTaxReturn2;}


	public boolean getConsentToDiscloseTaxReturn3(){return consentToDiscloseTaxReturn3.get();}

	public void setConsentToDiscloseTaxReturn3(boolean consentToDiscloseTaxReturn3){this.consentToDiscloseTaxReturn3.set(consentToDiscloseTaxReturn3);}

	public BooleanProperty consentToDiscloseTaxReturn3Property(){return consentToDiscloseTaxReturn3;}


	public boolean getConsentToDiscloseTaxReturn4(){return consentToDiscloseTaxReturn4.get();}

	public void setConsentToDiscloseTaxReturn4(boolean consentToDiscloseTaxReturn4){this.consentToDiscloseTaxReturn4.set(consentToDiscloseTaxReturn4);}

	public BooleanProperty consentToDiscloseTaxReturn4Property(){return consentToDiscloseTaxReturn4;}


	public String getQuestions1(){return questions1.get();}

	public void setQuestions1(String questions1){this.questions1.set(questions1);}

	public StringProperty questions1Property(){return questions1;}


	public String getQuestions2(){return questions2.get();}

	public void setQuestions2(String questions2){this.questions2.set(questions2);}

	public StringProperty questions2Property(){return questions2;}


	public String getQuestions3(){return questions3.get();}

	public void setQuestions3(String questions3){this.questions3.set(questions3);}

	public StringProperty questions3Property(){return questions3;}


	public String getQuestions4(){return questions4.get();}

	public void setQuestions4(String questions4){this.questions4.set(questions4);}

	public StringProperty questions4Property(){return questions4;}


	public String getQuestions5(){return questions5.get();}

	public void setQuestions5(String questions5){this.questions5.set(questions5);}

	public StringProperty questions5Property(){return questions5;}


	public String getQuestions6(){return questions6.get();}

	public void setQuestions6(String questions6){this.questions6.set(questions6);}

	public StringProperty questions6Property(){return questions6;}


	public String getQuestions7(){return questions7.get();}

	public void setQuestions7(String questions7){this.questions7.set(questions7);}

	public StringProperty questions7Property(){return questions7;}


	public String getQuestions8(){return questions8.get();}

	public void setQuestions8(String questions8){this.questions8.set(questions8);}

	public StringProperty questions8Property(){return questions8;}


	public String getQuestions9(){return questions9.get();}

	public void setQuestions9(String questions9){this.questions9.set(questions9);}

	public StringProperty questions9Property(){return questions9;}


	public String getQuestionA(){return questionA.get();}

	public void setQuestionA(String questionA){this.questionA.set(questionA);}

	public StringProperty questionAProperty(){return questionA;}


	public String getQuestionB(){return questionB.get();}

	public void setQuestionB(String questionB){this.questionB.set(questionB);}

	public StringProperty questionBProperty(){return questionB;}


	public String getQuestionC(){return questionC.get();}

	public void setQuestionC(String questionC){this.questionC.set(questionC);}

	public StringProperty questionCProperty(){return questionC;}


	public String getQuestionD(){return questionD.get();}

	public void setQuestionD(String questionD){this.questionD.set(questionD);}

	public StringProperty questionDProperty(){return questionD;}


	public String getQuestionE(){return questionE.get();}

	public void setQuestionE(String questionE){this.questionE.set(questionE);}

	public StringProperty questionEProperty(){return questionE;}


	public String getQuestionF(){return questionF.get();}

	public void setQuestionF(String questionF){this.questionF.set(questionF);}

	public StringProperty questionFProperty(){return questionF;}


	public String getQuestionG(){return questionG.get();}

	public void setQuestionG(String questionG){this.questionG.set(questionG);}

	public StringProperty questionGProperty(){return questionG;}


	public String getQuestionH(){return questionH.get();}

	public void setQuestionH(String questionH){this.questionH.set(questionH);}

	public StringProperty questionHProperty(){return questionH;}


	public String getQuestionI(){return questionI.get();}

	public void setQuestionI(String questionI){this.questionI.set(questionI);}

	public StringProperty questionIProperty(){return questionI;}


	public String getQuestionJ(){return questionJ.get();}

	public void setQuestionJ(String questionJ){this.questionJ.set(questionJ);}

	public StringProperty questionJProperty(){return questionJ;}


	public String getQuestionK(){return questionK.get();}

	public void setQuestionK(String questionK){this.questionK.set(questionK);}

	public StringProperty questionKProperty(){return questionK;}


	public double getPersons5AndUnder(){return persons5AndUnder.get();}

	public void setPersons5AndUnder(double persons5AndUnder){this.persons5AndUnder.set(persons5AndUnder);}

	public DoubleProperty persons5AndUnderProperty(){return persons5AndUnder;}


	public double getPersonsAge6To18(){return personsAge6To18.get();}

	public void setPersonsAge6To18(double personsAge6To18){this.personsAge6To18.set(personsAge6To18);}

	public DoubleProperty personsAge6To18Property(){return personsAge6To18;}


	public double getPersonsAge65Plus(){return personsAge65Plus.get();}

	public void setPersonsAge65Plus(double personsAge65Plus){this.personsAge65Plus.set(personsAge65Plus);}

	public DoubleProperty personsAge65PlusProperty(){return personsAge65Plus;}


}

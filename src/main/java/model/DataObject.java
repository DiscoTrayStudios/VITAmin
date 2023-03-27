package model;
import javafx.beans.property.*;
public class DataObject{
	private Client client;
	private Demographic demographic;
	private ReturnData returnData;
	private Question question;
	private TaxYear taxYear;
	public DataObject(){
		this.client = new Client();
		this.demographic = new Demographic();
		this.returnData = new ReturnData();
		this.question = new Question();
		this.taxYear = new TaxYear();
	}
	public String getId(){return client.getId();}

	public void setId(String id){client.setId(id);}

	public StringProperty idProperty(){return client.idProperty();}


	public String getSidn(){return client.getSidn();}

	public void setSidn(String sidn){client.setSidn(sidn);}

	public StringProperty sidnProperty(){return client.sidnProperty();}


	public String getL4SSN(){return client.getL4SSN();}

	public void setL4SSN(String l4SSN){client.setL4SSN(l4SSN);}

	public StringProperty l4SSNProperty(){return client.l4SSNProperty();}


	public String getFirstName(){return client.getFirstName();}

	public void setFirstName(String firstName){client.setFirstName(firstName);}

	public StringProperty firstNameProperty(){return client.firstNameProperty();}


	public String getLastName(){return client.getLastName();}

	public void setLastName(String lastName){client.setLastName(lastName);}

	public StringProperty lastNameProperty(){return client.lastNameProperty();}


	public String getDoB(){return client.getDoB();}

	public void setDoB(String doB){client.setDoB(doB);}

	public StringProperty doBProperty(){return client.doBProperty();}


	public String getEfin(){return client.getEfin();}

	public void setEfin(String efin){client.setEfin(efin);}

	public StringProperty efinProperty(){return client.efinProperty();}


	public String getCity(){return demographic.getCity();}

	public void setCity(String city){demographic.setCity(city);}

	public StringProperty cityProperty(){return demographic.cityProperty();}


	public String getState(){return demographic.getState();}

	public void setState(String state){demographic.setState(state);}

	public StringProperty stateProperty(){return demographic.stateProperty();}


	public String getZip(){return demographic.getZip();}

	public void setZip(String zip){demographic.setZip(zip);}

	public StringProperty zipProperty(){return demographic.zipProperty();}


	public double getPrimarySecondary60Plus(){return demographic.getPrimarySecondary60Plus();}

	public void setPrimarySecondary60Plus(double primarySecondary60Plus){demographic.setPrimarySecondary60Plus(primarySecondary60Plus);}

	public DoubleProperty primarySecondary60PlusProperty(){return demographic.primarySecondary60PlusProperty();}


	public String getResidency(){return demographic.getResidency();}

	public void setResidency(String residency){demographic.setResidency(residency);}

	public StringProperty residencyProperty(){return demographic.residencyProperty();}


	public boolean getFederal(){return returnData.getFederal();}

	public void setFederal(boolean federal){returnData.setFederal(federal);}

	public BooleanProperty federalProperty(){return returnData.federalProperty();}


	public String getAcceptedData(){return returnData.getAcceptedData();}

	public void setAcceptedData(String acceptedData){returnData.setAcceptedData(acceptedData);}

	public StringProperty acceptedDataProperty(){return returnData.acceptedDataProperty();}


	public String getReturnType(){return returnData.getReturnType();}

	public void setReturnType(String returnType){returnData.setReturnType(returnType);}

	public StringProperty returnTypeProperty(){return returnData.returnTypeProperty();}


	public String getFilingStatus(){return returnData.getFilingStatus();}

	public void setFilingStatus(String filingStatus){returnData.setFilingStatus(filingStatus);}

	public StringProperty filingStatusProperty(){return returnData.filingStatusProperty();}


	public double getTotalIrsExemptions(){return returnData.getTotalIrsExemptions();}

	public void setTotalIrsExemptions(double totalIrsExemptions){returnData.setTotalIrsExemptions(totalIrsExemptions);}

	public DoubleProperty totalIrsExemptionsProperty(){return returnData.totalIrsExemptionsProperty();}


	public double getRefund(){return returnData.getRefund();}

	public void setRefund(double refund){returnData.setRefund(refund);}

	public DoubleProperty refundProperty(){return returnData.refundProperty();}


	public boolean getPaperState(){return returnData.getPaperState();}

	public void setPaperState(boolean paperState){returnData.setPaperState(paperState);}

	public BooleanProperty paperStateProperty(){return returnData.paperStateProperty();}


	public boolean getPaperFed(){return returnData.getPaperFed();}

	public void setPaperFed(boolean paperFed){returnData.setPaperFed(paperFed);}

	public BooleanProperty paperFedProperty(){return returnData.paperFedProperty();}


	public boolean getRequestingDd(){return returnData.getRequestingDd();}

	public void setRequestingDd(boolean requestingDd){returnData.setRequestingDd(requestingDd);}

	public BooleanProperty requestingDdProperty(){return returnData.requestingDdProperty();}


	public double getAgi(){return returnData.getAgi();}

	public void setAgi(double agi){returnData.setAgi(agi);}

	public DoubleProperty agiProperty(){return returnData.agiProperty();}


	public String getCreatedDate(){return returnData.getCreatedDate();}

	public void setCreatedDate(String createdDate){returnData.setCreatedDate(createdDate);}

	public StringProperty createdDateProperty(){return returnData.createdDateProperty();}


	public double getAddctc(){return returnData.getAddctc();}

	public void setAddctc(double addctc){returnData.setAddctc(addctc);}

	public DoubleProperty addctcProperty(){return returnData.addctcProperty();}


	public String getPoundSavingsBonds(){return returnData.getPoundSavingsBonds();}

	public void setPoundSavingsBonds(String poundSavingsBonds){returnData.setPoundSavingsBonds(poundSavingsBonds);}

	public StringProperty poundSavingsBondsProperty(){return returnData.poundSavingsBondsProperty();}


	public String getSavingsBonds(){return returnData.getSavingsBonds();}

	public void setSavingsBonds(String savingsBonds){returnData.setSavingsBonds(savingsBonds);}

	public StringProperty savingsBondsProperty(){return returnData.savingsBondsProperty();}


	public double getEic(){return returnData.getEic();}

	public void setEic(double eic){returnData.setEic(eic);}

	public DoubleProperty eicProperty(){return returnData.eicProperty();}


	public double getChildTaxCredit(){return returnData.getChildTaxCredit();}

	public void setChildTaxCredit(double childTaxCredit){returnData.setChildTaxCredit(childTaxCredit);}

	public DoubleProperty childTaxCreditProperty(){return returnData.childTaxCreditProperty();}


	public double getEducationTaxCredit(){return returnData.getEducationTaxCredit();}

	public void setEducationTaxCredit(double educationTaxCredit){returnData.setEducationTaxCredit(educationTaxCredit);}

	public DoubleProperty educationTaxCreditProperty(){return returnData.educationTaxCreditProperty();}


	public double getElderlyCredit(){return returnData.getElderlyCredit();}

	public void setElderlyCredit(double elderlyCredit){returnData.setElderlyCredit(elderlyCredit);}

	public DoubleProperty elderlyCreditProperty(){return returnData.elderlyCreditProperty();}


	public double getTotalRespPayment(){return returnData.getTotalRespPayment();}

	public void setTotalRespPayment(double totalRespPayment){returnData.setTotalRespPayment(totalRespPayment);}

	public DoubleProperty totalRespPaymentProperty(){return returnData.totalRespPaymentProperty();}


	public double getTotalAdvptcRepayment(){return returnData.getTotalAdvptcRepayment();}

	public void setTotalAdvptcRepayment(double totalAdvptcRepayment){returnData.setTotalAdvptcRepayment(totalAdvptcRepayment);}

	public DoubleProperty totalAdvptcRepaymentProperty(){return returnData.totalAdvptcRepaymentProperty();}


	public double getAverageAdvptcPayment(){return returnData.getAverageAdvptcPayment();}

	public void setAverageAdvptcPayment(double averageAdvptcPayment){returnData.setAverageAdvptcPayment(averageAdvptcPayment);}

	public DoubleProperty averageAdvptcPaymentProperty(){return returnData.averageAdvptcPaymentProperty();}


	public double getTotalPtc(){return returnData.getTotalPtc();}

	public void setTotalPtc(double totalPtc){returnData.setTotalPtc(totalPtc);}

	public DoubleProperty totalPtcProperty(){return returnData.totalPtcProperty();}


	public double getBalanceDue(){return returnData.getBalanceDue();}

	public void setBalanceDue(double balanceDue){returnData.setBalanceDue(balanceDue);}

	public DoubleProperty balanceDueProperty(){return returnData.balanceDueProperty();}


	public boolean getItin(){return returnData.getItin();}

	public void setItin(boolean itin){returnData.setItin(itin);}

	public BooleanProperty itinProperty(){return returnData.itinProperty();}


	public boolean getExemption7(){return returnData.getExemption7();}

	public void setExemption7(boolean exemption7){returnData.setExemption7(exemption7);}

	public BooleanProperty exemption7Property(){return returnData.exemption7Property();}


	public boolean getFullYearCoverage(){return returnData.getFullYearCoverage();}

	public void setFullYearCoverage(boolean fullYearCoverage){returnData.setFullYearCoverage(fullYearCoverage);}

	public BooleanProperty fullYearCoverageProperty(){return returnData.fullYearCoverageProperty();}


	public boolean getForm8888(){return returnData.getForm8888();}

	public void setForm8888(boolean form8888){returnData.setForm8888(form8888);}

	public BooleanProperty form8888Property(){return returnData.form8888Property();}


	public boolean getScheduleA(){return returnData.getScheduleA();}

	public void setScheduleA(boolean scheduleA){returnData.setScheduleA(scheduleA);}

	public BooleanProperty scheduleAProperty(){return returnData.scheduleAProperty();}


	public boolean getScheduleB(){return returnData.getScheduleB();}

	public void setScheduleB(boolean scheduleB){returnData.setScheduleB(scheduleB);}

	public BooleanProperty scheduleBProperty(){return returnData.scheduleBProperty();}


	public boolean getScheduleC(){return returnData.getScheduleC();}

	public void setScheduleC(boolean scheduleC){returnData.setScheduleC(scheduleC);}

	public BooleanProperty scheduleCProperty(){return returnData.scheduleCProperty();}


	public boolean getScheduleCEz(){return returnData.getScheduleCEz();}

	public void setScheduleCEz(boolean scheduleCEz){returnData.setScheduleCEz(scheduleCEz);}

	public BooleanProperty scheduleCEzProperty(){return returnData.scheduleCEzProperty();}


	public boolean getScheduleD(){return returnData.getScheduleD();}

	public void setScheduleD(boolean scheduleD){returnData.setScheduleD(scheduleD);}

	public BooleanProperty scheduleDProperty(){return returnData.scheduleDProperty();}


	public boolean getScheduleE(){return returnData.getScheduleE();}

	public void setScheduleE(boolean scheduleE){returnData.setScheduleE(scheduleE);}

	public BooleanProperty scheduleEProperty(){return returnData.scheduleEProperty();}


	public boolean getScheduleF(){return returnData.getScheduleF();}

	public void setScheduleF(boolean scheduleF){returnData.setScheduleF(scheduleF);}

	public BooleanProperty scheduleFProperty(){return returnData.scheduleFProperty();}


	public boolean getScheduleH(){return returnData.getScheduleH();}

	public void setScheduleH(boolean scheduleH){returnData.setScheduleH(scheduleH);}

	public BooleanProperty scheduleHProperty(){return returnData.scheduleHProperty();}


	public boolean getScheduleR(){return returnData.getScheduleR();}

	public void setScheduleR(boolean scheduleR){returnData.setScheduleR(scheduleR);}

	public BooleanProperty scheduleRProperty(){return returnData.scheduleRProperty();}


	public boolean getScheduleSetP(){return returnData.getScheduleSetP();}

	public void setScheduleSetP(boolean scheduleSetP){returnData.setScheduleSetP(scheduleSetP);}

	public BooleanProperty scheduleSetPProperty(){return returnData.scheduleSetPProperty();}


	public boolean getScheduleSesP(){return returnData.getScheduleSesP();}

	public void setScheduleSesP(boolean scheduleSesP){returnData.setScheduleSesP(scheduleSesP);}

	public BooleanProperty scheduleSesPProperty(){return returnData.scheduleSesPProperty();}


	public String getAgencyId(){return returnData.getAgencyId();}

	public void setAgencyId(String agencyId){returnData.setAgencyId(agencyId);}

	public StringProperty agencyIdProperty(){return returnData.agencyIdProperty();}


	public double getStateWithholding(){return returnData.getStateWithholding();}

	public void setStateWithholding(double stateWithholding){returnData.setStateWithholding(stateWithholding);}

	public DoubleProperty stateWithholdingProperty(){return returnData.stateWithholdingProperty();}


	public double getStateTaxLiability(){return returnData.getStateTaxLiability();}

	public void setStateTaxLiability(double stateTaxLiability){returnData.setStateTaxLiability(stateTaxLiability);}

	public DoubleProperty stateTaxLiabilityProperty(){return returnData.stateTaxLiabilityProperty();}


	public double getAAmountTaxpayerIsPlanningToSave(){return returnData.getAAmountTaxpayerIsPlanningToSave();}

	public void setAAmountTaxpayerIsPlanningToSave(double aAmountTaxpayerIsPlanningToSave){returnData.setAAmountTaxpayerIsPlanningToSave(aAmountTaxpayerIsPlanningToSave);}

	public DoubleProperty aAmountTaxpayerIsPlanningToSaveProperty(){return returnData.aAmountTaxpayerIsPlanningToSaveProperty();}


	public boolean getConsentToDiscloseTaxReturn(){return question.getConsentToDiscloseTaxReturn();}

	public void setConsentToDiscloseTaxReturn(boolean consentToDiscloseTaxReturn){question.setConsentToDiscloseTaxReturn(consentToDiscloseTaxReturn);}

	public BooleanProperty consentToDiscloseTaxReturnProperty(){return question.consentToDiscloseTaxReturnProperty();}


	public boolean getConsentToDiscloseTaxpayerD(){return question.getConsentToDiscloseTaxpayerD();}

	public void setConsentToDiscloseTaxpayerD(boolean consentToDiscloseTaxpayerD){question.setConsentToDiscloseTaxpayerD(consentToDiscloseTaxpayerD);}

	public BooleanProperty consentToDiscloseTaxpayerDProperty(){return question.consentToDiscloseTaxpayerDProperty();}


	public boolean getConsentToUseTaxpayerData(){return question.getConsentToUseTaxpayerData();}

	public void setConsentToUseTaxpayerData(boolean consentToUseTaxpayerData){question.setConsentToUseTaxpayerData(consentToUseTaxpayerData);}

	public BooleanProperty consentToUseTaxpayerDataProperty(){return question.consentToUseTaxpayerDataProperty();}


	public boolean getConsentToDiscloseTaxReturn1(){return question.getConsentToDiscloseTaxReturn1();}

	public void setConsentToDiscloseTaxReturn1(boolean consentToDiscloseTaxReturn1){question.setConsentToDiscloseTaxReturn1(consentToDiscloseTaxReturn1);}

	public BooleanProperty consentToDiscloseTaxReturn1Property(){return question.consentToDiscloseTaxReturn1Property();}


	public boolean getConsentToDiscloseTaxReturn2(){return question.getConsentToDiscloseTaxReturn2();}

	public void setConsentToDiscloseTaxReturn2(boolean consentToDiscloseTaxReturn2){question.setConsentToDiscloseTaxReturn2(consentToDiscloseTaxReturn2);}

	public BooleanProperty consentToDiscloseTaxReturn2Property(){return question.consentToDiscloseTaxReturn2Property();}


	public boolean getConsentToDiscloseTaxReturn3(){return question.getConsentToDiscloseTaxReturn3();}

	public void setConsentToDiscloseTaxReturn3(boolean consentToDiscloseTaxReturn3){question.setConsentToDiscloseTaxReturn3(consentToDiscloseTaxReturn3);}

	public BooleanProperty consentToDiscloseTaxReturn3Property(){return question.consentToDiscloseTaxReturn3Property();}


	public boolean getConsentToDiscloseTaxReturn4(){return question.getConsentToDiscloseTaxReturn4();}

	public void setConsentToDiscloseTaxReturn4(boolean consentToDiscloseTaxReturn4){question.setConsentToDiscloseTaxReturn4(consentToDiscloseTaxReturn4);}

	public BooleanProperty consentToDiscloseTaxReturn4Property(){return question.consentToDiscloseTaxReturn4Property();}


	public String getQuestions1(){return question.getQuestions1();}

	public void setQuestions1(String questions1){question.setQuestions1(questions1);}

	public StringProperty questions1Property(){return question.questions1Property();}


	public String getQuestions2(){return question.getQuestions2();}

	public void setQuestions2(String questions2){question.setQuestions2(questions2);}

	public StringProperty questions2Property(){return question.questions2Property();}


	public String getQuestions3(){return question.getQuestions3();}

	public void setQuestions3(String questions3){question.setQuestions3(questions3);}

	public StringProperty questions3Property(){return question.questions3Property();}


	public String getQuestions4(){return question.getQuestions4();}

	public void setQuestions4(String questions4){question.setQuestions4(questions4);}

	public StringProperty questions4Property(){return question.questions4Property();}


	public String getQuestions5(){return question.getQuestions5();}

	public void setQuestions5(String questions5){question.setQuestions5(questions5);}

	public StringProperty questions5Property(){return question.questions5Property();}


	public String getQuestions6(){return question.getQuestions6();}

	public void setQuestions6(String questions6){question.setQuestions6(questions6);}

	public StringProperty questions6Property(){return question.questions6Property();}


	public String getQuestions7(){return question.getQuestions7();}

	public void setQuestions7(String questions7){question.setQuestions7(questions7);}

	public StringProperty questions7Property(){return question.questions7Property();}


	public String getQuestions8(){return question.getQuestions8();}

	public void setQuestions8(String questions8){question.setQuestions8(questions8);}

	public StringProperty questions8Property(){return question.questions8Property();}


	public String getQuestions9(){return question.getQuestions9();}

	public void setQuestions9(String questions9){question.setQuestions9(questions9);}

	public StringProperty questions9Property(){return question.questions9Property();}


	public String getQuestionA(){return question.getQuestionA();}

	public void setQuestionA(String questionA){question.setQuestionA(questionA);}

	public StringProperty questionAProperty(){return question.questionAProperty();}


	public String getQuestionB(){return question.getQuestionB();}

	public void setQuestionB(String questionB){question.setQuestionB(questionB);}

	public StringProperty questionBProperty(){return question.questionBProperty();}


	public String getQuestionC(){return question.getQuestionC();}

	public void setQuestionC(String questionC){question.setQuestionC(questionC);}

	public StringProperty questionCProperty(){return question.questionCProperty();}


	public String getQuestionD(){return question.getQuestionD();}

	public void setQuestionD(String questionD){question.setQuestionD(questionD);}

	public StringProperty questionDProperty(){return question.questionDProperty();}


	public String getQuestionE(){return question.getQuestionE();}

	public void setQuestionE(String questionE){question.setQuestionE(questionE);}

	public StringProperty questionEProperty(){return question.questionEProperty();}


	public String getQuestionF(){return question.getQuestionF();}

	public void setQuestionF(String questionF){question.setQuestionF(questionF);}

	public StringProperty questionFProperty(){return question.questionFProperty();}


	public String getQuestionG(){return question.getQuestionG();}

	public void setQuestionG(String questionG){question.setQuestionG(questionG);}

	public StringProperty questionGProperty(){return question.questionGProperty();}


	public String getQuestionH(){return question.getQuestionH();}

	public void setQuestionH(String questionH){question.setQuestionH(questionH);}

	public StringProperty questionHProperty(){return question.questionHProperty();}


	public String getQuestionI(){return question.getQuestionI();}

	public void setQuestionI(String questionI){question.setQuestionI(questionI);}

	public StringProperty questionIProperty(){return question.questionIProperty();}


	public String getQuestionJ(){return question.getQuestionJ();}

	public void setQuestionJ(String questionJ){question.setQuestionJ(questionJ);}

	public StringProperty questionJProperty(){return question.questionJProperty();}


	public String getQuestionK(){return question.getQuestionK();}

	public void setQuestionK(String questionK){question.setQuestionK(questionK);}

	public StringProperty questionKProperty(){return question.questionKProperty();}


	public double getPersons5AndUnder(){return question.getPersons5AndUnder();}

	public void setPersons5AndUnder(double persons5AndUnder){question.setPersons5AndUnder(persons5AndUnder);}

	public DoubleProperty persons5AndUnderProperty(){return question.persons5AndUnderProperty();}


	public double getPersonsAge6To18(){return question.getPersonsAge6To18();}

	public void setPersonsAge6To18(double personsAge6To18){question.setPersonsAge6To18(personsAge6To18);}

	public DoubleProperty personsAge6To18Property(){return question.personsAge6To18Property();}


	public double getPersonsAge65Plus(){return question.getPersonsAge65Plus();}

	public void setPersonsAge65Plus(double personsAge65Plus){question.setPersonsAge65Plus(personsAge65Plus);}

	public DoubleProperty personsAge65PlusProperty(){return question.personsAge65PlusProperty();}


	public int getTaxYear(){return taxYear.getTaxYear();}

	public void setTaxYear(int year){taxYear.setTaxYear(year);}

	public IntegerProperty taxYearProperty(){return taxYear.taxYearProperty();}


}

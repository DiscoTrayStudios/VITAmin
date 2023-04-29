package model;
import javafx.beans.property.*;
public class ReturnData{
	private StringProperty clientId;
	private DoubleProperty taxYear;
	private BooleanProperty federal;
	private StringProperty acceptedDate;
	private StringProperty returnType;
	private StringProperty filingStatus;
	private DoubleProperty totalIrsExemptions;
	private DoubleProperty refund;
	private BooleanProperty paperState;
	private BooleanProperty paperFed;
	private BooleanProperty requestingDd;
	private DoubleProperty agi;
	private StringProperty createdDate;
	private DoubleProperty addctc;
	private StringProperty poundSavingsBonds;
	private StringProperty savingsBonds;
	private DoubleProperty eic;
	private DoubleProperty childTaxCredit;
	private DoubleProperty educationTaxCredit;
	private DoubleProperty elderlyCredit;
	private DoubleProperty totalRespPayment;
	private DoubleProperty totalAdvptcRepayment;
	private DoubleProperty averageAdvptcPayment;
	private DoubleProperty totalPtc;
	private DoubleProperty balanceDue;
	private BooleanProperty itin;
	private BooleanProperty exemption7;
	private BooleanProperty fullYearCoverage;
	private BooleanProperty form8888;
	private BooleanProperty scheduleA;
	private BooleanProperty scheduleB;
	private BooleanProperty scheduleC;
	private BooleanProperty scheduleCEz;
	private BooleanProperty scheduleD;
	private BooleanProperty scheduleE;
	private BooleanProperty scheduleF;
	private BooleanProperty scheduleH;
	private BooleanProperty scheduleR;
	private BooleanProperty scheduleSetP;
	private BooleanProperty scheduleSesP;
	private StringProperty agencyId;
	private DoubleProperty stateWithholding;
	private DoubleProperty stateTaxLiability;
	private DoubleProperty aAmountTaxpayerIsPlanningToSave;
	public ReturnData(){
		this.clientId = new SimpleStringProperty();
		this.taxYear = new SimpleDoubleProperty();
		this.federal = new SimpleBooleanProperty();
		this.acceptedDate = new SimpleStringProperty();
		this.returnType = new SimpleStringProperty();
		this.filingStatus = new SimpleStringProperty();
		this.totalIrsExemptions = new SimpleDoubleProperty();
		this.refund = new SimpleDoubleProperty();
		this.paperState = new SimpleBooleanProperty();
		this.paperFed = new SimpleBooleanProperty();
		this.requestingDd = new SimpleBooleanProperty();
		this.agi = new SimpleDoubleProperty();
		this.createdDate = new SimpleStringProperty();
		this.addctc = new SimpleDoubleProperty();
		this.poundSavingsBonds = new SimpleStringProperty();
		this.savingsBonds = new SimpleStringProperty();
		this.eic = new SimpleDoubleProperty();
		this.childTaxCredit = new SimpleDoubleProperty();
		this.educationTaxCredit = new SimpleDoubleProperty();
		this.elderlyCredit = new SimpleDoubleProperty();
		this.totalRespPayment = new SimpleDoubleProperty();
		this.totalAdvptcRepayment = new SimpleDoubleProperty();
		this.averageAdvptcPayment = new SimpleDoubleProperty();
		this.totalPtc = new SimpleDoubleProperty();
		this.balanceDue = new SimpleDoubleProperty();
		this.itin = new SimpleBooleanProperty();
		this.exemption7 = new SimpleBooleanProperty();
		this.fullYearCoverage = new SimpleBooleanProperty();
		this.form8888 = new SimpleBooleanProperty();
		this.scheduleA = new SimpleBooleanProperty();
		this.scheduleB = new SimpleBooleanProperty();
		this.scheduleC = new SimpleBooleanProperty();
		this.scheduleCEz = new SimpleBooleanProperty();
		this.scheduleD = new SimpleBooleanProperty();
		this.scheduleE = new SimpleBooleanProperty();
		this.scheduleF = new SimpleBooleanProperty();
		this.scheduleH = new SimpleBooleanProperty();
		this.scheduleR = new SimpleBooleanProperty();
		this.scheduleSetP = new SimpleBooleanProperty();
		this.scheduleSesP = new SimpleBooleanProperty();
		this.agencyId = new SimpleStringProperty();
		this.stateWithholding = new SimpleDoubleProperty();
		this.stateTaxLiability = new SimpleDoubleProperty();
		this.aAmountTaxpayerIsPlanningToSave = new SimpleDoubleProperty();
	}
	public String getClientId(){return clientId.get();}

	public void setClientId(String clientId){this.clientId.set(clientId);}

	public StringProperty clientIdProperty(){return clientId;}


	public double getTaxYear(){return taxYear.get();}

	public void setTaxYear(double taxYear){this.taxYear.set(taxYear);}

	public DoubleProperty taxYearProperty(){return taxYear;}


	public boolean getFederal(){return federal.get();}

	public void setFederal(boolean federal){this.federal.set(federal);}

	public BooleanProperty federalProperty(){return federal;}


	public String getAcceptedDate(){return acceptedDate.get();}

	public void setAcceptedDate(String acceptedDate){this.acceptedDate.set(acceptedDate);}

	public StringProperty acceptedDateProperty(){return acceptedDate;}


	public String getReturnType(){return returnType.get();}

	public void setReturnType(String returnType){this.returnType.set(returnType);}

	public StringProperty returnTypeProperty(){return returnType;}


	public String getFilingStatus(){return filingStatus.get();}

	public void setFilingStatus(String filingStatus){this.filingStatus.set(filingStatus);}

	public StringProperty filingStatusProperty(){return filingStatus;}


	public double getTotalIrsExemptions(){return totalIrsExemptions.get();}

	public void setTotalIrsExemptions(double totalIrsExemptions){this.totalIrsExemptions.set(totalIrsExemptions);}

	public DoubleProperty totalIrsExemptionsProperty(){return totalIrsExemptions;}


	public double getRefund(){return refund.get();}

	public void setRefund(double refund){this.refund.set(refund);}

	public DoubleProperty refundProperty(){return refund;}


	public boolean getPaperState(){return paperState.get();}

	public void setPaperState(boolean paperState){this.paperState.set(paperState);}

	public BooleanProperty paperStateProperty(){return paperState;}


	public boolean getPaperFed(){return paperFed.get();}

	public void setPaperFed(boolean paperFed){this.paperFed.set(paperFed);}

	public BooleanProperty paperFedProperty(){return paperFed;}


	public boolean getRequestingDd(){return requestingDd.get();}

	public void setRequestingDd(boolean requestingDd){this.requestingDd.set(requestingDd);}

	public BooleanProperty requestingDdProperty(){return requestingDd;}


	public double getAgi(){return agi.get();}

	public void setAgi(double agi){this.agi.set(agi);}

	public DoubleProperty agiProperty(){return agi;}


	public String getCreatedDate(){return createdDate.get();}

	public void setCreatedDate(String createdDate){this.createdDate.set(createdDate);}

	public StringProperty createdDateProperty(){return createdDate;}


	public double getAddctc(){return addctc.get();}

	public void setAddctc(double addctc){this.addctc.set(addctc);}

	public DoubleProperty addctcProperty(){return addctc;}


	public String getPoundSavingsBonds(){return poundSavingsBonds.get();}

	public void setPoundSavingsBonds(String poundSavingsBonds){this.poundSavingsBonds.set(poundSavingsBonds);}

	public StringProperty poundSavingsBondsProperty(){return poundSavingsBonds;}


	public String getSavingsBonds(){return savingsBonds.get();}

	public void setSavingsBonds(String savingsBonds){this.savingsBonds.set(savingsBonds);}

	public StringProperty savingsBondsProperty(){return savingsBonds;}


	public double getEic(){return eic.get();}

	public void setEic(double eic){this.eic.set(eic);}

	public DoubleProperty eicProperty(){return eic;}


	public double getChildTaxCredit(){return childTaxCredit.get();}

	public void setChildTaxCredit(double childTaxCredit){this.childTaxCredit.set(childTaxCredit);}

	public DoubleProperty childTaxCreditProperty(){return childTaxCredit;}


	public double getEducationTaxCredit(){return educationTaxCredit.get();}

	public void setEducationTaxCredit(double educationTaxCredit){this.educationTaxCredit.set(educationTaxCredit);}

	public DoubleProperty educationTaxCreditProperty(){return educationTaxCredit;}


	public double getElderlyCredit(){return elderlyCredit.get();}

	public void setElderlyCredit(double elderlyCredit){this.elderlyCredit.set(elderlyCredit);}

	public DoubleProperty elderlyCreditProperty(){return elderlyCredit;}


	public double getTotalRespPayment(){return totalRespPayment.get();}

	public void setTotalRespPayment(double totalRespPayment){this.totalRespPayment.set(totalRespPayment);}

	public DoubleProperty totalRespPaymentProperty(){return totalRespPayment;}


	public double getTotalAdvptcRepayment(){return totalAdvptcRepayment.get();}

	public void setTotalAdvptcRepayment(double totalAdvptcRepayment){this.totalAdvptcRepayment.set(totalAdvptcRepayment);}

	public DoubleProperty totalAdvptcRepaymentProperty(){return totalAdvptcRepayment;}


	public double getAverageAdvptcPayment(){return averageAdvptcPayment.get();}

	public void setAverageAdvptcPayment(double averageAdvptcPayment){this.averageAdvptcPayment.set(averageAdvptcPayment);}

	public DoubleProperty averageAdvptcPaymentProperty(){return averageAdvptcPayment;}


	public double getTotalPtc(){return totalPtc.get();}

	public void setTotalPtc(double totalPtc){this.totalPtc.set(totalPtc);}

	public DoubleProperty totalPtcProperty(){return totalPtc;}


	public double getBalanceDue(){return balanceDue.get();}

	public void setBalanceDue(double balanceDue){this.balanceDue.set(balanceDue);}

	public DoubleProperty balanceDueProperty(){return balanceDue;}


	public boolean getItin(){return itin.get();}

	public void setItin(boolean itin){this.itin.set(itin);}

	public BooleanProperty itinProperty(){return itin;}


	public boolean getExemption7(){return exemption7.get();}

	public void setExemption7(boolean exemption7){this.exemption7.set(exemption7);}

	public BooleanProperty exemption7Property(){return exemption7;}


	public boolean getFullYearCoverage(){return fullYearCoverage.get();}

	public void setFullYearCoverage(boolean fullYearCoverage){this.fullYearCoverage.set(fullYearCoverage);}

	public BooleanProperty fullYearCoverageProperty(){return fullYearCoverage;}


	public boolean getForm8888(){return form8888.get();}

	public void setForm8888(boolean form8888){this.form8888.set(form8888);}

	public BooleanProperty form8888Property(){return form8888;}


	public boolean getScheduleA(){return scheduleA.get();}

	public void setScheduleA(boolean scheduleA){this.scheduleA.set(scheduleA);}

	public BooleanProperty scheduleAProperty(){return scheduleA;}


	public boolean getScheduleB(){return scheduleB.get();}

	public void setScheduleB(boolean scheduleB){this.scheduleB.set(scheduleB);}

	public BooleanProperty scheduleBProperty(){return scheduleB;}


	public boolean getScheduleC(){return scheduleC.get();}

	public void setScheduleC(boolean scheduleC){this.scheduleC.set(scheduleC);}

	public BooleanProperty scheduleCProperty(){return scheduleC;}


	public boolean getScheduleCEz(){return scheduleCEz.get();}

	public void setScheduleCEz(boolean scheduleCEz){this.scheduleCEz.set(scheduleCEz);}

	public BooleanProperty scheduleCEzProperty(){return scheduleCEz;}


	public boolean getScheduleD(){return scheduleD.get();}

	public void setScheduleD(boolean scheduleD){this.scheduleD.set(scheduleD);}

	public BooleanProperty scheduleDProperty(){return scheduleD;}


	public boolean getScheduleE(){return scheduleE.get();}

	public void setScheduleE(boolean scheduleE){this.scheduleE.set(scheduleE);}

	public BooleanProperty scheduleEProperty(){return scheduleE;}


	public boolean getScheduleF(){return scheduleF.get();}

	public void setScheduleF(boolean scheduleF){this.scheduleF.set(scheduleF);}

	public BooleanProperty scheduleFProperty(){return scheduleF;}


	public boolean getScheduleH(){return scheduleH.get();}

	public void setScheduleH(boolean scheduleH){this.scheduleH.set(scheduleH);}

	public BooleanProperty scheduleHProperty(){return scheduleH;}


	public boolean getScheduleR(){return scheduleR.get();}

	public void setScheduleR(boolean scheduleR){this.scheduleR.set(scheduleR);}

	public BooleanProperty scheduleRProperty(){return scheduleR;}


	public boolean getScheduleSetP(){return scheduleSetP.get();}

	public void setScheduleSetP(boolean scheduleSetP){this.scheduleSetP.set(scheduleSetP);}

	public BooleanProperty scheduleSetPProperty(){return scheduleSetP;}


	public boolean getScheduleSesP(){return scheduleSesP.get();}

	public void setScheduleSesP(boolean scheduleSesP){this.scheduleSesP.set(scheduleSesP);}

	public BooleanProperty scheduleSesPProperty(){return scheduleSesP;}


	public String getAgencyId(){return agencyId.get();}

	public void setAgencyId(String agencyId){this.agencyId.set(agencyId);}

	public StringProperty agencyIdProperty(){return agencyId;}


	public double getStateWithholding(){return stateWithholding.get();}

	public void setStateWithholding(double stateWithholding){this.stateWithholding.set(stateWithholding);}

	public DoubleProperty stateWithholdingProperty(){return stateWithholding;}


	public double getStateTaxLiability(){return stateTaxLiability.get();}

	public void setStateTaxLiability(double stateTaxLiability){this.stateTaxLiability.set(stateTaxLiability);}

	public DoubleProperty stateTaxLiabilityProperty(){return stateTaxLiability;}


	public double getAAmountTaxpayerIsPlanningToSave(){return aAmountTaxpayerIsPlanningToSave.get();}

	public void setAAmountTaxpayerIsPlanningToSave(double aAmountTaxpayerIsPlanningToSave){this.aAmountTaxpayerIsPlanningToSave.set(aAmountTaxpayerIsPlanningToSave);}

	public DoubleProperty aAmountTaxpayerIsPlanningToSaveProperty(){return aAmountTaxpayerIsPlanningToSave;}


}

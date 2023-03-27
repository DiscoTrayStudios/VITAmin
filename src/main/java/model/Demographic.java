package model;
import javafx.beans.property.*;
public class Demographic{
	private StringProperty clientId;
	private DoubleProperty taxYear;
	private StringProperty city;
	private StringProperty state;
	private StringProperty zip;
	private DoubleProperty primarySecondary60Plus;
	private StringProperty residency;
	public Demographic(){
		this.clientId = new SimpleStringProperty();
		this.taxYear = new SimpleDoubleProperty();
		this.city = new SimpleStringProperty();
		this.state = new SimpleStringProperty();
		this.zip = new SimpleStringProperty();
		this.primarySecondary60Plus = new SimpleDoubleProperty();
		this.residency = new SimpleStringProperty();
	}
	public String getClientId(){return clientId.get();}

	public void setClientId(String clientId){this.clientId.set(clientId);}

	public StringProperty clientIdProperty(){return clientId;}


	public double getTaxYear(){return taxYear.get();}

	public void setTaxYear(double taxYear){this.taxYear.set(taxYear);}

	public DoubleProperty taxYearProperty(){return taxYear;}


	public String getCity(){return city.get();}

	public void setCity(String city){this.city.set(city);}

	public StringProperty cityProperty(){return city;}


	public String getState(){return state.get();}

	public void setState(String state){this.state.set(state);}

	public StringProperty stateProperty(){return state;}


	public String getZip(){return zip.get();}

	public void setZip(String zip){this.zip.set(zip);}

	public StringProperty zipProperty(){return zip;}


	public double getPrimarySecondary60Plus(){return primarySecondary60Plus.get();}

	public void setPrimarySecondary60Plus(double primarySecondary60Plus){this.primarySecondary60Plus.set(primarySecondary60Plus);}

	public DoubleProperty primarySecondary60PlusProperty(){return primarySecondary60Plus;}


	public String getResidency(){return residency.get();}

	public void setResidency(String residency){this.residency.set(residency);}

	public StringProperty residencyProperty(){return residency;}


}

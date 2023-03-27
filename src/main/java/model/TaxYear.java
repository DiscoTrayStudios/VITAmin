package model;
import javafx.beans.property.*;
public class TaxYear{
	private IntegerProperty taxYear;
	public TaxYear(){
		this.taxYear = new SimpleIntegerProperty();
	}
	public int getTaxYear(){return taxYear.get();}

	public void setTaxYear(int taxYear){this.taxYear.set(taxYear);}

	public IntegerProperty taxYearProperty(){return taxYear;}


}

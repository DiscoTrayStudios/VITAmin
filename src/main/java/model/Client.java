package model;
import javafx.beans.property.*;
public class Client{
	private StringProperty id;
	private StringProperty sidn;
	private StringProperty l4SSN;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty doB;
	private StringProperty efin;
	public Client(){
		this.id = new SimpleStringProperty();
		this.sidn = new SimpleStringProperty();
		this.l4SSN = new SimpleStringProperty();
		this.firstName = new SimpleStringProperty();
		this.lastName = new SimpleStringProperty();
		this.doB = new SimpleStringProperty();
		this.efin = new SimpleStringProperty();
	}
	public String getId(){return id.get();}

	public void setId(String id){this.id.set(id);}

	public StringProperty idProperty(){return id;}


	public String getSidn(){return sidn.get();}

	public void setSidn(String sidn){this.sidn.set(sidn);}

	public StringProperty sidnProperty(){return sidn;}


	public String getL4SSN(){return l4SSN.get();}

	public void setL4SSN(String l4SSN){this.l4SSN.set(l4SSN);}

	public StringProperty l4SSNProperty(){return l4SSN;}


	public String getFirstName(){return firstName.get();}

	public void setFirstName(String firstName){this.firstName.set(firstName);}

	public StringProperty firstNameProperty(){return firstName;}


	public String getLastName(){return lastName.get();}

	public void setLastName(String lastName){this.lastName.set(lastName);}

	public StringProperty lastNameProperty(){return lastName;}


	public String getDoB(){return doB.get();}

	public void setDoB(String doB){this.doB.set(doB);}

	public StringProperty doBProperty(){return doB;}


	public String getEfin(){return efin.get();}

	public void setEfin(String efin){this.efin.set(efin);}

	public StringProperty efinProperty(){return efin;}


}

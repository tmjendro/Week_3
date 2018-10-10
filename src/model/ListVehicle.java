package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class ListVehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="license")
	private String license;
	@Column(name="productionYear")
	private int productionYear;
	@Column(name="make")
	private String make;
	@Column(name="model")
	private String model;
	
	public ListVehicle() {
		
	}
	public ListVehicle(String license, int productionYear, String make, String model) {
		this.license=license;
		this.productionYear=productionYear;
		this.make=make;
		
		this.model=model;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "ListVehicle [license=" + license + ", year=" + productionYear + ", make=" + make + ", model=" + model + "]";
		
	}
	public String returnVehicleDetails() {
		return "Plate#: " + license + ", Year" + ": " +productionYear+ ", Make:" + make + ", Model:" + model ;
	}
}

package ar.com.greenleave.pyme_managment.view.dto;

public class CountryDTO {

	private Long id;
	private String country;
	private String countryCode;
	private String codPhone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCodPhone() {
		return codPhone;
	}

	public void setCodPhone(String codPhone) {
		this.codPhone = codPhone;
	}

	public String toString() {
		return "Country [id=" + this.id.toString() + ", country=" + this.country + ", countryCode=" + this.countryCode
				+ ", codPhone=" + this.codPhone + "]";
	}

}

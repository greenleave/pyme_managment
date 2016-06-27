package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.GestionCliente;



public class PhoneDTO {

	private Long id;

	private String phone;

	private TypeOfPhoneDTO typePhone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public TypeOfPhoneDTO getTypePhone() {
		return typePhone;
	}

	public void setTypePhone(TypeOfPhoneDTO	 typePhone) {
		this.typePhone = typePhone;
	}

}

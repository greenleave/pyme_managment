package ar.com.greenleave.pyme_managment.pymeManagmentDesktop.viewDesktop.DTO.GestionCliente;



public enum TypeOfTransactionDTO {
	/**
	 * Se utilizan para las compras y ventas que se realizan y no pertenecen al rubro o negocio habitual
	 */
	COMPRA,
	VENTA,
	/**
	 * Se utilizan para los pagos y los cobros que se realizan
	 */
	PAGO,
	COBRO,
	
	/**
	 * Se utilizan para las compras y ventas que se realizan y pertenecen al rubro o negocio habitual
	 */
	COMPRA_PROVEEDOR,
	VENTA_CLIENTE,
	
	/**
	 * Se utilizan para notificar que hubo una perdida o una ganancia (En esto ando medio flojo)
	 */
	PERDIDA,
	GANANCIA;
	
}

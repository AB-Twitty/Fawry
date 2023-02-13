package FawrySystem.Models;

import FawrySystem.Enums.PaymentMethodType;

public class TransactionRequest {

	private int serviceId;
	private PaymentMethodType paymentType;
	private int paymentId;
	
	public TransactionRequest(int serviceId, PaymentMethodType paymentType, int paymentId) {
		this.paymentType = paymentType;
		this.serviceId = serviceId;
		this.paymentId = paymentId;
	}
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	
	public void setPaymentType(PaymentMethodType paymentType) {
		this.paymentType = paymentType;
	}
	
	public int getServiceId() {
		return this.serviceId;
	}
	
	public PaymentMethodType getPaymentType() {
		return this.paymentType;
	}
}

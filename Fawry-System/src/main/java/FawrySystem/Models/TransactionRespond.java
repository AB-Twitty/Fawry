package FawrySystem.Models;

import java.util.Date;

import FawrySystem.Enums.PaymentMethodType;
import FawrySystem.Enums.TransactionStatus;

public class TransactionRespond {

	private int id;
	private int userId;
	private int serviceId;
	private PaymentMethodType paymentType;
	private Date creationDate;
	private Date lastModifiedDate;
	private TransactionStatus status;
	private double fees = 1.5;
	private double totalAmount;
	private int paymentId;
	private IPaymentMethod payment;
	
	public TransactionRespond(int serviceId, PaymentMethodType paymentType) {
		super();
		this.serviceId = serviceId;
		this.paymentType = paymentType;
	}
	
	public IPaymentMethod getPayment() {
		return payment;
	}

	public void setPayment(IPaymentMethod payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public PaymentMethodType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentMethodType paymentType) {
		this.paymentType = paymentType;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public TransactionStatus getStatus() {
		return status;
	}
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getPaymentId() {
		return this.paymentId;
	}
	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
}

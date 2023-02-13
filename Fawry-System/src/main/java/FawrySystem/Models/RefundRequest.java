package FawrySystem.Models;

import FawrySystem.Enums.RefundStatus;

public class RefundRequest {

	private int id;
	private RefundStatus status;
	
	public RefundRequest(int id, RefundStatus status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RefundStatus getStatus() {
		return status;
	}
	public void setStatus(RefundStatus status) {
		this.status = status;
	}
}

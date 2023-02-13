package FawrySystem.Repositories.Interfaces;

import java.util.List;

import FawrySystem.Enums.RefundStatus;
import FawrySystem.Models.RefundRespond;

public interface IRefundRepository {

	public RefundRespond Create(RefundRespond refund);
	
	public RefundRespond GetById(int id);
	
	public List<RefundRespond> GetByUserId(int userId);
	
	public List<RefundRespond> GetByStatus(RefundStatus status);
}

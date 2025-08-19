
public class LeaveRequest {
	protected int requestId;
	protected Employee employee;
	protected String startDate;
	protected String endDate;
	protected String status; // "Pending", "Approved", "Denied"

	public LeaveRequest() {
		this.requestId = 0000;
		this.employee = null;
		this.startDate = null;
		this.endDate = null;
		this.status = "pending"; // Default
	}

	public LeaveRequest(int requestId, Employee employee, String startDate, String endDate, String status) {
		this.requestId = requestId;
		this.employee = employee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = "pending"; // Default
	}
	
	public boolean processRequest() {
		System.out.println("Processing generic leave request...");
		return true;
	}

}



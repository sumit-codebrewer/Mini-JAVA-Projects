package onlineSeminar;

public class Participant {
	//Participant Data required during Registration
	private String participantName;
	private int enrollmentNumber;
	private int batchYear;
	private String email;
	private String branch;
	public Participant(String participantName,int enrollmentNumber, int batchYear, String email, String branch) {
		this.participantName = participantName;
		this.enrollmentNumber=enrollmentNumber;
		this.batchYear = batchYear;
		this.email = email;
		this.branch = branch;
	}
	public String getParticipantName() {
		return participantName;
	}
	public int getBatchYear() {
		return batchYear;
	}
	public String getEmail() {
		return email;
	}
	public String getBranch() {
		return branch;
	}
	public int getEnrollmentNumber()
	{
		return this.enrollmentNumber;
	}
	//New instance for each participant
	public Participant registerParticipant(String participantName,int enrollmentNumber,int branchYear,String email,String branch)
	{
		return new Participant(participantName,enrollmentNumber, branchYear, email, branch);
	}
	

}

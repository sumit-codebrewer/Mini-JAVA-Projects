package onlineSeminar;
import java.util.ArrayList;
public class Registration {
	//ArrayList for the participants
	private ArrayList<Participant> participants=new ArrayList<Participant>();
	private String eventName;
	
	public Registration(String eventName) {
		this.participants = new ArrayList<Participant>();
		this.eventName = eventName;
	}
	//Registering a new participant
	public boolean registerParticipant(Participant participant)
	{
		int position=checkAlreadyExistingParticipant(participant.getParticipantName());
		if(position>=0)
		{
			System.out.println(participant.getParticipantName()+" already exists in the Partcipants List...");
			return false;
		}
		this.participants.add(participant);
		return true;
	}
	private int checkAlreadyExistingParticipant(int enrollmentNumber)
	{
		for(int i=0;i<this.participants.size();i++)
		{
			Participant participant=participants.get(i);
			if(participant.getEnrollmentNumber()==enrollmentNumber)
			{
				return i;
			}
		}
		return -1;
	}
	//Overloading checkAlreadyExistingPartcipant for name and enrollment fields
	private int checkAlreadyExistingParticipant(String name)
	{
		for(int i=0;i<this.participants.size();i++)
		{
			Participant participant=participants.get(i);
			if(participant.getParticipantName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	private int checkList(Participant participant)
	{
		return participants.indexOf(participant);
	}
	//Updating any participant information
	public boolean updateParticipantInfo(Participant exisingParticipant,Participant updatedParticipant)
	{
		int position=checkList(exisingParticipant);
		if(position<0)
		{
			System.out.println("Mentioned participant is not found in the participant list!!!");
			return false;
		}
		this.participants.set(position, updatedParticipant);
		return true;
	}
	//Removing a participant from the list
	public boolean removeParticipant(Participant participant)
	{
		int position=checkAlreadyExistingParticipant(participant.getParticipantName());
		if(position<0)
		{
			System.out.println(participant.getParticipantName()+" is not found in the Participants List...");
			return false;
		}
		this.participants.remove(participant);
		return true;
	}
	public Participant searchParticipant(String participantName)
	{
		int position=checkAlreadyExistingParticipant(participantName);
		if(position>=0)
		{
			return participants.get(position);
		}
		return null;
	}
	//Printing all the particpants in the list
	public void printParticipants()
	{
		System.out.println("\t\t^^^^^^^^^^^^^^^^^^^^^Participants list^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		for(int i=0;i<participants.size();i++)
		{
			System.out.println("\t\t"+(i+1)+". "+participants.get(i).getParticipantName()+"     "+participants.get(i).getEnrollmentNumber()
					+"     "+participants.get(i).getEmail()+"     "+participants.get(i).getBranch()+"     "+participants.get(i).getBatchYear());
		}
	}

}

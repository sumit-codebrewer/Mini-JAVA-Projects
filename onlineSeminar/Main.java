package onlineSeminar;
import java.util.Scanner;
public class Main {
	private static Scanner sc=new Scanner(System.in);
	private static Registration registration=new Registration("Future of Java Programming Language");
	public static void main(String[] args) {
		boolean attending=true;
		openPortalOptions();  //Method call for choosing option in the beginning
		int choice;
		while(attending)
		{
			System.out.println("\nEnter any of the options:");
			choice=sc.nextInt();
			switch(choice)
			{
				case 0:System.out.println("\n\n\t----------------------------------Closing the Portal--------------------------------------");
					   attending=false;
				       break;
				case 1:registerParticipant();
				       break;
				case 2:updateParticipant();
				       break;
				case 3:searchParticipant();
				       break;
				case 4:removeParticipant();
				       break;
				case 5:registration.printParticipants();
				       break;
				case 6:openPortalOptions();
				       break;
			    default:System.out.println("\tWrong choice!!!");
			}
		}

	}
	public static void openPortalOptions()
	{
		System.out.println("\t********************WELCOME TO THE REGISTRATION OF THE ONLINE SEMINAR*****************");
		System.out.println("\tPress");
		System.out.println("\t\t 0-> To Exit The Registration Portal");
		System.out.println("\t\t 1-> To Register A New Participant");
		System.out.println("\t\t 2-> To Update An Existing Participant");
		System.out.println("\t\t 3-> To Search for A Partcipant Information");
		System.out.println("\t\t 4->To Remove A Participant");
		System.out.println("\t\t 5->To Print All The Participants In The List");
		System.out.println("\t\t 6->To Print the Portal Options");
		System.out.println("\t****************************************************************************************");
	}
	public static void registerParticipant()
	{
		System.out.println("Enter participant name:");
		String participantName=sc.next();
		System.out.println("Enter enrollment number:");
		int enrol=sc.nextInt();
		System.out.println("Enter email id:");
		String email=sc.next();
		System.out.println("Enter branch:");
		String branch=sc.next();
		System.out.println("Enter batch year:");
		int batchYear=sc.nextInt();
		//New Instance for each participant
		Participant participant=new Participant(participantName, enrol, batchYear, email, branch);  
		if(registration.registerParticipant(participant))
		{
			System.out.println(participantName+" has succesfully resistered for the online seminar");
		}
	}
	public static void updateParticipant()
	{
		System.out.println("Enter existing participant name:");
		String name=sc.next();
		Participant existingParticipant=registration.searchParticipant(name);
		if(existingParticipant==null)
		{
			System.out.println(name+" is not registered for the seminar!!!");
			return;
		}
		System.out.println("\n\n\t\tUpdating....");
		System.out.println("Enter new name:");
		String participantName=sc.next();
		System.out.println("Enter new enrollment number:");
		int enrol=sc.nextInt();
		System.out.println("Enter new email id:");
		String email=sc.next();
		System.out.println("Enter branch:");
		String branch=sc.next();
		System.out.println("Enter batch year:");
		int batchYear=sc.nextInt();
		Participant newParticipant=new Participant(participantName, enrol, batchYear, email, branch);
		if(registration.updateParticipantInfo(existingParticipant, newParticipant))
		{
			System.out.println(existingParticipant.getParticipantName()+" is updated with new entries...");
		}
		else
		{
			System.out.println("Error in updating this participant details!!!");
		}
	}
	public static void removeParticipant()
	{
		System.out.println("Enter participant name to be removed:");
		String name=sc.next();
		Participant existingParticipant=registration.searchParticipant(name);
		if(existingParticipant==null)
		{
			System.out.println(name+" is not registered for the seminar!!!");
			return;
		}
		if(registration.removeParticipant(existingParticipant))
		{
			System.out.println(existingParticipant.getParticipantName()+" is succesfullt removed from the participants list...");
		}
		else
		{
			System.out.println("Error in removing participant!!!");
		}
	}
	public static void searchParticipant()
	{
		System.out.println("Enter participant name you want to search:");
		String name=sc.next();
		Participant existingParticipant=registration.searchParticipant(name);
		if(existingParticipant==null)
		{
			System.out.println(name+" is not registered for the seminar!!!");
			return;
		}
		System.out.println("\t\t****************Participant Info********************");
		System.out.println("\t\tName:"+existingParticipant.getParticipantName());
		System.out.println("\t\tEnrollment number:"+existingParticipant.getEnrollmentNumber());
		System.out.println("\t\tEmail:"+existingParticipant.getEmail());
		System.out.println("\t\tBranch:"+existingParticipant.getBranch());
		System.out.println("\t\tBatch Year:"+existingParticipant.getBatchYear());
		System.out.println("\t\t*****************************************************");
	}

}

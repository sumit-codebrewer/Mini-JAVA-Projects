package addContactDialog;

import datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddDialogController {

	@FXML
	private TextField firstNameField;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private TextField phoneNumberField;
	
	@FXML
	private TextField notesField;
	
	public Contact getNewContact() {
		String firstName=firstNameField.getText();
		String lastName=lastNameField.getText();
		String phoneNumber=phoneNumberField.getText();
		String notes=notesField.getText();
		
		Contact newContact=new Contact(firstName, lastName, phoneNumber, notes);
		return newContact;
	}
	
	public void editContact(Contact existingContact) {
		firstNameField.setText(existingContact.getFirstName());
		lastNameField.setText(existingContact.getLastName());
		phoneNumberField.setText(existingContact.getPhoneNumber());
		notesField.setText(existingContact.getNotes());
	}
	
	public void updateContact(Contact contact) {
		contact.setFirstName(firstNameField.getText());
		contact.setLastName(lastNameField.getText());
		contact.setPhoneNumber(phoneNumberField.getText());
		contact.setNotes(notesField.getText());
	}
}

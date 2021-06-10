package application;

import java.io.IOException;
import java.util.Optional;

import addContactDialog.AddDialogController;
import datamodel.Contact;
import datamodel.ContactData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class SampleController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private TableView<Contact> contactsTable;

    private ContactData data;

    public void initialize() {
        data = new ContactData();
        data.loadContacts();
        contactsTable.setItems(data.getContacts());
    }

    @FXML
    public void showAddDialog() {
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/addContactDialog/AddDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            AddDialogController contactController = fxmlLoader.getController();
            Contact newContact = contactController.getNewContact();
            data.addContact(newContact);
            data.saveContacts();


        }
    }
    
    @FXML
    public void showEditDialog() {
    	Contact selectedContact=contactsTable.getSelectionModel().getSelectedItem();
    	if(selectedContact==null) {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("No Contact selected");
    		alert.setHeaderText(null);
    		alert.setContentText("Select the contact you want to edit");
    		alert.showAndWait();
    	}
    	Dialog<ButtonType> dialog=new Dialog<ButtonType>();
    	dialog.initOwner(mainPane.getScene().getWindow());
    	dialog.setTitle("Edit Contact");
    	FXMLLoader fxmlLoader=new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("/addContactDialog/AddDialog.fxml"));
    	try {
    		dialog.getDialogPane().setContent(fxmlLoader.load());
    	}
    	catch(Exception e) {
    		System.out.println("Could 'nt load the dialog");
    		e.printStackTrace();
    	}
    	
    	dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
    	dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
    	
    	AddDialogController controller=fxmlLoader.getController();
    	controller.editContact(selectedContact);
    	
    	Optional<ButtonType> result=dialog.showAndWait();
    	if(result.isPresent() && result.get()==ButtonType.OK) {
    		controller.updateContact(selectedContact);
    		data.saveContacts();
    	}
    	
    }
    
    @FXML
    public void deleteContact() {
    	Contact selectedContact=contactsTable.getSelectionModel().getSelectedItem();
    	if(selectedContact==null) {
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("No Contact selected");
    		alert.setHeaderText(null);
    		alert.setContentText("Select the contact you want to delete");
    		alert.showAndWait();
    		return;
    	}
    	Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Delete Contact");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to delete the selected contact=>"+
				selectedContact.getFirstName()+" "+selectedContact.getLastName());
		
		Optional<ButtonType> result=alert.showAndWait();
		if(result.isPresent() && result.get()==ButtonType.OK) {
			data.deleteContact(selectedContact);
			data.saveContacts();
		}
    	
    	
    }
}

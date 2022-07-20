package sg.edu.nus.iss.day13workshop.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day13workshop.models.Contact;

@Service
public class DatabaseService {

    private File dataDir = new File("some directory");

    public File getDataDir () {
        return dataDir;
    }

    public Void setDataDir(File dataDir) {
        this.dataDir = dataDir;
        return null;
    }

    // /Users/username/data
    // /home/data
    public boolean isDataDirValid() {
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }

    public boolean save(final Contact contact) {
		File f = new File(this.dataDir, contact.getId());
        try (OutputStream out = new FileOutputStream(f)) {
            PrintWriter pw = new PrintWriter(out);
            pw.println(contact.getId());
            pw.println(contact.getName());
            pw.println(contact.getEmail());
            pw.println(contact.getPhone());
            return true;

        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
        }
        return false;

	}
	public Contact read(String fileId) {

        try {

        File f = new File(this.dataDir, fileId);
        Scanner myReader = new Scanner(f);
        while (myReader.hasNextLine()) {
            System.out.println(myReader.nextLine());
        }
        myReader.close();

        Contact contact = new Contact();
            return contact;


        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
            ex.printStackTrace();
            return null;
		
	}

}
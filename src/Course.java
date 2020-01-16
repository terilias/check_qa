/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020
 * Αυτή η κλάση αναπαριστά το μάθημα, με τα δεδομένα που παίρνονται από το xml αρχείο με τα μαθήματα και του περιεχομένου της σελίδας
 * περιγραφής τους στο qa.auth.gr.
 */
public class Course {
    private String name;//όνομα μαθήαμτος
    private String description;//περιεχόμενο της σελίδας περιγραφής μαθήματος

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020
 * Αυτή η κλάση είναι υπεύθυνη για το άνοιγμα των αρχείων εισόδου: το αρχείο xml και το αρχείο με τα πεδία περιγραφής μαθήματος που είναι προς έλεγχο.
 * Επίσης υλοποιεί την έξοδο των αποτελεσμάτων σε αρχείο. */
public class File {
    private  XMLParserSAX parser;//αντικείμενο της κλάσης parser στο οποίο περνάμε το μονοπάτι του αρχείο εισόδου xml για την SAX ανάλυσή του.
    private String xml;//το μονοπάτι προς το αρχείο xml
    private Controller ctrl;//αντικείμενο της κλάσης Controller που είναι απαραίτητο για τους ελέγχους
    private ArrayList<String> fields;//ο πίνακας με τα πεδία για τα οποία γίνεται ο έλεγχος του εάν υπάρχουν στην σελίδα περιγραφής των μαθημάτων
    private ArrayList<Boolean> exist;/*Arraylist με μέγεθος ίσο με τον αριθμό των πεδίων για τα οποία γίνεται έλλεγχος.Εάν το
    πεδίο i δεν υπάρχει στην περιγραφή του μαθήματος , αυτός ο πίνακας έχει στη θέση i τιμή false.*/



    /**
     * Μέθοδος για την εξαγωγή των αποτελεσμάτων ελέγχου-η οποία γίνεται στην κλάση Controller- σε αρχείο κειμένου.
     * Για κάθε αντικείμενο μαθήματος το οποίο δεν περιέχει έστω και ένα από τα πεδία προς έλεγχο στην σελίδα περιγραφής του, εμφανίζονται τα πεδία που παρουσιάζει έλλειψη.
     * @param fieldsFileName το όνομα του αρχείου εισόδου με τα πεδία προς έλεγχο
     */
    public void writeToFile(String fieldsFileName) {
        try {
             ctrl=new Controller();//δημιουργία του αντικειμένου του ελεγκτή Controller που θα χρησιμοποιηθεί εδώ
             fields=getDescriptionFields(fieldsFileName);//ο πίνακας με τα πεδία για τα οποία γίνεται ο έλεγχος
             exist=new ArrayList<>();//πίνακας με τα αποτελέσματα των ελέγχων.Το περιεχόμενό του αλλάζει δυναμικά για κάθε αντικείμενο Course
             List<Course> crs=readXML();//η λίστα με τα αντικείμενα τύπου Course
             BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));//ο συγγραφέας του αρχείου εξόδου
             int counter=0;//μετρητής που αυξάνει κάθε φορά που εμφανίζεται μάθημα με έλλειψη σε πεδίο
             for(int j=0;j<crs.size();j++) {
                 //για κάθε αντικείμενο Course γίνονται οι έλεγχοι και η εκτύπωση των αποτελεσμάτων στο αρχείο εξόδου
                 exist=ctrl.check(fields,crs.get(j));//ο πίνακας με τα αποτελέσματα ελέγχου ύπαρξης των πεδίων στην περιγραφή του μαθήματος γεμίζει.Ο έλεγχος γίνεται στην κλάση Controller
                 if(ctrl.hasEmptyField(exist)) {
                     counter++;//αύξηση του μετρητή των μαθημάτων που οι περιγραφές τους χρήζουν βελτίωσης
                     //θα γίνει εκτύπωση, μόνο αν το συγκεκριμένο Cource έχει έλλειψη σε έστω κι ένα πεδίο περιγραφής μαθημάτων.
                     bw.write("Το μάθημα: <<" + crs.get(j).getName() + ">> δεν περιέχει τα πεδία: ");
                     for (int i = 0; i < fields.size(); i++) {
                        if(exist.get(i)==false)
                         bw.write(" '"+fields.get(i)+"' ");
                     }
                      bw.write(" στην σελίδα περιγραφής του. ");
                      bw.write(System.lineSeparator());//η επόμενη εκτύπωση θα γίνει στην επόμενη γραμμή
                 }

             }
             if(counter==0){
                 //εάν κανένα μάθημα δεν έχει έλλειψη στο αρχείο γράφεται το ακόλουθο μήνυμα:
                 bw.write("Όλα τα μαθήματα έχουν πλήρεις περιγραφές.Συγχαρητήρια!");
             }
            bw.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Μέθοδος που καλεί την κατάλληλη μέθοδο της κλάσης XMLParserSAX για την ανάγνωση του xml από το οποίο αντλεί τα δεδομένα των μαθημάτων.
     * @return η λίστα με τα αντικείμενα
     */
    public List<Course> readXML(){
        parser = new XMLParserSAX();
        return parser.getCourses(xml);//μέσα από την κλάση XMLParser στην οποία στέλνεται το  μονοπάτι προς το αρχείο xml παίρνουμε τα μαθήματα
    }
    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    /**
     * Η μέθοδος αυτή διαβάζει το αρχείο κειμένου που περιέχει τα πεδία της περιγραφής του μαθήματος, για τα οποία θέλουμε να γίνει έλεγχος (αν υπάρχουν ή όχι στην περιγραφή του μαθήματος).
     * @param fields το όνομα του αρχείου εισόδου που περιέχει τα πεδία προς έλεγχο
     * @return ArrayList με τα πεδία αυτά
     * @throws IOException σε περίπτωση που δεν υπάρχει το αρχείο
     */
    public ArrayList<String> getDescriptionFields(String fields) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fields));
        String st;
        ArrayList<String> descrFields=new ArrayList<>();
        while ((st = br.readLine()) != null) {
             descrFields.add(st);
       }
        return descrFields;

    }

}

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020
 * Αυτή η κλάση αναλαμβάνει το άνοιγμα του αρχείου xml και χρησιμοποιώντας τις μεθόδους της κλάσης MyHandler
 * και των πακέτων διαχείρισης xml της java παίρνει τα δεδομένα από αυτό.
 */
public class XMLParserSAX {

    List<Course> courses;//λίστα από αντικείμενα τύπου Course .Σε αυτήν θα αποθηκευθούν τα δεδομένα του xml.

    /**
     * Η μέθοδος parse ανοίγει το xml αρχείο και περνάει τα δεδομένω των κόμβων του στον πίνακα με τα courses.
     * Επειδή το εργαλείο DeiXTo όταν δημιουργεί το xml , δημιουργεί κενούς κόμβους, επιστρέφει στην crsList και αντικείμενα με κενά πεδία.
     * Οπότε μέσα στον βρόχο for ουσιαστικά "κοσκινίζουμε" αυτή την λίστα και γεμίζουμε την λίστα courses μόνο με τα αντικείμενα που έχουν τιμές στα πεδία τους (δηλαδή
     * δεν είναι κενοί κόμβοι στο xml αλλά έχουν δεδομένα μέσα στα tag).
     * Ο χειρισμός εξαιρέσεων είναι υποχρεωτικός για την εργασία του SAX parsing .
     * @param path το μονοπάτι προς το xml αρχείο
     */
    private void parse(String path) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse(new File(path+".xml"), handler);
            //παίρνει την Courses list από την κλάση MyHandler .Αυτή περιέχει κενά αντικείμενα
            List<Course> crsList = handler.getCourseList();
            //δημιουργία της λίστας με τα courses.Εδώ θαμπουν τα έγκυρα δεδομένα, δηλ. τα μη κενά αντικείμενα
            courses = new ArrayList<>();
           /*στον βρόχο for  γεμίζουμε την λίστα courses μόνο με τα αντικείμενα
           που έχουν τιμές στα πεδία τους (δηλαδή δεν είναι κενοί κόμβοι στο xml αλλά έχουν δεδομένα μέσα στα tag). */
            for (int i = 0; i < crsList.size(); i++) {
                if (!crsList.get(i).getName().equals(""))//εάν το αντικείμενο δεν είναι κενό, βάλτο μέσα στην λίστα courses
                    courses.add(crsList.get(i));

            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Δέχεται ως είσοδο το μονοπάτι στο αρχείο xml με τα δεδομένα των μαθημάτων και επιστρέφει μία λίστα
     * από αντικείμενα Courses . Καλεί την βασική μέθοδο αυτής της κλάσης, δηλαδή την μέθοδο parse που είναι υπεύθυνη για το άνοιγμα του xml
     * και την συλλογή των δεδομένων από αυτό.
     * @param path το μονοπάτι στο αρχείο xml με τα δεδομένα των μαθημάτων
     * @return λίστα από αντικείμενα Courses .
     */
    public List<Course> getCourses(String path) {
        parse(path);
        return courses;
    }
}

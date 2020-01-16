import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020
 * Αυτή η κλάση είναι τυποποιημένη υλοποίηση του Handler για το SAX parsing.
 * Για αυτό τον λόγο και υπάρχει έλλειψη τεκμηρίωσης.
 * Για μια αναλυτική περιγραφή με τον κώδικα και παραδείγματα, ανατρέξτε στον ακόλουθο σύνδεσμο:
 *     https://www.journaldev.com/1198/java-sax-parser-example
 */
public class MyHandler extends DefaultHandler {

    // List to hold Course object
    private List<Course> courseList = null;
    private Course crs = null;
    private StringBuilder data = null;

    // getter μέθοδος για την λίστα course
    public List<Course> getCourseList() {
        return courseList;
    }


    boolean bName = false;
    boolean bDescription = false;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("item")) {
            // δημιουργία νέου αντικειμένου Course
            crs = new Course();

            // αρχικοποίηση της λίστας
            if (courseList == null)
                courseList = new ArrayList<>();

            // θέσιμο των  boolean για τα πεδία, θα χρησιμοποιηθεί στο θέσιμο των πεδίων του αντικειμένου course
        }
        else if (qName.equalsIgnoreCase("course")) {
            //το tag "course"
            bName = true;
        }
        else if (qName.equalsIgnoreCase("course_description")) {
            //το tag "course_description"
            bDescription = true;
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            // θέσιμο του ονόματος του μαθήματος στο αντικείμενο course
            crs.setName(data.toString());
            bName = false;
        } else if (bDescription) {
             // θέσιμο της περιγραφής του μαθήματος στο αντικείμενο course
            crs.setDescription(data.toString());
            bDescription = false;
        }

            if (qName.equalsIgnoreCase("item")) {
                // προσθήκη του αντικειμένου στην λίστα με τα courses
                courseList.add(crs);
            }
        }


    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

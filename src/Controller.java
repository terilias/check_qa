import java.util.ArrayList;

/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020 Σε αυτή την κλάση γίνεται ο έλεγχος για την πληρότητα των πληροφοριών στην
 * σελίδα περιγραφής του μαθήματος.
 */
public class Controller {

    private ArrayList<Boolean> exist;//Arraylist με μέγεθος ίσο με τον αριθμό των πεδίων για τα οποία γίνεται έλλεγχος.Εάν το
    //πεδίο i δεν υπάρχει στην περιγραφή του μαθήματος , αυτός ο πίνακας έχει στη θέση i τιμή false.

    /**
     * Η μέθοδος ελέγχου έλλειψης περιεχομένου στις περιγραφές των μαθημάτων. Για το μάθημα
     * ελέγχεται εάν το κάθε πεδίο υπάρχει μέσα στην περιγραφή του.Ανάλογα με το αν υπάρχει ή όχι,
     * γεμίζει έναν boolean πίνακα που είναι παράλληλος με τον πίνακα των πεδίων και περιέχει το
     * αποτέλεσμα του ελέγχου για αυτό το πεδίο .Αυτός ο πίνακας είναι που επιστρέφεται.
     *
     * @param fields ο έλεγχος θα γίνει για το αν υπάρχουν τα πεδία fields στην περιγραφή του
     *               μαθήματος
     * @param course το μάθημα για το οποίο γίνεται ο έλεγχος
     * @return τον boolean πίνακα με τα αποτελέσματα ελέγχου
     */
    public ArrayList<Boolean> check(ArrayList<String> fields, Course course) {

        exist = new ArrayList<>();//δημιουργία του πίνακα exist
        for (int j = 0; j < fields.size(); j++) {
            if (!course.getDescription().contains(fields.get(j))) {
                exist.add(false);
            } else {
                exist.add(true);
            }
        }

        return exist;

    }

    public boolean hasEmptyField(ArrayList<Boolean> exist) {
        for (int i = 0; i < exist.size(); i++) {
            if (exist.get(i) == false) {
                return true;
            }
        }
        return false;
    }

}
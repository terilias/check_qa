/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020 Εφαρμογή ελέγχου των σελίδων περιγραφής μαθημάτων, όπως αυτά παρουσιάζονται
 * στον ιστότοπο της Μονάδας Διασφάλισης Ποιότητας του Αριστοτελείου Πανεπιστημίου Θεσσαλονίκης:
 * https://qa.auth.gr/ Το αποθετήριο της εφαρμογής βρίσκεται στον ακόλουθο σύνδεσμο:
 * https://github.com/terilias/check_qa.git Για την διαχείριση του xml αρχείου , χρησιμοποιήθηκε
 * κώδικας από την σελίδα https://www.journaldev.com/1198/java-sax-parser-example Το παρών project
 * έγινε στο πλαίσιο του μαθήματος "Τεχνολογία Λογισμικού" (5ο εξάμηνο) του προπτυχιακού
 * προγράμματος σπουδών του τμήματος Πληροφορικής Α.Π.Θ. Το πρόγραμμα δέχεται ως είσοδο δύο αρχεία:
 * το πρώτο είναι τύπου xml και περιέχει το περιεχόμενο των ιστοσελίδων περιγραφής των μαθημάτων του
 * προγράμματος σπουδών του τμήματος.Το δεύτερο αρχείο περιέχει τα πεδία που θέλουμε να ελέγξουμε
 * εάν υπάρχουν στην σελίδα των μαθημάτων αυτών. Δημιουργεί το αρχείο εξόδου results.txt που σε κάθε
 * του γραμμή δηλώνονται τα πεδία που απουσιάζουν από την σελίδα.
 * <p>
 * Αυτή η κλάση εκκινεί την εκτέλεση της εφαρμογής.
 */
public class Start {

    /**
     * Η main μέθοδος του project δέχεται ως είσοδο από το τερματικό τα απαρίτητα ορίσματα: * 1)το
     * όνομα του αρχείου xml και * 2)το όνομα του αρχείου με τα πεδία που θα ελεγχθούν.
     *
     * @param args τα ορίσματα από την εκτέλεση του προγράμματος από την γραμμή εντολών.
     */
    public static void main(String[] args) {
        try {
            FileΜanager FileΜanager = new FileΜanager();
            FileΜanager.setXml(args[0]);
            FileΜanager.writeToFile(args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

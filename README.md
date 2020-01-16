# check_qa
   Εφαρμογή ελέγχου των σελίδων περιγραφής μαθημάτων, όπως αυτά παρουσιάζονται στον ιστότοπο  της Μονάδας Διασφάλισης Ποιότητας του Αριστοτελείου Πανεπιστημίου Θεσσαλονίκης: https://qa.auth.gr/
  
  
  Το παρών project έγινε στο πλαίσιο του μαθήματος "Τεχνολογία Λογισμικού" (5ο εξάμηνο) του προπτυχιακού προγράμματος σπουδών του τμήματος Πληροφορικής Α.Π.Θ.
  Ο σκοπός της εφαρμογής είναι να υποδυκνύει στο προσωπικό του τμήματος ποιά μαθήματα έχουν ελλείψεις στις περιγραφές τους, ώστε να ενημερώνονται οι υπεύθυνοι των μαθημάτων και να συμπληρώνουν την περιγραφή τους.
  Αυτό είναι ιδιαίτερα σημαντικό καθώς οι φοιτητές για να επιλέξουν τα μαθήματα που θα παρακολουθήσουν, χρειάζονται να γνωρίζουν π.χ. το περιεχόμενο του μαθήματος, τον τρόπο βαθμολόγησης και τις προαπαιτήσεις του. Εάν αυτά τα πεδία είναι κενά στις σελίδες περιγραφής των μαθημάτων, οι φοιτητές δεν μπορούν  να γνωρίζουν χρήσιμες πληροφορίες για τα μαθήματα και συνεπώς δυσκολεύονται περισσότερο για την επιλογή τους. 

 Το πρόγραμμα δέχεται ως είσοδο δύο αρχεία: το πρώτο είναι τύπου xml και περιέχει το περιεχόμενο των ιστοσελίδων περιγραφής των μαθημάτων του προγράμματος σπουδών του τμήματος.Το xml αρχείο είναι αρχείο εξόδου από το λογισμικό εξαγωγής περιεχομένου από  ιστοσελίδες  (web  data  extraction  tool) DeiXTo.To DeiXTo είναι λογισμικό ανοικτού κώδικα. Για περισσότερες πληροφορίες και για να κατεβάσετε το DeiXTo ανατρέξτε στην ιστοσελίδα του http://deixto.com/.
  Το δεύτερο αρχείο περιέχει τα πεδία για τα οποόια θέλουμε να κάνουμε τον έλεγχο ύπαρξής τους στην σελίδα περιγραφής των μαθημάτων (π.χ. "Erasmus" εάν θέλουμε να εξετάσουμε εάν στην περιγραφή υπάρχουν πληροφορίες για τους φοιτητές από το πρόγραμμα ανταλλαγής φοιτητών Erasmus). 
 Η εκτέλεση του προγράμματος με παραμέτρους εισόδου τα δύο παραπάνω αρχεία σε περιβάλλον γραμμής εντολών, δημιουργεί το αρχείο εξόδου results.txt που σε κάθε του γραμμή δηλώνονται τα πεδία που απουσιάζουν από την σελίδα περιγραφής για κάθε μάθημα.
 Για την δημιουργία αυτού του προγράμματος χρησιμοποιήθηκε η γλώσσα προγραμματισμού Java 8 και το περιβάλλον ανάπτυξης IntelliJ IDEA.
 

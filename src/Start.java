
/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020
 * Αυτή η κλάση εκκινεί την εκτέλεση της εφαρμογής.
 */
public class Start {

    public static  void main(String[] args){
        File file=new File();
        file.setXml("semester_1");
        file.writeToFile("πεδία");
    }
}

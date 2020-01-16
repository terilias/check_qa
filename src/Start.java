
/**
 * @author Ηλίας Τερζής
 * @version 1.0
 * @date Ιανουάριος 2020
 * Το αποθετήριο της εφαρμογή βρίσκεται στον ακόλουθο σύνδεσμο: https://github.com/terilias/check_qa.git
 * Αυτή η κλάση εκκινεί την εκτέλεση της εφαρμογής.
 */
public class Start {

    public static  void main(String[] args){
        try{
        File file=new File();
        file.setXml(args[0]);
        file.writeToFile(args[1]);
    }
        catch (Exception e){
           e.printStackTrace();
        }
    }
}

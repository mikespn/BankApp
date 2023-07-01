package gr.aube.cf.exceptions;

public class SsnNotValidException extends Exception{
    private static final long serialVersionUID = 1L;

    public SsnNotValidException(String ssn){
        super("Sss" + ssn + "is not valid");
    }
}

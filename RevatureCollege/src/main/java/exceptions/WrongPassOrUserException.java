package exceptions;

public class WrongPassOrUserException extends RuntimeException{
    public WrongPassOrUserException(){
        super("Incorrect Username or Password.");
    }
}

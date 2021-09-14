package exceptions;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){super("User Doesn't Exist.");}
}

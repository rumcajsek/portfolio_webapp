package pl.portfolio.webapp.nailsalon.exceptions;

import java.util.NoSuchElementException;

public class NoUserWithGivenEmailFountException extends NoSuchElementException {
    public NoUserWithGivenEmailFountException(String email) {
        super("No user with given email " + email + " found");
    }
}

package pl.portfolio.webapp.nailsalon.exceptions;

import java.util.NoSuchElementException;

public class NoUserRoleFoundException extends NoSuchElementException {
    public NoUserRoleFoundException() { super("No user role found"); }
}

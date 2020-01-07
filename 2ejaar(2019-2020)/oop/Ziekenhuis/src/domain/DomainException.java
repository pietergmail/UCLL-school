package domain;

import java.io.FileNotFoundException;

    public class DomainException extends RuntimeException {

        public DomainException(String s, FileNotFoundException ex) {
            super(s);
        }
    }



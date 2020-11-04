package ie.ait.agile.agileproject.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExceptionHandler extends RuntimeException {

    private final String message;

    public String getMessage() {
        return message;
    }

}

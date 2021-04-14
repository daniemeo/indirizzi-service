package it.sogei.svildep.indirizziservice.exception;

import it.sogei.svildep.indirizziservice.dto.MessageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@Getter
@Setter
@NoArgsConstructor
public
class SvildepException extends RuntimeException {

    private String message;
    private HttpStatus status;

    public SvildepException(String message, HttpStatus status) {
        this.setMessage(message);
        this.setStatus(status);
    }

    public SvildepException(String message) { this(message, HttpStatus.INTERNAL_SERVER_ERROR); }

    public SvildepException(MessageDto messageDto) { this(messageDto.getContent(), messageDto.getStatus()); }

    public SvildepException(BindingResult bindingResult) {
        this.setMessage(getErrorMessages(bindingResult));
        this.setStatus(HttpStatus.BAD_REQUEST);
    }

    public SvildepException(Exception ex) {
        this.setMessage(ex.getMessage());
    }

    private String getErrorMessages(BindingResult bindingResult) {
        StringBuilder messages = new StringBuilder();
        bindingResult.getFieldErrors().forEach(error -> {
            messages.append(error.getDefaultMessage()).append("\n");
        });
        return messages.toString();
    }
}
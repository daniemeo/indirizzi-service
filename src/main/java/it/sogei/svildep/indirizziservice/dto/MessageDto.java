package it.sogei.svildep.indirizziservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class MessageDto {

    private String content;

    private HttpStatus status;

    public boolean isError() { return this.getStatus().isError(); }
}
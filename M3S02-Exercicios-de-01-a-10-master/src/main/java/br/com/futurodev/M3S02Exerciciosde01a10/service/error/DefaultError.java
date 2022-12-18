package br.com.futurodev.M3S02Exerciciosde01a10.service.error;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DefaultError {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
}
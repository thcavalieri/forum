package br.com.thiagocavalieri.forum.validation;

import br.com.thiagocavalieri.forum.dto.MethodInputErrorDTO;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestControllerAdvice
public class ValidationErrorHandler {

    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected List<MethodInputErrorDTO> handle(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream().map(e ->
                new MethodInputErrorDTO(e.getField(), messageSource.getMessage(e, LocaleContextHolder.getLocale()))
        ).collect(Collectors.toList());
    }

}

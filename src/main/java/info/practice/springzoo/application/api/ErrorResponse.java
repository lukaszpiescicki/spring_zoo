package info.practice.springzoo.application.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    String code;
    String message;
}

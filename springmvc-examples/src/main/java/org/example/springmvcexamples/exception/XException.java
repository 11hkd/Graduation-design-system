package org.example.springmvcexamples.exception;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class XException extends RuntimeException{
private Code code;
private String number;
private String message;
}

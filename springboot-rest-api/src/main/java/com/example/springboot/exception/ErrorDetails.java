package com.example.springboot.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	private LocalDateTime timestatmp;
	private String message;
	private String path;
	private String errorCode;

}

package com.example.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

//	user firstName should not be null or Empty
	@NotEmpty(message = "user firstName should not be null or Empty")
	private String firstName;

//	user lastName should not be null or Empty
	@NotEmpty(message = "user lastName should not be null or Empty")
	private String lastName;

//	user Email should not be null or Empty
//	Email should be Valid
	@NotEmpty(message ="user Email should not be null or Empty" )
	@Email(message="Email should be Valid")
	private String email;

}

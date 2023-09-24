package com.wooper.rooper.board.dto;

import com.wooper.rooper.user.UserDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardDto {

	private Long id;

	private String title;

	private String content;

	private UserDto userDto;
}

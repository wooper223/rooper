package com.wooper.rooper.board.entity;

import com.wooper.rooper.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Board {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	@ManyToOne
	private User user;

	public Board() {
	}

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public void updateBoard(String title, String content) {
		this.title = title;
		this.content = content;
	}
}

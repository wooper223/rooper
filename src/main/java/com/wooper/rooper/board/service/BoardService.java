package com.wooper.rooper.board.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wooper.rooper.board.dto.BoardDto;
import com.wooper.rooper.board.entity.Board;
import com.wooper.rooper.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	public Long create(BoardDto boardDto) {
		Board board = new Board(boardDto.getTitle(), boardDto.getContent());
		Board newBoard = boardRepository.save(board);

		return newBoard.getId();
	}

	public BoardDto getOne(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(NoSuchElementException::new);

		return BoardDto.builder()
			.id(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.build();
	}

	public void update(BoardDto boardDto) {
		Board board = boardRepository.findById(boardDto.getId())
			.orElseThrow(NoSuchElementException::new);

		board.updateBoard(boardDto.getTitle(), boardDto.getContent());
	}

	public void delete(Long id) {
		boardRepository.deleteById(id);
	}
}

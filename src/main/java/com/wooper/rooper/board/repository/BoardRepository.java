package com.wooper.rooper.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooper.rooper.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}

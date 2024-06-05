package com.example.cache.board.repository;

import com.example.cache.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardEntityJpaRepository extends JpaRepository<BoardEntity, Long> {
}

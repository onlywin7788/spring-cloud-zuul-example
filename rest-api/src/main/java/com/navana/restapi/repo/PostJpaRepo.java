package com.navana.restapi.repo;

import com.navana.restapi.entity.Board;
import com.navana.restapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepo extends JpaRepository<Post, Long> {
    List<Post> findByBoard(Board board);
}

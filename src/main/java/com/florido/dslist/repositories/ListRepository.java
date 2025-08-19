package com.florido.dslist.repositories;

import com.florido.dslist.model.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<GameList, Long> {
}

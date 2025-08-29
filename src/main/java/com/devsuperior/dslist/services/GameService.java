package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);

    }
    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(GameMinDto::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId){
        var result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDto::new).toList();
    }
}

package com.example.football.service.impl;

import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//ToDo - Implement all methods
@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }


    @Override
    public boolean areImported() {
        return this.townRepository.count()>0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        Path path=Path.of("C:\\Users\\sneji\\Downloads\\Player Finder_Skeleton\\skeleton\\skeleton\\src\\main\\resources\\files\\json\\towns.json");
        return String.join("\n", Files.readAllLines(path));
    }


    @Override
    public String importTowns() {
        return null;
    }
}

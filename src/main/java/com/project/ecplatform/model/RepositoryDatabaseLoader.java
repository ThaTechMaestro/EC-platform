package com.project.ecplatform.model;

import com.project.ecplatform.model.entity.Item;
import com.project.ecplatform.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDatabaseLoader {

    @Bean
    CommandLineRunner initialize(ItemRepository repository){

        return args -> {
            repository.save(new Item("Digital Alarm Clock", 19.99) );
            repository.save(new Item("Glass TV tray", 24.99) );
        };
    }
}

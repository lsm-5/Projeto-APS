package com.hotelzin.cinhospede.configurations;

import com.hotelzin.cinhospede.model.Room;
import com.hotelzin.cinhospede.model.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration implements CommandLineRunner {
  @Autowired
  private RoomRepository roomRepository;

  @Override
  public void run(String... args) throws Exception {
    roomRepository.save(new Room("Quarto mundo azul", 
                                "Apaixone-se pelo azul e tranquilize-se!", 
                                1L, 
                                69.90, 
                                2, 
                                2, 
                                "https://cdn.panrotas.com.br/portal-panrotas-statics/media-files-original/2013/12/16/30482002074853083696thewilliamblue.jpg",
                                6,
                                true));

    roomRepository.save(new Room("Quarto mundo vermelho", 
                                "Apaixone-se pelo vermelho provocante!", 
                                1L, 
                                59.90, 
                                1, 
                                2, 
                                "http://s2.glbimg.com/136ZWbdLFKHTXQJ0tIJUBZRCKws=/smart/e.glbimg.com/og/ed/f/original/2016/03/24/7_1.jpg",
                                4,
                                false));

    roomRepository.save(new Room("Quarto mundo amarelo", 
                                "Apaixone-se pelo amarelo alegre!", 
                                1L, 
                                59.90, 
                                1, 
                                2, 
                                "https://www.decorfacil.com/wp-content/uploads/2019/09/20190917quarto-amarelo-28.jpg",
                                4,
                                false));
  }
  
}

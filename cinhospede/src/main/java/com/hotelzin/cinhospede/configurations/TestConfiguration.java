package com.hotelzin.cinhospede.configurations;

import com.hotelzin.cinhospede.model.Admin;
import com.hotelzin.cinhospede.model.Hotel;
import com.hotelzin.cinhospede.model.Room;
import com.hotelzin.cinhospede.repositories.AdminRepository;
import com.hotelzin.cinhospede.repositories.HotelRepository;
import com.hotelzin.cinhospede.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration implements CommandLineRunner {
  @Autowired
  private HotelRepository hotelRepository;

  @Autowired
  private AdminRepository adminRepository;

  @Autowired
  private RoomRepository roomRepository;

  @Override
  public void run(String... args) throws Exception {
    hotelRepository.save(new Hotel("Hotel do Lucas", 
                                  "Hospede-se e seja feliz!", 
                                  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRR7GKLj7_Gpdqld10m1MeXbdkYkubvP9KY8g&usqp=CAU", 
                                  "Rua 1, ao lado da rua 2",
                                  "admin@admin.com"));

    hotelRepository.save(new Hotel("Hotel do Miterrand", 
                                  "Venha hospedar-se aqui!", 
                                  "https://cf.bstatic.com/xdata/images/hotel/270x200/150037271.jpg?k=9ee240899d6a6149e1e446a1f92ec0740419195316fbe2077fa92624fa9661ad&o=", 
                                  "Rua 3, ao lado da rua 5",
                                  "admin@admin.com"));

    adminRepository.save(new Admin("admin", "admin@admin.com", "admin"));

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
    
  }
  
}

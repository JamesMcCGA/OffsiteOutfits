package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.entity.Team;
import org.springframework.stereotype.Service;

@Service
public class PopulationScript {
    private final TShirtRepository tShirtRepository;
    private final AppUserRepository appUserRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    public PopulationScript(TShirtRepository tShirtRepository, AppUserRepository appUserRepository, TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.tShirtRepository = tShirtRepository;
        this.appUserRepository = appUserRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public void populateDatabase() {

        TShirt tshirt1 = new TShirt();
        tshirt1.setCondition("Good");
        tshirt1.setKit("Home");
        tshirt1.setNumber(7);
        tshirt1.setPrice(200);
        tshirt1.setSize("M");
        tshirt1.setYear(2008);
        tShirtRepository.save(tshirt1);

        AppUser appUser1 = new AppUser();
        appUser1.setUsername("bestshopper101");
        appUser1.setEmail("bestshopper@gmail.com");
        appUser1.setAdminPrivileges(true);
        appUserRepository.save(appUser1);

        Team team1 = new Team();
        team1.setTeamname("Manchester United");
        teamRepository.save(team1);

        Player player1 = new Player();
        player1.setPlayerName("Lionel Messi");
        playerRepository.save(player1);





    }
    public void deleteAllData() {
        tShirtRepository.deleteAll();
        appUserRepository.deleteAll();
        teamRepository.deleteAll();
        playerRepository.deleteAll();


    }

}

package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.entity.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        Player player = playerRepository.findById(1).orElse(null);
        List<Player> players = new ArrayList<>();
        players.add(player);

        Team team = teamRepository.findById(1).orElse(null);
        List<Team> teams = new ArrayList<>();
        teams.add(team);

        AppUser appUser = appUserRepository.findById(1).orElse(null);
        List<AppUser> appUsers = new ArrayList<>();
        appUsers.add(appUser);

        TShirt tShirt = tShirtRepository.findById(1).orElse(null);
        List<TShirt> tShirts = new ArrayList<>();
        tShirts.add(tShirt);

        TShirt tshirt1 = new TShirt();
        tshirt1.setCondition("Good");
        tshirt1.setKit("Home");
        tshirt1.setNumber(7);
        tshirt1.setPrice(200);
        tshirt1.setSize("M");
        tshirt1.setYear(2008);
        tshirt1.setPlayer(player);
        tshirt1.setTeam(team);
        tshirt1.setAppUser(appUser);



        tShirtRepository.save(tshirt1);

        AppUser appUser1 = new AppUser();
        appUser1.setUsername("bestshopper101");
        appUser1.setEmail("bestshopper@gmail.com");
        appUser1.setAdminPrivileges(true);


        appUser1.setTShirts(tShirts);


        appUserRepository.save(appUser1);

        Team team1 = new Team();
        team1.setTeamname("Manchester United");
        team1.setPlayers(players);
        team1.settShirt(tShirts);
        teamRepository.save(team1);

        Player player1 = new Player();
        player1.setPlayerName("Lionel Messi");
        player1.setTeams(teams);
        player1.settShirts(tShirts);
        playerRepository.save(player1);





    }
    public void deleteAllData() {
        tShirtRepository.deleteAll();
        appUserRepository.deleteAll();
        teamRepository.deleteAll();
        playerRepository.deleteAll();


    }

}

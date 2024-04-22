package com.example.offsideoutfits;

import static org.mockito.Mockito.*;

import com.example.offsideoutfits.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.entity.Team;

public class PopulationScriptTests {

    @Mock
    private TShirtRepository tShirtRepository;

    @Mock
    private AppUserRepository appUserRepository;

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PopulationScript populationScript;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPopulateDatabase() {

        TShirt tShirt = new TShirt();
        tShirt.setCondition("Good");
        tShirt.setKit("Home");
        tShirt.setNumber(7);
        tShirt.setPrice(200);
        tShirt.setSize("M");
        tShirt.setYear(2008);

        AppUser appUser = new AppUser();
        appUser.setUsername("bestshopper101");
        appUser.setEmail("bestshopper@gmail.com");
        appUser.setAdminPrivileges(true);

        Team team = new Team();
        team.setTeamname("Manchester United");

        Player player = new Player();
        player.setPlayerName("Lionel Messi");

        when(tShirtRepository.save(any(TShirt.class))).thenReturn(tShirt);
        when(appUserRepository.save(any(AppUser.class))).thenReturn(appUser);
        when(teamRepository.save(any(Team.class))).thenReturn(team);
        when(playerRepository.save(any(Player.class))).thenReturn(player);

        populationScript.populateDatabase();

        verify(tShirtRepository).save(any(TShirt.class));
        verify(appUserRepository).save(any(AppUser.class));
        verify(teamRepository).save(any(Team.class));
        verify(playerRepository).save(any(Player.class));
    }
}
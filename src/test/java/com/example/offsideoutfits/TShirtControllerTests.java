package com.example.offsideoutfits;

import com.example.offsideoutfits.DTOs.TShirtDTO;
import com.example.offsideoutfits.controller.TShirtController;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.service.TShirtService;
import com.example.offsideoutfits.service.impl.TShirtServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@SpringBootTest
//The below annotation initializes fields annotated with @Mock @Spy etc. so you don't have to manually create them with Mockito.mock()
//Then it injects them where needed i.e. executes the @InjectMocks annotation
//Cleans up mocks after test is run
@ExtendWith(MockitoExtension.class)
public class TShirtControllerTests {

    //The @Mock annotation means you don't have to manually do something like tShirtRepository = Mockito.mock(TShirtRepository.class)
    @Mock
    private TShirtRepository mocktShirtRepository;

//    Spies are also injected automatically into the object annotated with @InjectMocks
//    @Spy
//    private TShirtRepository spytShirtRepository;

    @Mock
    private TShirtServiceImpl mocktShirtService;

    //InjectMocks provides mocks like tShirtRepository into the tShirtController to use
    @InjectMocks
    private TShirtController tShirtController;

    private List<TShirtDTO> mockList;
    private List<TShirt> oldmockList;

    @BeforeEach
    public void setUp() {
        mockList = Arrays.asList(new TShirtDTO(), new TShirtDTO());
//        tShirtRepository = Mockito.mock(TShirtRepository.class);
        //creates stub
        lenient().when(mocktShirtService.getAllTShirts()).thenReturn(mockList);
        lenient().when(mocktShirtService.getTShirtsByAppUser(Mockito.anyInt())).thenReturn(oldmockList);
        lenient().when(mocktShirtService.getTShirtsByAppUserUsername(Mockito.anyString())).thenReturn(oldmockList);
        lenient().when(mocktShirtService.getTShirtsByAppUserEmail(Mockito.anyString())).thenReturn(oldmockList);
        lenient().when(mocktShirtRepository.findAll()).thenReturn(oldmockList);
//        when(spytShirtRepository.findAll()).thenReturn(mockList);
    }

    @Test
    public void testTShirtControllerGetAllTshirts() {
        List<TShirtDTO> result = tShirtController.getAllTshirts();
        verify(mocktShirtService, times(1)).getAllTShirts();
//        verify(mocktShirtRepository, times(1)).findAll();
//        verify(spytShirtRepository, times(1)).findAll();
        assertEquals(mockList, result);
    }

    @Test
    public void testTShirtControllerGetTShirtsByAppUser(){
        List<TShirt> result = tShirtController.getTShirtsByAppUser(1);
        verify(mocktShirtService,times(1)).getTShirtsByAppUser(1);
        assertEquals(oldmockList, result);
    }

    @Test
    public void testTShirtsByAppUserUsername(){
        List<TShirt> result = tShirtController.getTShirtsByAppUserName("test");
        verify(mocktShirtService,times(1)).getTShirtsByAppUserUsername(Mockito.anyString());
        assertEquals(oldmockList, result);
    }

    @Test
    public void testTshirtsByAppUserEmail(){
        List<TShirt> result = tShirtController.getTShirtsByAppUserEmail("test");
        verify(mocktShirtService,times(1)).getTShirtsByAppUserEmail(Mockito.anyString());
        assertEquals(oldmockList, result);
    }

}
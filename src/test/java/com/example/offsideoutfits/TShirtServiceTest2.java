package com.example.offsideoutfits;


import com.example.offsideoutfits.DTOs.TShirtDTO;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.service.impl.TShirtServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TShirtServiceTest2 {

    @Mock
    private TShirtServiceImpl tShirtService;

    @Test
    public void testGetAllTshirts() {
        List<TShirtDTO> expectedTShirts = Arrays.asList(new TShirtDTO(), new TShirtDTO());
        when(tShirtService.getAllTShirts()).thenReturn(expectedTShirts);

        List<TShirtDTO> actualTShirts = tShirtService.getAllTShirts();

        // Assert
        verify(tShirtService, times(1)).getAllTShirts();
        assertEquals(expectedTShirts, actualTShirts);
    }

     @Test
    public void testGetTShirtsByAPpUserUsername() {
        List<TShirt> expectedTShirts = Arrays.asList(new TShirt(), new TShirt());
        when(tShirtService.getTShirtsByAppUserUsername(Mockito.anyString())).thenReturn(expectedTShirts);

        List<TShirt> actualTShirts = tShirtService.getTShirtsByAppUserUsername("test");

        // Assert
        verify(tShirtService, times(1)).getTShirtsByAppUserUsername("test");
        assertEquals(expectedTShirts, actualTShirts);
    }


}

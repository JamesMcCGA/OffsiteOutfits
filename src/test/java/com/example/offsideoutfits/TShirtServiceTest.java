package com.example.offsideoutfits;

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
public class TShirtServiceTest {

    @Mock
    private TShirtRepository tShirtRepository;

    @InjectMocks
    private TShirtServiceImpl tShirtService;

    @Test
    public void testGetAllTshirts() {
        List<TShirt> expectedTShirts = Arrays.asList(new TShirt(), new TShirt());
        when(tShirtRepository.findAll()).thenReturn(expectedTShirts);

        List<TShirt> actualTShirts = tShirtService.getAllTShirts();

        // Assert
        verify(tShirtRepository, times(1)).findAll();
        assertEquals(expectedTShirts, actualTShirts);
    }

    @Test
    public void testGetTShirtsByAppUser() {
        List<TShirt> expectedTShirts = Arrays.asList(new TShirt(), new TShirt());
        when(tShirtRepository.findByAppUserAppUserId(Mockito.anyInt())).thenReturn(expectedTShirts);

        List<TShirt> actualTShirts = tShirtService.getTShirtsByAppUser(1);

        // Assert
        verify(tShirtRepository, times(1)).findByAppUserAppUserId(Mockito.anyInt());
        assertEquals(expectedTShirts, actualTShirts);
    }

}
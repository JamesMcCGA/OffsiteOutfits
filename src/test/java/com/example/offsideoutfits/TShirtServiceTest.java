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
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TShirtServiceTest {

    @Mock
    private TShirtRepository tShirtRepository;

    @InjectMocks
    private TShirtServiceImpl tShirtService;

    private TShirtDTO convertToDTO(TShirt tShirt) {
        TShirtDTO dto = new TShirtDTO();
        dto.settShirtId(tShirt.gettShirtId());
        dto.setSize(tShirt.getSize());
        dto.setYear(tShirt.getYear());
        dto.setPrice(tShirt.getPrice());
        dto.setKit(tShirt.getKit());
        dto.setNumber(tShirt.getNumber());
        dto.setCondition(tShirt.getCondition());
        // Set more properties

        // Set AppUser information
        if (tShirt.getAppUser() != null) {
//            System.out.println("Has an associated app user !!!!!!!!!!!!!");
            dto.setAppUserUsername(tShirt.getAppUser().getUsername());
            dto.setAppUserId(tShirt.getAppUser().getAppUserId());
            // Set other AppUser properties as needed
        }

        return dto;
    }

    @Test
    public void testGetAllTshirts() {
        List<TShirt> expectedTShirts = Arrays.asList(new TShirt(), new TShirt());
        List<TShirtDTO> expectedTShirts2 = expectedTShirts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        when(tShirtRepository.findAll()).thenReturn(expectedTShirts);

        List<TShirtDTO> actualTShirts = tShirtService.getAllTShirts();

        // Assert
        verify(tShirtRepository, times(1)).findAll();
        assertEquals(expectedTShirts2.getClass().getTypeName(), actualTShirts.getClass().getTypeName());
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
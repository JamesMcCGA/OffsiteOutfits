package com.example.offsideoutfits;

import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TShirtRepositoryTest {


    @Mock
    private TShirtRepository tShirtRepository;

    @Test
    public void testFindAll() {
         List<TShirt> expectedTShirts = Arrays.asList(new TShirt(), new TShirt());
        when(tShirtRepository.findAll()).thenReturn(expectedTShirts);

        List<TShirt> actualTShirts = tShirtRepository.findAll();

        verify(tShirtRepository, times(1)).findAll();
        assertEquals(2, actualTShirts.size());
    }
}
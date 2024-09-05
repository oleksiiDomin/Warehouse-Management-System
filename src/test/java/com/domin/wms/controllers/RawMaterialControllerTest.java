package com.domin.wms.controllers;

import com.domin.wms.dto.raw_materials_dto.CalciumDTO;
import com.domin.wms.services.RawMaterialService;
import com.domin.wms.util.EntityErrorMassage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class RawMaterialControllerTest {

    @Mock
    private RawMaterialService rawMaterialService;

    @Mock
    private EntityErrorMassage entityErrorMassage;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private RawMaterialController rawMaterialController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(rawMaterialController).build();
        objectMapper = new ObjectMapper();
    };

    @Test
    void getAllCalcium() throws Exception {
        mockMvc.perform(get("/raw_materials/calcium")).andReturn().getResponse();
    }

    @Test
    void createCalcium() throws Exception {
        CalciumDTO calciumDTO = new CalciumDTO();

        calciumDTO.setBalance(2000);
        calciumDTO.setLot("5698");
        calciumDTO.setWeightOfLot(5698);


        String calciumJson = objectMapper.writeValueAsString(calciumDTO);

        mockMvc.perform(post("/raw_materials/create_calcium")
                .contentType(MediaType.APPLICATION_JSON)
                .content(calciumJson))
                .andExpect(status().isOk());
        //verify(rawMaterialService, times(1)).save(calciumDTO);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testMethod(int argument) {
        //test code
    }
}















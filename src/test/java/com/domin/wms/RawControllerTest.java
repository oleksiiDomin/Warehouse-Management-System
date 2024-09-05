package com.domin.wms;

import com.domin.wms.controllers.RawMaterialController;
import com.domin.wms.dto.raw_materials_dto.CarbonDTO;
import com.domin.wms.services.RawMaterialService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

public class RawControllerTest {

    @Mock
    private RawMaterialService rawMaterialService;

    @InjectMocks
    private RawMaterialController rawMaterialController;

    @Test
    public void getAllMaterialsShouldReturnMaterialsList() {
        List<Object> mockCarbon = Arrays.asList(
                new CarbonDTO(95.0, 5.0)
        );

    }
}

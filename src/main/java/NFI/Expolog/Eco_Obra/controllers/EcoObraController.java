package NFI.Expolog.Eco_Obra.controllers;

import NFI.Expolog.Eco_Obra.services.ConsumeAPI;
import NFI.Expolog.Eco_Obra.services.ConvertData;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoObraController {

    private final ConsumeAPI consumeAPI = new ConsumeAPI();
    private final ConvertData convertData = new ConvertData();

    public <T> T getWebData(String address,Class<T> tClass){
        String json = consumeAPI.getData(address);
        return convertData.getData(json,tClass);
    }
}

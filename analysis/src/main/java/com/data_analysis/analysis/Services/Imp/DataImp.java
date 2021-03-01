package com.data_analysis.analysis.Services.Imp;

import com.data_analysis.analysis.client.DataClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DataImp {

    @Resource
    DataClient dataClient;

    public String get(String name)
    {
        return dataClient.get(name);
    }
}

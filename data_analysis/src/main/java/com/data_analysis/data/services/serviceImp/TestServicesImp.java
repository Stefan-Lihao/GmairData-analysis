package com.data_analysis.data.services.serviceImp;


import com.data_analysis.data.services.TestServices;
import org.springframework.stereotype.Service;

@Service
public class TestServicesImp implements TestServices {

    @Override
    public String get(String name) {
        return "参数name：" + name;
    }
}
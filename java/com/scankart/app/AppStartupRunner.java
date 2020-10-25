package com.scankart.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.scankart.app.model.AdminConfigurations;
import com.scankart.app.model.AllOrderRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {
    
	@Autowired
	AllOrderRepository allOrderRepo;
	
	public static HashMap<String,String> configValues = new HashMap<>();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Your application started with option names : {}"+ args.getOptionNames());
        List<String> configurations = new ArrayList<>();
        configurations.add("Radius");
        configurations.add("Records");
        List<AdminConfigurations> listOfAdminConfig = allOrderRepo.getConfigurations(configurations);
        for (AdminConfigurations adminConfig : listOfAdminConfig) {
        	configValues.put(adminConfig.getName(), adminConfig.getValue());
        }
        System.out.println(configValues);
    }
}

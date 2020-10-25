package com.scankart.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.regex.Pattern;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scankart.app.model.AllUserLogin;
import com.scankart.app.model.AllUserLoginRepository;
import com.scankart.app.model.AllUserRepository;

@Transactional
@Repository
@Service("ValidatorUtility")
public class ValidatorUtility {
	
	@Autowired
	AllUserLoginRepository alUserLoginRepo;

	public  int validateUser(String apiKey, int id, int type)
	{
		try {
			AllUserLogin loggedUser = alUserLoginRepo.checkUserValidity(type, id, apiKey);
			if (loggedUser != null) {
				return 1;
			} else {
				return 0;
			}

			
		}
		catch(Exception e) {
			return -1;
		}
		
	}
	
	
}

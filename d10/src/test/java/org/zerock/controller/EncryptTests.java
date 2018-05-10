package org.zerock.controller;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.log4j.Log4j;
@Log4j
public class EncryptTests {

		
		@Test
		public void testMatches() {
			String enStr = "$2a$10$eeI4lLMEvAgEL8t9HED.WOu8p/nlh5HnUhYxyWN8gEUUZ2f.bTXK2";
			
			String user = "1111";
			
			BCryptPasswordEncoder pwencoder
			= new BCryptPasswordEncoder();
			
			boolean matching = pwencoder.matches(user,enStr);
			
			System.out.println(matching);
		}
		
		@Test
		public void testEncrypt() {
			
			BCryptPasswordEncoder pwencoder
			= new BCryptPasswordEncoder();
			
			String str = "1111";
			
			String enStr = pwencoder.encode(str);
			
			System.out.println(enStr);
		}

		
		
	}



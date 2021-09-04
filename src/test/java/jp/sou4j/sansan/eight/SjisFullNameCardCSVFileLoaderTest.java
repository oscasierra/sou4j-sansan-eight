package jp.sou4j.sansan.eight;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class SjisFullNameCardCSVFileLoaderTest {

	@Test
	public void loadSjisFullNameCardTest_001() throws IOException, ParseException {
		
		URL url = Thread.currentThread().getContextClassLoader().getResource("ShiftJISFullName001.csv");
		File file = new File(url.getPath());
		List<Card> cards = new SjisFullNameCardCSVFileLoader(file).load();
		assertEquals(1, cards.size());
		Card card = cards.get(0);
		assertEquals("株式会社xxxxxxxxxx",card.getCompanyName());
		assertEquals("Production部 Engineerグループ",card.getDepartment());
		assertEquals("係長", card.getTitle());
		assertEquals("フルネーム", card.getFullName());
		assertNull(card.getFirstName());
		assertNull(card.getLastName());
		assertEquals("test.test@xxxxxxxxxx.com", card.getEmail());
		assertEquals("1234567", card.getPostalCode());
		assertEquals("東京都xxxxxxxxxxxxxxxx", card.getAddress());
		assertEquals("03-1234-5678", card.getCompanyPhoneNumber());
		assertEquals("03-2234-5678", card.getDepartmentPhoneNumber());
		assertEquals("03-3234-5678", card.getDirectPhoneNumber());
		assertEquals("03-4234-5678", card.getCompanyFaxNumber());
		assertEquals("03-5234-5678", card.getMobilePhoneNumber());
		assertEquals("http://www.company.com", card.getUrl());
		String inpDateStr = "2016/06/22";
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd");
		Date dateTime = sdformat.parse(inpDateStr);

		assertEquals(dateTime, card.getTradingDate());
		assertTrue(card.isLinked());

	}
	
}

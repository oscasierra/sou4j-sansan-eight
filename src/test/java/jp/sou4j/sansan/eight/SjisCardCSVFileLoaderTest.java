package jp.sou4j.sansan.eight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;


public class SjisCardCSVFileLoaderTest {

	@Test
	public void loadSjisFullNameCardTest_001() throws IOException, ParseException {
		
		URL url = Thread.currentThread().getContextClassLoader().getResource("ShiftJISSepa001.csv");
		File file = new File(url.getPath());
		List<Card> cards = new SjisCardCSVFileLoader(file).load();
		assertEquals(4, cards.size());
		Card card = cards.get(0);
		assertEquals("株式会社xxxxxxxx",card.getCompanyName());
		assertEquals("システム部 Engineerグループ",card.getDepartment());
		assertEquals("係長", card.getTitle());
		assertEquals("姓名", card.getFullName());
		assertEquals("姓", card.getLastName());
		assertEquals("名", card.getFirstName());
		assertEquals("test.test@xxxxxxxxx.com", card.getEmail());
		assertEquals("1234567", card.getPostalCode());
		assertEquals("東京都xxxxxxxxxxx", card.getAddress());
		assertEquals("03-1234-5678", card.getCompanyPhoneNumber());
		assertEquals("03-2234-5678", card.getDepartmentPhoneNumber());
		assertEquals("03-3234-5678", card.getDirectPhoneNumber());
		assertEquals("03-4234-4567", card.getCompanyFaxNumber());
		assertEquals("03-5234-5678", card.getMobilePhoneNumber());
		assertEquals("http://www.company.com", card.getUrl());
		String inpDateStr = "2016/06/22";
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd");
		Date dateTime = sdformat.parse(inpDateStr);
		assertEquals(dateTime, card.getTradingDate());
		assertTrue(card.isLinked());
		
		assertEquals("", cards.get(1).getFullName());
		assertEquals("姓", cards.get(2).getFullName());
		assertEquals("名", cards.get(3).getFullName());

	}
	
}

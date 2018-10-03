package jp.sou4j.sansan.eight.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.sou4j.sansan.eight.Card;
import jp.sou4j.sansan.eight.CardCsvFileRecord;
import jp.sou4j.util.Objects;
import jp.sou4j.util.StringUtils;

public class CardConvertUtils {

	private static final SimpleDateFormat tradingDateFormat = new SimpleDateFormat("yyyy/MM/dd");

	public static Card convertToCard(CardCsvFileRecord record) throws ParseException {
		Objects.requireNonNull(record, "Method argument 'record' is null.");

		Card card = new Card();
		card.setCompanyName(record.getCompanyName());
		card.setDepartment(record.getDepartment());
		card.setTitle(record.getTitle());
		card.setFullName(record.getFullName());
		card.setEmail(record.getEmail());
		card.setPostalCode(record.getPostalCode());
		card.setAddress(record.getAddress());
		card.setCompanyPhoneNumber(record.getCompanyPhoneNumber());
		card.setDepartmentPhoneNumber(record.getDepartmentPhoneNumber());
		card.setDirectPhoneNumber(record.getDirectPhoneNumber());
		card.setCompanyFaxNumber(record.getCompanyFaxNumber());
		card.setMobilePhoneNumber(record.getMobilePhoneNumber());
		card.setUrl(record.getUrl());
		card.setTradingDate(convertTradingDate(record.getTradingDate()));
		card.setLinked(convertLinked(record.getLinked()));
		return card;
	}

	public static List<Card> convertToCardList(List<CardCsvFileRecord> records) throws ParseException {
		Objects.requireNonNull(records, "Method argument 'records' is null.");
		ArrayList<Card> cards = new ArrayList<Card>();
		for(CardCsvFileRecord record : records) {
			cards.add(convertToCard(record));
		}
		return cards;
	}

	/**
	 * <p>項目「名刺交換日」の文字列をDate型に変換して返却します。</p>
	 * @param date 文字列型の名刺交換日
	 * @return Date型に変換した名刺交換日
	 * @throws ParseException 指定された文字列が予期せぬフォーマットであり解釈できなかった場合
	 */
	private static Date convertTradingDate(String date) throws ParseException {
		if( StringUtils.isNullOrEmpty(date) ) {
			return null;
		}
		else {
			return tradingDateFormat.parse(date);
		}
	}

	/**
	 * <p>項目「Eightでつながっている人」のフラグをboolean型に変換して返却します。</p>
	 * @param linked 文字列のフラグ
	 * @return boolean型に変換したフラグ
	 */
	private static boolean convertLinked(String linked) {
		return ("1".equals(linked));
	}
}

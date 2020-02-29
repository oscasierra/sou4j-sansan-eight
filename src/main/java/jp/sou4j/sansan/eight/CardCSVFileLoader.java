package jp.sou4j.sansan.eight;

import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.handlers.ColumnPositionMappingBeanListHandler;

/**
 * <p>EightからダウンロードできるCSV形式の名刺データファイルを読み込むためのクラスです。</p>
 * @author OSCA
 */
abstract class CardCSVFileLoader {

	protected CsvConfig getCsvConfig() {
		CsvConfig config = new CsvConfig();
		config.setQuoteDisabled(false);
		config.setIgnoreEmptyLines(true);
		config.setSkipLines(8);
		return config;
	}

	protected ColumnPositionMappingBeanListHandler<CardCsvFileRecord> getColumnPositionMappingBeanListHandler() {
		return new ColumnPositionMappingBeanListHandler<CardCsvFileRecord>(CardCsvFileRecord.class)
			.addColumn( 0, "companyName")
			.addColumn( 1, "department")
			.addColumn( 2, "title")
			.addColumn( 3, "fullName")
			.addColumn( 4, "email")
			.addColumn( 5, "postalCode")
			.addColumn( 6, "address")
			.addColumn( 7, "companyPhoneNumber")
			.addColumn( 8, "departmentPhoneNumber")
			.addColumn( 9, "directPhoneNumber")
			.addColumn(10, "companyFaxNumber")
			.addColumn(11, "mobilePhoneNumber")
			.addColumn(12, "url")
			.addColumn(13, "tradingDate")
			.addColumn(14, "linked");
	}
}

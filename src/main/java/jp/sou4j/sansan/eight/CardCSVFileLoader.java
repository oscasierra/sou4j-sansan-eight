package jp.sou4j.sansan.eight;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.orangesignal.csv.Csv;
import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.handlers.ColumnPositionMappingBeanListHandler;

import jp.sou4j.sansan.eight.util.CardConvertUtils;
import jp.sou4j.util.Objects;

/**
 * <p>EightからダウンロードできるCSV形式の名刺データファイルを読み込むためのクラスです。</p>
 * @author OSCA
 */
public class CardCSVFileLoader {

	private File file;

	/**
	 * <p>コンストラクタです。 引数で読み込むCSVファイルを指定します。</p>
	 * @param file 読み込むCSVファイル
	 */
	public CardCSVFileLoader(File file) {
		Objects.requireNonNull(file, "Method argument 'file' is null.");
		this.file = file;
	}

	/**
	 * <p>ファイルを読み込み、読み込んだ名刺情報を Card クラスの List で返却します。</p>
	 * @return 名刺情報のリスト
	 * @throws IOException 入出力エラーが発生した場合
	 * @throws ParseException ファイルのパースでエラーが発生した場合
	 */
	public List<Card> load() throws IOException, ParseException {
		List<CardCsvFileRecord> records = this.loadRecords();
		return CardConvertUtils.convertToCardList(records);
	}

	private CsvConfig getCsvConfig() {
		CsvConfig config = new CsvConfig();
		config.setQuoteDisabled(false);
		config.setIgnoreEmptyLines(true);
		config.setSkipLines(8);
		return config;
	}

	private List<CardCsvFileRecord> loadRecords() throws IOException {
		List<CardCsvFileRecord> records = Csv.load(
			this.file,
			"MS932",
			this.getCsvConfig(),
			new ColumnPositionMappingBeanListHandler<CardCsvFileRecord>(CardCsvFileRecord.class)
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
				.addColumn(14, "linked")
		);
		return records;
	}
}

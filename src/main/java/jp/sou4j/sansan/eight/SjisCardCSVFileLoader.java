package jp.sou4j.sansan.eight;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.orangesignal.csv.Csv;

import jp.sou4j.sansan.eight.util.CardConvertUtils;
import jp.sou4j.util.Objects;

/**
 * <p>EightからダウンロードできるCSV形式の名刺データファイル(ShiftJIS版)を読み込むためのクラスです。</p>
 * @author OSCA
 */
public class SjisCardCSVFileLoader extends CardCSVFileLoader {

	private File file;

	/**
	 * <p>コンストラクタです。 引数で読み込むCSVファイルを指定します。</p>
	 * @param file 読み込むCSVファイル
	 */
	public SjisCardCSVFileLoader(File file) {
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

	private List<CardCsvFileRecord> loadRecords() throws IOException {
		List<CardCsvFileRecord> records = Csv.load(
			this.file,
			"MS932",
			super.getCsvConfig(),
			super.getColumnPositionMappingBeanListHandler()
		);
		return records;
	}
}

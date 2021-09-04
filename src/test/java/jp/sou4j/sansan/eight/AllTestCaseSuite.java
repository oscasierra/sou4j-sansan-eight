package jp.sou4j.sansan.eight;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	SjisFullNameCardCSVFileLoaderTest.class,
	SjisCardCSVFileLoaderTest.class,
	Utf8CardCSVFileLoaderTest.class,
	Utf8FullNameCardCSVFileLoaderTest.class,
})
public class AllTestCaseSuite {

}

# sou4j-sansan-eight

## Usage
### 姓・名が分割された形式のUTF-8のCSVファイルを読み込む
```java
List<Card> cards = new Utf8CardCSVFileLoader(file).load();
```

### 姓名が分割されていない形式のUTF-8のCSVファイルを読み込む
```java
List<Card> cards = new Utf8FullNameCardCSVFileLoader(file).load();
```

### 姓・名が分割された形式のShift_JISのCSVファイルを読み込む
```java
List<Card> cards = new SjisCardCSVFileLoader(file).load();
```

### 姓名が分割されていない形式のShift_JISのCSVファイルを読み込む
```java
List<Card> cards = new SjisFullNameCardCSVFileLoader(file).load();
```

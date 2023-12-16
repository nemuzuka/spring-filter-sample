# Spring の filter 動作確認

## 試したこと

- 適用順を意識して FilterRegistrationBean を適応する([FilterConfiguration](src/main/java/com/example/demo/config/FilterConfiguration.java))
- SecurityFilterChain を複数 Bean 登録する([SpringSecurityFilterConfiguration](src/main/java/com/example/demo/config/SpringSecurityFilterConfiguration.java))
    - SecurityFilterChain 配下の Filter として Filter を登録する
- SecurityFilterChain の実行順を指定する([application.properties](src/main/resources/application.properties))

## 理解したこと

1. FilterRegistrationBean で登録した Filter は全体に適用する
    - setOrder メソッドで適応順を指定できる
2. **SecurityFilterChain も filter の流れで実行**し、実行順を `spring.security.filter.order` で指定できる
3. SecurityFilterChain は複数登録でき、`@Order` で適用順を指定できる
    - 最初に securityMatcher にマッチした SecurityFilterChain を実行する
      - 例えば `/api` で始まるエンドポイントと `/ui` で始まるエンドポイントで 適用する SecurityFilterChain を変えることが可能
    - SecurityFilterChain の配下に Filter を追加でき、addFilterBefore メソッド等で既存の Filter の前後に追加できる

## フォーマット

```
$ ./gradlew spotlessApply
```

チェックは

```
$ ./gradlew spotlessCheck
```

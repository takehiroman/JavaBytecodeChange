JavaBytecodeChange
==================

目的:バイトコードを書き換え、デコンパイラで生成したソースコードをコンパイル時にクラッシュする

==================

## Usage

~~~ {.bash}
$ mvn package

$ javac Test.java

$ java Test
~~~ 

・生成されたclassファイルを難読化

::
$ java -jar target/JavaBytecodeChange-1.0-SNAPSHOT.jar Test.class Test.class
::

::
$ java Test
::

・デコンパイラを使ってクラスファイルからソースコードを生成(デコンパイラはjadを使用)
::
$ ./jad -s java -d out/ -r Test.class
::

・ソースコードを生成したディレクトリに移動し再びコンパイルして実行

・コンパイルが通らなかった場合、デコンパイラはソースに戻すのに失敗

==================
License MIT










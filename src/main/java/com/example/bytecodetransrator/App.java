//classファイルの読み込み、または書き込み

package com.example.bytecodetransrator;

/**
 * Hello world!
 * 数式を書き換えるプログラム
 * 実行例:
 * java -jar bytecodeTransrator.jar 変換したいクラスファイル 変換後のクラスファイル名
 */

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class App {
	 /**
	  * コンストラクタ
	  */
	public App() throws Exception {
		super();
	}
	/**
	 * main
	 */
	public static void main(String args[]){
		if(args[0].equals("-h")){
			System.out.println("実行例:\njava -jar bytecodeTransrator.jar 変換したいクラスファイル 変換後のクラスファイル名");
		}else{

		byte[] b1 = null;
		//読み込んでbyte[]型にする．
		try(ByteArrayOutputStream out = new ByteArrayOutputStream(); FileInputStream in = new FileInputStream(args[0]);){
			int read;
			while((read = in.read()) != -1){
				out.write(read);
			}
			b1 = out.toByteArray();
		} catch(IOException e){
			e.printStackTrace();
			System.out.println(args[0]+"読み込み失敗");
		}

		//asm
		ClassReader cr = new ClassReader(b1);
		ClassWriter cw  = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
		ClassVisitor cv = new MyClassVisitor(cw);
		cr.accept(cv, 0);
		byte[] b2 = cw.toByteArray();

		//byte[]型をファイルに書き込む．
		try(FileOutputStream fos = new FileOutputStream(args[1])){
			fos.write(b2);
		}catch(IOException e){
			System.out.println("書き込み失敗");
		}

		}
	}
}

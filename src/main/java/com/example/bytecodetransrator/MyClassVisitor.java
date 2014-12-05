package src.main.java.com.example.bytecodetransrator;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyClassVisitor extends ClassVisitor{

	public MyClassVisitor(ClassVisitor cv){
		super(Opcodes.ASM4, cv);
	}

	@Override
	public MethodVisitor visitMethod(int access,String name,String descriptor,String signature,String[] exceptions){
		System.out.println(name);
		MethodVisitor mv = super.visitMethod(access,name,descriptor,signature,exceptions);
		mv = new MyMethodVisitor(mv);
		return mv;
	}

}

//命令文の変更
package src.main.java.com.example.bytecodetransrator;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;

public class MyMethodVisitor extends MethodVisitor{

	public MyMethodVisitor(MethodVisitor mv){
		super(Opcodes.ASM4, mv);
	}

	@Override
	
	public void visitInsn(int opcode){
		if(opcode == Opcodes.IADD){
		
			super.visitVarInsn(Opcodes.ILOAD,2);
	

		}else{
			super.visitInsn(opcode);
		}
	}
	
	public void visitVarInsn(int opcode,int var){
		if(opcode == Opcodes.ILOAD && var == 1){
			super.visitVarInsn(Opcodes.ILOAD,3);
		}else if(opcode == Opcodes.ILOAD && var == 2){
			super.visitVarInsn(Opcodes.ILOAD,1);
		

		
		}else if(opcode == Opcodes.ILOAD && var == 3){
		super.visitInsn(Opcodes.IADD);
		

		}else{
			super.visitVarInsn(opcode,var);
		}
	}
	
	
}

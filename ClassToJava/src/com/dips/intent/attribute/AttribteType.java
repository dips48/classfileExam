package com.dips.intent.attribute;


public enum AttribteType {
      ConstantValue(1),Code(2),StackMapTable(3),Exceptions(4),InnerClasses(5),EnclosingMethod(6),Synthetic(7),Signature(8),SourceFile(9),
      SourceDebugExtension(10),LineNumberTable(11),LocalVariableTable(12),LocalVariableTypeTable(13),Deprecated(14),RuntimeVisibleAnnotations(15),
      RuntimeInvisibleAnnotations(16),RuntimeVisibleParameterAnnotations(17),RuntimeInvisibleParameterAnnotations(18),AnnotationDefault(19),
      BootstrapMethods(20);
    private int value;
    private AttribteType(int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }
}

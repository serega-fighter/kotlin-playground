package com.serega.internals

@JvmInline
value class Weight(val value: Double)

fun measure(w: Weight) {
    println(w.value)
}

fun main() {
    measure(Weight(5.0))
}

/*
  // access flags 0x19
  public final static measure-Iw_oFYA(D)V
   L0
    LINENUMBER 7 L0
    DLOAD 0
    DSTORE 2
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    DLOAD 2
    INVOKEVIRTUAL java/io/PrintStream.println (D)V
   L1
    LINENUMBER 8 L1
    RETURN
   L2
    LOCALVARIABLE w D L0 L2 0
    MAXSTACK = 3
    MAXLOCALS = 4

  // access flags 0x19
  public final static main()V
   L0
    LINENUMBER 11 L0
    LDC 5.0
    INVOKESTATIC com/serega/lang/perf/Weight.constructor-impl (D)D
    INVOKESTATIC com/serega/lang/perf/ValueClassTestKt.measure-Iw_oFYA (D)V
   L1
    LINENUMBER 12 L1
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 0
*/
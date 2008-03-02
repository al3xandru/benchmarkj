import org.mindstorms.benchmark.groovy.Benchmark as BM
/*
The Computer Language Shootout
http://shootout.alioth.debian.org/

contributed by Jochen Hinrichsen
*/
def MAX = 6 // StackOverFlow
def n = this.args ? this.args[0].toInteger() : MAX

def DuckAck(x, y) {
   if (x == 0) return y+1
   if (y == 0) return DuckAck(x-1, 1)
   return DuckAck(x-1, DuckAck(x, y-1))
}

def TypedAck(int x, int y) {
  if (x == 0) return y + 1
  if (y == 0) return TypedAck(x-1, 1)
  return TypedAck(x-1, TypedAck(x, y-1))
}

def t1= BM.measure("duck") {
  def result = DuckAck(3, n)
  println("duck(3,${n}) : ${result}")
}
def t2= BM.measure("typed") {
  def result = TypedAck(3, n)
  println("typed(3,${n}): ${result}")
}

println t1.toFullString()
println t2.toFullString()
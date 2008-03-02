def fib(n) {
  if (n < 3)
    return 1
  else {
    return fib(n-1) + fib(n-2)
  }
}

def start = System.currentTimeMillis()
println fib(34)
def end = System.currentTimeMillis()
println (end - start)


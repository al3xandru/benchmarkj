def fact(n) {
  if(n > 1) {
    return n * fact(n-1)
  } else {
    return 1
  }
}

for(i in 0..8) {
  fact(500)
}
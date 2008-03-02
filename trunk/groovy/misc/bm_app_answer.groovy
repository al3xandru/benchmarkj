def ack(m, n) {
   if (m==0) return n+1
   if (n==0) return ack(m-1, 1)
   ack(m-1, ack(m, n-1))
}

def the_answer_to_life_the_universe_and_everything() {
   ack(3, 6).toString().split("")[1..-1].inject(0) {s, x -> s + new Integer(x)} + "2"
}

answer = the_answer_to_life_the_universe_and_everything()
println answer
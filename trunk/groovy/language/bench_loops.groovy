import org.mindstorms.benchmark.groovy.Benchmark as BM

BM.benchmark {
  it.benchmark("times") { 1000000.times { it } }
  it.benchmark("upto") { 0.upto(1000000) { it } }
  it.benchmark("downto") { 1000000.downto(0) { it } }
  it.benchmark("step") { 0.step(1000000, 1) { it } }
  it.benchmark("for") { for(i in 0..1000000) { i } }
  it.benchmark("classic for") { for(int i=0; i < 1000000; i++) { i } }
  it.benchmark("while") { def i = 0; while( i < 1000000) { i++ } }
  it.benchmark("range") { (0..1000000).each { it } }
}
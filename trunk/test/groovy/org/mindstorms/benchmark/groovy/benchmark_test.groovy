package org.mindstorms.benchmark.groovy

/**
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 1, 2008
 */

Benchmark.rbenchmark { exec ->
  exec.benchmark("titi") { println "alex" }
  exec.benchmark("lola") { println "tralala" }
}

Benchmark.bm {
  int a
  it.benchmark("for") { for(i = 0; i < 1000000; i++) { a = i} }
  println a
  it.benchmark("range") { 0..1000000.each { i -> a = i; println a } }
  println a
}
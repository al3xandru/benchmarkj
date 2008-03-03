package org.mindstorms.benchmark.groovy

/**
 * 
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Mar 1, 2008
 */

Benchmark.rbench { exec ->
  exec.benchmark("titi") { println "alex" }
  exec.benchmark("lola") { println "tralala" }
}

Benchmark.bm {
  it.benchmark("for") { for(i = 0; i < 1000000; i++) { a = i} }
  it.benchmark("range") { 0..1000000.each { i -> a = i; println a } }
}
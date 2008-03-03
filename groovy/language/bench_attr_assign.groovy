import org.mindstorms.benchmark.groovy.Benchmark as BM

class BenchAttrAssign extends ArrayList {
  def bar

  def control() {
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
    this; 1; this; 1; this; 1; this; 1; this; 1
  }
  
  def hundred_property_assigns() {
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
    this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1; this.bar = 1
  }

  def hundred_field_assigns() {
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
    this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1; this.@bar = 1
  }

  def hundred_array_assigns() {
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
    this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1; this[1] = 1
  }

  /**
   * this one doesn't work
   */
  def hundred_array_assigns2() {
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
    this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1; this[1..2] = 1
  }
}


BM.rbench(1) {
  foo = new BenchAttrAssign()
  it.benchmark("control") { 100000.times { foo.control() } }
  it.benchmark("100 prop asgns") { 100000.times { foo.hundred_property_assigns() } }
  it.benchmark("100 fld asgns") { 100000.times { foo.hundred_field_assigns() } }
  it.benchmark("100 array[1] asgns") { 100000.times { foo.hundred_array_assigns() } }
  it.benchmark("100 array[1..2] asgns") { 100000.times { foo.hundred_array_assigns2() } }
}

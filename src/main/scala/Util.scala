package testchipip

import Chisel._

class ResetSync(c: Clock, lat: Int = 2) extends Module(_clock = c) {
  val io = new Bundle {
    val reset = Bool(INPUT)
    val reset_sync = Bool(OUTPUT)
  }
  io.reset_sync := ShiftRegister(io.reset,lat)
}
object ResetSync {
  def apply(r: Bool, c: Clock): Bool =  {
    val sync = Module(new ResetSync(c,2))
    sync.io.reset := r
    sync.io.reset_sync
  }
}
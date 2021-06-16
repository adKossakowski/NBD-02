package pl.edu.pja

class KontoBankowe(private var _stanKonta: Double) {


  def stanKonta = _stanKonta

  def this() = this(0)

  def wpłata(kwota: Double): Unit = {
    _stanKonta = _stanKonta + kwota
  }

  def wyplata(kwota: Double): Unit = {
    _stanKonta = _stanKonta - kwota
  }

}

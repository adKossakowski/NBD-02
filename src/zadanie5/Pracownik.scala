package pl.edu.pja
package zadanie5

trait Pracownik {
  protected var _pensja: Double

  def pensja = _pensja

  def pensja_ (newPensja: Double): Unit = {
    _pensja = newPensja
  }

  def podatek: Double = 20

}

package ar.edu.unahur.obj2.vendedores

class Certificacion(val esDeProducto: Boolean, val puntaje: Int)

abstract class Vendedor {
  val certificaciones = mutableListOf<Certificacion>()

  abstract fun puedeTrabajarEn(ciudad: Ciudad): Boolean

  fun esVersatil() =
    certificaciones.size >= 3
      && this.certificacionesDeProducto() >= 1
      && this.otrasCertificaciones() >= 1

  fun agregarCertificacion(certificacion: Certificacion) {
    certificaciones.add(certificacion)
    // Resta acá pensar alguna otra cosa que no me acuerdo
    //Esto agrega una certificación
  }

  fun esFirme() = this.puntajeCertificaciones() >= 30

  fun tieneMuchasCertificaciones() = certificaciones.size > 5

  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }
  fun otrasCertificaciones() = certificaciones.count { !it.esDeProducto }

  fun puntajeCertificaciones() = certificaciones.sumBy { c -> c.puntaje }
}

class VendedorFijo(val ciudadOrigen: Ciudad) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    // Arreglalo vos Pablo :)
    return ciudad == ciudadOrigen
  }
}

class Viajante(val provinciasHabilitadas: List<Provincia>) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return provinciasHabilitadas.contains(ciudad.provincia)
  }
}

class ComercioCorresponsal(val ciudades: List<Ciudad>) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudades.contains(ciudad)
  }
}

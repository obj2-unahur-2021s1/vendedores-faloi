package ar.edu.unahur.obj2.vendedores

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode
import io.kotest.extensions.junitxml.JunitXmlReporter

class KotestConfig: AbstractProjectConfig() {
  // Modificamos esta configuración para que se creen nuevos objetos para cada `it`.
  override val isolationMode = IsolationMode.InstancePerLeaf

  override fun listeners() = listOf(
    JunitXmlReporter(
      includeContainers = false,
      useTestPathAsName = true
    )
  )
}

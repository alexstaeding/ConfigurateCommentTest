package org.example

import org.spongepowered.configurate.hocon.HoconConfigurationLoader
import org.spongepowered.configurate.objectmapping.ConfigSerializable
import org.spongepowered.configurate.objectmapping.meta.Comment
import java.nio.file.Paths

fun main() {
  val loader = HoconConfigurationLoader.builder().path(Paths.get("./annotationTest.conf")).build()
  val rootNode = loader.load()
  rootNode.set(CommentAnnotationTest())
  loader.save(rootNode)

  val value = requireNotNull(rootNode[CommentAnnotationTest::class.java]) { "CommentAnnotationTest not present" }
  println("foo1: ${value.foo1}")
  println("foo1 comment: ${rootNode.node("foo1").comment()}")
  println("foo2: ${value.foo2}")
  println("foo2 comment: ${rootNode.node("foo2").comment()}")
}

// https://github.com/SpongePowered/Configurate/issues/197
@ConfigSerializable
data class CommentAnnotationTest(
  @Comment("Test comment1")
  val foo1: String = "bar1",
) {
  @Comment("Test comment2")
  val foo2: String = "bar2"
}

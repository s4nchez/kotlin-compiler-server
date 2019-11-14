package com.compiler.server

import com.compiler.server.generator.TestProjectRunner
import com.compiler.server.generator.runManyTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BaseRunnerTest {

  @Autowired
  private lateinit var testRunner: TestProjectRunner

  @Test
  fun `base execute test JVM`() = testRunner.run(
    code = "fun main() {\n println(\"Hello, world!!!\")\n}",
    contains = "Hello, world!!!"
  )

  @Test
  fun `base execute test JS`() = testRunner.runJs(
    code = "fun main() {\n println(\"Hello, world!!!\")\n}",
    contains = "println('Hello, world!!!');"
  )

  @Test
  fun `a lot of hello word test JVM`() {
    runManyTest {
      testRunner.run(
        code = "fun main() {\n println(\"Hello, world!!!\")\n}",
        contains = "Hello, world!!!"
      )
    }
  }

  @Test
  fun `a lot of hello word test JS`() {
    runManyTest {
      testRunner.runJs(
        code = "fun main() {\n println(\"Hello, world!!!\")\n}",
        contains = "println('Hello, world!!!');"
      )
    }
  }

}
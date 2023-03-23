package jbardel.devtoolboxplugin.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBTextArea
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.dsl.gridLayout.GridLayout
import com.intellij.util.ui.components.BorderLayoutPanel
import jbardel.devtoolboxplugin.MyBundle
import jbardel.devtoolboxplugin.services.MyProjectService
import javax.swing.JButton


class MyToolWindowFactory : ToolWindowFactory {

    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    private val contentFactory = ContentFactory.SERVICE.getInstance()

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val content = contentFactory.createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {

        private val service = toolWindow.project.service<MyProjectService>()

        fun getContent() = BorderLayoutPanel().apply {
//            val label = JBLabel(MyBundle.message("randomLabel", "?"))
            val decodedJBTextArea = JBTextArea("Test")
            val encodedJBTextArea = JBTextArea("Test 2")

            val buttons = JBPanel<JBPanel<*>>().apply {
                val decode = JButton("Decode").apply {
                    addActionListener {
                        encodedJBTextArea.text = MyBundle.message("randomLabel", service.getRandomNumber())
                    }
                }
                add(decode)
            }
            addToTop(decodedJBTextArea)
            addToCenter(buttons)
            addToBottom(encodedJBTextArea)
        }
    }
}

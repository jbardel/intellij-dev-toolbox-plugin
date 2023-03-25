package jbardel.devtoolboxplugin.toolWindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import jbardel.devtoolboxplugin.B64Window
import jbardel.devtoolboxplugin.utility.decodeB64
import jbardel.devtoolboxplugin.utility.encodeB64


class B64WindowFactory : ToolWindowFactory {

    init {
//        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    private val contentFactory = ContentFactory.SERVICE.getInstance()

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = B64Window({
            encodeB64(it)
        }) {
            decodeB64(it)
        }
        val content = contentFactory.createContent(myToolWindow.content, "Base 64 (enc|dec)oder", false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true
}

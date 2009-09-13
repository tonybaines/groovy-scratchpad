import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import javax.swing.*
import javax.swing.filechooser.*

def swing = new SwingBuilder()
def outputArea
def baseDir = null

def log = { msg ->
	outputArea.text += new Date().toString()  + ': ' + msg + '\n'
}


swing.frame(title: 'Pre-migration Healthcheck', defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE,
	    size: [800, 600], show: true, locationRelativeTo: null) {
  lookAndFeel("system")
  def chooseFile = {
	def fc = fileChooser(dialogTitle:"Choose a directory", 
	        	id:"openDirectoryDialog", fileSelectionMode : JFileChooser.DIRECTORIES_ONLY, 
	        	fileFilter: [getDescription: {''}, accept:{file-> file.isDirectory() }] as FileFilter) {}
    if(fc.showOpenDialog() != JFileChooser.APPROVE_OPTION) return //user cancelled
    baseDir = fc.selectedFile
    log("Base directory set to ${baseDir.absolutePath}")
  }
  
  menuBar() {
      menu(text: "File", mnemonic: 'F') {
          menuItem(text: "Open", mnemonic: 'O', actionPerformed: { chooseFile() })
          menuItem(text: "Exit", mnemonic: 'X', actionPerformed: { dispose() })
      }
      menu(text: "Run", mnemonic: 'R') {
          menuItem(text: "Go", mnemonic: 'G', actionPerformed: {100.times{log(it) }})
      }
  }
  scrollPane(preferredSize: [160, -1]) {
	  outputArea = textArea(editable: false)
  }

}


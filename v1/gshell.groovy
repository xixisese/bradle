import org.codehaus.groovy.control.CompilerConfiguration
import Project

def config = new CompilerConfiguration()
config.scriptBaseClass = 'Project'
def shell = new GroovyShell(this.class.classLoader, config)

def script = new File("build.bradle")
//shell parse return the instance of the scriptBaseClass
def projInstance = shell.parse(script)
//run script
projInstance.run()

//handle commandline parameters
taskName=this.args[0]
projInstance.tasks.run(taskName)
